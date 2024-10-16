import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;

import idiomas.Espanol;
import idiomas.IdiomaCheemsMart;
// import idiomas.Ingles;
// import idiomas.Portugues;
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

    public ServidorCheemsMart() throws RemoteException{
        this.paisDescuento = crearDescuento();
        this.paisUsuario = null;
        this.paisMenu = null;
        this.carrito = new Carrito();
        this.catalogo = Catalogo.getInstance();
        this.lista = new ListaUsuarios();
        lista.registrar(new Usuario("paco", "1234", "Francisco", "1234567890", "Tapo", 123, "Mexico", 1));
        lista.registrar(new Usuario("jguns", "1234", "Jose", "1234567890", "Tapo", 123, "USA", 1));
    }


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
                // if(this.paisMenu.equals("USA")) {
                //     this.menuIdioma = new Ingles();                  
                // }
                // else {
                //     this.menuIdioma = new Portugues();
                // }
                return this.menuIdioma.saludo() + this.usuario.getNombre() + "\n" + this.usuario.recibirNotificacion(lista.crearNotificacion(this.paisUsuario)+ "\n"+ bienvenido + "\n" + a + "\n" +cheemMart+ "\n\n" + cheems);
            }
        }
        return "Usuario y/o Contrasena incorrecto";
    }

    private String crearDescuento(){
        int r = (int) (Math.random()*3+1);
        System.out.println(r);
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

    public String miniMenu(){
        return menuIdioma.menuInicio();
    }

    public String verCatalogo(){
        this.catalogo.crearCatalogo(this.paisUsuario);
        return this.catalogo.getCatalogo();
    }

    
    public String mensajeCarrito1(){
        // Falta String template
        return "\nIngresa el código de barras del producto que deseas agregar (o ingresa 0 para regresar al menú): "; 
    }

    public String agregarCarrito(int codigoBarras) {
        Producto productoSeleccionado = catalogo.buscarProductoPorCodigo(codigoBarras);
        
        if (productoSeleccionado != null) {
            carrito.agregarProducto(productoSeleccionado);
            return "Producto agregado al carrito: " + productoSeleccionado.getNombre();
        } else {
            return "Producto no encontrado. Intenta nuevamente.";
        }
    }

    public String verCarrito(){
        return carrito.imprimirCarrito() + "\nTOTAL: $" + carrito.calcularTotal() +"\n";
    }

    public boolean autentificacion(int nCuenta){
        if(nCuenta == this.usuario.getCuentaBancaria()){
            return true;
        }else{
            return false;
        }
    }

    public String realizarCobro(){
        if(this.usuario.getDinero() < carrito.calcularTotal()){
            carrito = new Carrito();
            // Falta template
            return "El carrito excede tu presupuesto se cancela la compra";
        }
        this.usuario.cobrar(carrito.calcularTotal());
        String ticket = verCarrito();
        carrito = new Carrito();
        return menuMensajes(2) + "\n" + ticket;
    }

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
