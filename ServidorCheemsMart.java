import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import idiomas.*;
import productos.*;
import usuario.ListaUsuarios;
import usuario.Usuario;

public class ServidorCheemsMart extends UnicastRemoteObject implements CheemsMartRemote {

    private static final long serialVersionUID = 1L;
    Usuario usuario;
    String paisDescuento, paisUsuario, paisMenu;
    ListaUsuarios lista;
    Catalogo catalogo; 
    Carrito carrito;
    IdiomaCheemsMart menuIdioma; 

    /**
     * Metodo constructor del ServidorCheemsMart
     * @throws RemoteException 
     */
    public ServidorCheemsMart() throws RemoteException{
        this.paisDescuento = crearDescuento();
        this.paisUsuario = null;
        this.paisMenu = null;
        this.carrito = new Carrito();
        this.catalogo = Catalogo.getInstance();
        this.lista = new ListaUsuarios();
        lista.registrar(new Usuario("paco", "1234", "Francisco", "5545341234", "Calle Ignacio Zaragoza 56, Centro de Azcapotzalco, Azcapotzalco, 02000 Ciudad de México, CDMX", 123, "Mexico", 1));
        lista.registrar(new Usuario("jguns", "5678", "Jose", "911", "1600 Pennsylvania Avenue NW, Washington, DC 20500, Estados Unidos", 911, "USA", 2));
        lista.registrar(new Usuario("neyjr", "10pele", "NeymarJR", "55121212322", "Parque Nacional da Tijuca - Alto da Boa Vista, Rio de Janeiro - RJ, Brasil", 1010, "Brasil", 3));
    }

    /**
     * Metodo que valida el acceso de un cliente usando su usuario y contrasena
     * @param usuario El usuario del cliente
     * @param contrasena La contrasena del cliente
     * @return Una cadena dando la bienvenida en caso de que si este registrado
     */
    public String acceder(String usuario, String contrasena){
        Iterator<Usuario> iterador = lista.iterator();
        while(iterador.hasNext()) {
            Usuario u = iterador.next();
            if(u.getUsuario().equals(usuario) && u.getContrasena().equals(contrasena)){
                this.usuario = u;
                this.paisMenu = this.usuario.getPais();
                if(this.usuario.getPais().equals(this.paisDescuento)){
                    this.paisUsuario = this.usuario.getPais();
                }

                if (this.paisMenu.equals("Mexico")) {
                    this.menuIdioma = new Espanol();
                }
                else if(this.paisMenu.equals("USA")) {
                    this.menuIdioma = new Ingles();                  
                }
                else {
                    this.menuIdioma = new Portugues();
                }
                
                return this.menuIdioma.saludo() + this.usuario.getNombre() + "\n" + this.usuario.recibirNotificacion(lista.crearNotificacion(this.paisUsuario)+ "\n"+ bienvenido + "\n" + a + "\n" +cheemMart+ "\n\n" + cheems);
            }
        }
        return "";
    }

    /**
     * Metodo que decide de manera azarosa el pais que tiene descuento
     * @return El nombre del pais que reciba un descuento
     */
    private String crearDescuento(){
        int r = (int) (Math.random()*3+1);
        switch (r) {
            case 1:
                return "Mexico";
            case 2:
                return "USA";
            case 3:
                return "Brasil";
            default:
                return "";
        }
    }   

    /**
     * Metodo que devuelve el menu de entrada
     * @return El menu de acciones de entrada
     */
    public String miniMenu(){
        return menuIdioma.menuInicio();
    }

    /**
     * Metodo que devuelve catalogo
     * @return La cadena que contiene el catalogo
     */
    public String verCatalogo(){
        this.catalogo.crearCatalogo(this.paisUsuario);
        return this.catalogo.getCatalogo();
    }

    /**
     * Metodo que regresa el mensaje instruccion compra 
     * @return Mensaje de la instruccion de compra correspondiente al idioma
     */
    public String mensajeCarrito1(){
        return this.menuIdioma.mensajeCompra(); 
    }

    /**
     * Metodo que agrega al carrito los productos que se desean comprar
     * @param codigoBarras El codigo de barras del producto que se desea comprar
     * @return Mensaje que ya se agrego o hay un error segun el caso 
     */
    public String agregarCarrito(int codigoBarras) {
        Producto productoSeleccionado = catalogo.buscarProductoPorCodigo(codigoBarras);
        
        if (productoSeleccionado != null) {
            carrito.agregarProducto(productoSeleccionado);
            return this.menuIdioma.mensajeProductoAgregado() + productoSeleccionado.getNombre();
        } else {
            return this.menuIdioma.mensajeError();
        }
    }

    /**
     * Metodo que muestra el carrito
     * @return Lo que se va a comprar en el carrito
     */
    public String verCarrito(){
        return carrito.imprimirCarrito() + "\nTOTAL: $" + carrito.calcularTotal() +"\n";
    }

    /**
     * Metodo que valida si el usuario ingreso su numero de cuenta bacaria correcto
     * @param nCuenta El numero de cuenta ingresado por el usuario
     * @return True si es el numero de cuenta registrado, False de lo contrario
     */
    public boolean autentificacion(int nCuenta){
        if(nCuenta == this.usuario.getCuentaBancaria()){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metodo que realiza el cobro al cliente
     * @return El ticket en caso de tener la capacidad de comprar, mensaje de error de no alcanzarle 
     */
    public String realizarCobro(){
        if(this.usuario.getDinero() < carrito.calcularTotal()){
            carrito = new Carrito();
            return this.menuIdioma.mensajeErrorPresupuesto();
        }
        this.usuario.cobrar(carrito.calcularTotal());
        String ticket = verCarrito();
        carrito = new Carrito();
        return menuMensajes(2) + "\n" + ticket + "\n" + menuMensajes(3);
    }

    /**
     * Menu que permite acceder a mensajes predefinidos del lado del cliente
     * @param m El numero del mensaje que deseamos acceder
     * @return El mensaje solicitado
     */
    public String menuMensajes(int m){
        String mensaje = "";
        switch (m) {
            case 1:
                mensaje = menuIdioma.saludo();
                break;
            case 2:
                mensaje = menuIdioma.agradecimiento();
                break;
            case 3:
                mensaje = menuIdioma.fechaEntrega();
                break;
            case 4:
                mensaje = menuIdioma.mensajeCompra();
                break;
            case 5:
                mensaje = menuIdioma.mensajeError();
                break;
            case 6:
                mensaje = menuIdioma.mensajeFinalizarCompra();
                break;
            case 7:
                mensaje = menuIdioma.mensajeInvalido();
                break;
            case 8:
                mensaje = menuIdioma.despedida();
                break;
            case 9:
                mensaje = menuIdioma.opcionPagarOSalir();
                break;
            case 10:
                mensaje = menuIdioma.solicitarNCuenta();
                break;
            case 11:
                mensaje = menuIdioma.nCuentaIncorrecto(); 
        }
        return mensaje;
    }


    public static void main(String[] args) {
        try {
            // Crear una instancia del servidor e iniciar el registro RMI
            CheemsMartRemote servidor = new ServidorCheemsMart();
            Naming.rebind("CheemsMartServidor", (ServidorCheemsMart) servidor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String cheems = "⠀⠀⠀⠀⠀    ⢸⣳⠦⢖⣒⢲⣲⡦⢤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⡴⢻⣦⡲⠤⡀⠹⡋⢷⡇⣿⡷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⢼⢠⣿⡟⠃⢀⣠⡄⠱⠀⣿⣿⠛⢻⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠠⣿⣿⣛⡀⠚⠟⠛⠁⠀⠀⠙⠈⣧⣰⣽⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⣠⣾⣿⡟⠏⠀⠀⠀⠀⠀⠀⡀⠀⣸⡟⢃⠼⢧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⢰⣿⣿⡿⢆⣀⢠⡶⠀⠀⠀⣠⠆⠐⠁⠀⠃⢀⣼⢧⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠈⠛⠳⡾⡾⠛⠀⠀⠀⡎⠁⠀⠀⠀⡀⠀⠈⠁⠀⠳⡀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⢹⠀⠀⠀⠀⠀⢣⡀⠀⣠⠖⠁⠀⠀⠀⠀⢠⡟⢦⡀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⢸⡀⠀⠀⠀⠀⠈⠣⠊⠁⠀⠀⠀⠀⠀⢠⠟⠇⢀⣿⣄⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⡾⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠴⠀⠃⠀⠀⠀⢼⡏⠘⢇⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⢠⣇⡀⠀⠀⠀⠀⠀⢀⠤⠒⠁⠀⢀⡄⠀⠀⠀⢰⠊⠀⠀⣾⡄⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠸⡿⢤⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⡾⠂⠀⠀⠘⠉⠀⠀⣴⢻⢷⡀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⢿⠬⠑⠤⠀⠀⠀⠀⠀⠀⣠⠞⠁⠀⠀⠀⢀⠀⠀⠐⠃⢘⣿⣷⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⣼⡇⠀⠀⠀⠀⠀⠀⠀⡘⠁⡀⠀⠀⠀⢠⡟⠀⠀⠀⠟⣈⣻⣿⡇\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⣻⡇⠀⠀⣸⡁⠀⠀⠀⢷⣸⠀⠀⠀⠀⣯⠀⣄⣫⣤⣺⣿⣿⡿⠀\n" + //
                "⠀⠀⠀⠀⠀⣀⠤⠚⣹⡂⠀⢰⣿⣿⣦⠤⠤⠾⡟⠀⠀⠀⣼⣿⣧⣿⣿⣿⣿⣿⠟⠁⠀\n" + //
                "⢀⣠⠒⠋⠉⢁⣠⠴⣻⠁⢠⣼⠛⠁⠀⠀⠀⠀⣷⠀⠀⢠⣿⣿⣿⣿⣿⣿⠟⠉⠀⠀⠀\n" + //
                "⠈⠛⠛⠒⠉⠉⣀⢤⠃⢀⣿⠷⠴⠤⣄⣀⡀⠀⡿⠀⢀⣾⣿⣿⣿⠿⠛⠁⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⣠⠤⠒⠉⡠⠃⠀⢨⠏⠀⠀⠀⠀⠀⠉⠉⡇⠀⢸⡟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠈⠛⠧⣶⠟⢠⠀⣠⠋⠀⠀⠀⠀⠀⠀⠀⢠⠇⠀⢸⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠿⢴⡷⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⡞⠀⠀⢸⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⡄⢀⡀⢸⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⣇⣸⡥⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";

                String bienvenido = 
                "______ _____ _____ _   _ _   _ _____ _   _ ___________ _____" + "\n" +
                "| ___ \\_   _|  ___| \\ | | | | |  ___| \\ | |_   _|  _  \\  _  |" + "\n" + 
                "| |_/ / | | | |__ |  \\| | | | | |__ |  \\| | | | | | | | | | |" + "\n" +
                "| ___ \\ | | |  __|| . ` | | | |  __|| . ` | | | | | | | | | |" + "\n" +
                " | |_/ /_| |_| |___| |\\ \\ \\_/ / |___| |\\  |_| |_| |/ /\\ \\_/ /" + "\n" +
                "\\____/ \\___/\\____/\\_| \\_/\\___/\\____/\\_| \\_/\\___/|___/  \\___/ ";

                String a = 
                 "  ___ " + "\n" + 
               " / _ \\ " + "\n" +
               "/ /_\\ \\" + "\n" +
               "|  _  |" + "\n" +
               "| | | |" + "\n" +
               "\\_| |_/";
               
               String cheemMart = 
                " _____  _   _  _____ ________  ___ ________  ___  ___  ______ _____ " + "\n" +
               "/  __ \\| | | ||  ___|  ___|  \\/  |/  ___|  \\/  | / _ \\ | ___ \\_   _| " + "\n" + 
               "| /  \\/| |_| || |__ | |__ | .  . |\\ `--.| .  . |/ /_\\ \\| |_/ / | | " + "\n" +  
               "| |    |  _  ||  __||  __|| |\\/| | `--. \\ |\\/| ||  _  ||    /  | | " + "\n" +  
               "| \\__/\\| | | || |___| |___| |  | |/\\__/ / |  | || | | || |\\ \\  | | " + "\n" +  
                "\\____/\\_| |_/\\____/\\____/\\_|  |_/\\____/\\_|  |_/\\_| |_/\\_| \\_\\| \\_/ ";
                                                                                   
                                                                                   
                                
                                                                                            
                      
                      

    
}
