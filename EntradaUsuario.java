import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class EntradaUsuario  {
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println(" ---------------- Bienvenido a CheemsMart Online ---------------- ");
            System.out.println("Ingresa Usuario: ");
            String username = scanner.nextLine();
            System.out.println("Ingresa contraseña: ");
            String password = scanner.nextLine();
            
            // Verificar acceso
            boolean accesoExitoso = acceder(username, password);

            if (accesoExitoso) {
                // Menu principal en bucle
                boolean continuar = true;
                while (continuar) {
                    // Mostrar el menú principal
                    miniMenu();
                    try {
                        int opcion = Integer.parseInt(scanner.nextLine());

                        switch (opcion) {
                            case 1 -> {
                                // Ver catálogo
                                verCatalogo();
                            }
                            case 2 -> {
                                // Realizar compra y agregar productos al carrito
                                realizarCompra(scanner);
                            }
                            case 3 -> {
                                // Salir
                                continuar = false;
                                System.out.println("\nGracias por visitar CheemsMart.");
                            }
                            default -> {
                                System.out.println("\nOpción inválida. Intenta nuevamente.");
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("\nError: Ingresa un número válido.");
                    }
                }
            } else {
                System.out.println("\nUsuario o contraseña incorrectos. Intenta nuevamente.");
            }
            System.out.println("\nDesea salir del programa? s/N");
            if(scanner.nextLine().equals("s")){
                break;
            }
        }
    }

    /**
     * Metodo que valida si el usuario esta registrado.
     * @param usuario Nombre de usuario.
     * @param contrasena Contrasena que permite el acceso del usuario.
     * @return True si el usuario esta gusrado, False de lo contrario.
     */
    public static boolean acceder(String usuario, String contrasena) {
        try {
            CheemsMartRemote cheems = (CheemsMartRemote) Naming.lookup("rmi://localhost/CheemsMartServidor");
            String respuesta = cheems.acceder(usuario, contrasena);
            System.out.println(respuesta);
            // Verificar si el acceso fue exitoso
            return (respuesta.contains("Bienvenido") || respuesta.contains("Welcome") || respuesta.contains("Bem-vindo"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo que imprime el menu de inicio de opciones del cliente
     */
    public static void miniMenu() {
        try {
            CheemsMartRemote cheems = (CheemsMartRemote) Naming.lookup("rmi://localhost/CheemsMartServidor");
            String miniMenu = cheems.miniMenu();
            System.out.println(miniMenu);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que imprime el catalogo.
     */
    public static void verCatalogo() {
        try {
            CheemsMartRemote cheems = (CheemsMartRemote) Naming.lookup("rmi://localhost/CheemsMartServidor");
            String catalogo = cheems.verCatalogo();
            System.out.println(catalogo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que agrega productos al carriro
     * @param codigoBarras El codigo de barras del producto que deseamos anadir al carrito.
     */
    public static void agregarCarrito(int codigoBarras) {
        try {
            CheemsMartRemote cheems = (CheemsMartRemote) Naming.lookup("rmi://localhost/CheemsMartServidor");
            String resultado = cheems.agregarCarrito(codigoBarras);
            System.out.println(resultado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que imprime el carrito guardado.
     */
    public static void verCarrito() {
        try {
            CheemsMartRemote cheems = (CheemsMartRemote) Naming.lookup("rmi://localhost/CheemsMartServidor");
            String carrito = cheems.verCarrito();
            System.out.println(carrito);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que realiza una compra
     * @param scanner El scanner para que el usuario pueda ingresar informacion
     * @throws RemoteException 
     * @throws NotBoundException 
     * @throws MalformedURLException 
     */
    public static void realizarCompra(Scanner scanner) throws RemoteException, MalformedURLException, NotBoundException {
        verCatalogo(); // Mostrar el catálogo
        String mensajeError = "";

        while (true) {
            try {
                CheemsMartRemote cheems = (CheemsMartRemote) Naming.lookup("rmi://localhost/CheemsMartServidor");
                // Pedir al usuario el código de barras del producto
                String mensaje = cheems.menuMensajes(9);
                mensajeError = cheems.menuMensajes(5);
                System.out.print(mensaje);
                int codigoBarras = Integer.parseInt(scanner.nextLine());

            if (codigoBarras == 0) {
                // Salir del ciclo si el usuario ingresa 0
                break;
            }

            if(codigoBarras == 1){
                mensaje = cheems.menuMensajes(10);
                System.out.println(mensaje);
                int nCuenta = Integer.parseInt(scanner.nextLine());
                if(cheems.autentificacion(nCuenta)){
                    realizarCobro();
                }else{
                    mensaje = cheems.menuMensajes(11);
                    System.out.println(mensaje);
                }
                break;
            }

            

            // Agregar producto al carrito
            agregarCarrito(codigoBarras);
            } catch (NumberFormatException e) {
                System.out.println(mensajeError);

            
            }
        }        
    }

    /**
     * Metodo que realiza el cobro en el servidor.
     */
    public static void realizarCobro(){
        try {
            CheemsMartRemote cheems = (CheemsMartRemote) Naming.lookup("rmi://localhost/CheemsMartServidor");
            System.out.println("\n"+cheems.realizarCobro());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

    


