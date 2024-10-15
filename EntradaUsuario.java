import java.rmi.Naming;
import java.util.Scanner;

public class EntradaUsuario  {
    public static void main(String[] args) {

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

    // Métodos existentes de conexión con el servidor:

    public static boolean acceder(String usuario, String contrasena) {
        try {
            CheemsMartRemote cheems = (CheemsMartRemote) Naming.lookup("rmi://localhost/CheemsMartServidor");
            String respuesta = cheems.acceder(usuario, contrasena);
            System.out.println(respuesta);
            // Verificar si el acceso fue exitoso
            return respuesta.contains("Bienvenido");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void miniMenu() {
        try {
            CheemsMartRemote cheems = (CheemsMartRemote) Naming.lookup("rmi://localhost/CheemsMartServidor");
            String miniMenu = cheems.miniMenu();
            System.out.println(miniMenu);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verCatalogo() {
        try {
            CheemsMartRemote cheems = (CheemsMartRemote) Naming.lookup("rmi://localhost/CheemsMartServidor");
            String catalogo = cheems.verCatalogo();
            System.out.println(catalogo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void agregarCarrito(int codigoBarras) {
        try {
            CheemsMartRemote cheems = (CheemsMartRemote) Naming.lookup("rmi://localhost/CheemsMartServidor");
            String resultado = cheems.agregarCarrito(codigoBarras);
            System.out.println(resultado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
     */
    public static void realizarCompra(Scanner scanner) {
        verCatalogo(); // Mostrar el catálogo

        while (true) {
            try {
            // Pedir al usuario el código de barras del producto
            System.out.print("\nIngresa el código de barras del producto que deseas agregar (o ingresa 0 para regresar al menú o 1 para realizar el cobro): ");
            int codigoBarras = Integer.parseInt(scanner.nextLine());

            if (codigoBarras == 0) {
                // Salir del ciclo si el usuario ingresa 0
                break;
            }

            if(codigoBarras == 1){
                try {
                    CheemsMartRemote cheems = (CheemsMartRemote) Naming.lookup("rmi://localhost/CheemsMartServidor");
                    System.out.println("Ingrese su numero de Cuenta");
                    int nCuenta = Integer.parseInt(scanner.nextLine());
                    if(cheems.autentificacion(nCuenta)){
                        realizarCobro();
                    }else{
                        System.out.println("N.cuenta incorrecto");
                    }
                    
                } catch (Exception e) {
                    System.out.println("Error: Ingresa un numero valido1");
                }
                break;
            }

            

            // Agregar producto al carrito
            agregarCarrito(codigoBarras);
            } catch (NumberFormatException e) {
            System.out.println("Error: Ingresa un número válido.");

            
            }
        }        
    }

    public static void realizarCobro(){
        try {
            CheemsMartRemote cheems = (CheemsMartRemote) Naming.lookup("rmi://localhost/CheemsMartServidor");
            System.out.println("\n"+cheems.realizarCobro());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

    


