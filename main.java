import productos.Carrito;
import productos.Catalogo;
import productos.Producto;
import java.util.Scanner;
import idiomas.*;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carrito carrito = new Carrito();

        System.out.println("Bienvenido a CheemsMart");
        System.out.println("Por favor, selecciona tu país (USA, Mexico, Brasil): ");
        String paisCliente = scanner.nextLine();

        // Crear el catálogo según el país del cliente
        Catalogo catalogo = new Catalogo();
        catalogo.crearCatalogo(paisCliente);

        //
        IdiomaCheemsMart menuIdioma;

        switch (paisCliente) {

            case "USA" -> {
                // Menu en Ingles
                menuIdioma = new Ingles();
            }

            case "Mexico" -> {
                // Menu en Español
                menuIdioma = new Espanol();
            }

            case "USA" -> {
                // Menu en Portugues
                menuIdioma = new Portugues();
            }
          default:
            break;
        }

        boolean continuar = true;

        // Interacción principal
        while (continuar) {
            System.out.println(menuIdioma.menuInicio());

            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    // Mostrar el catálogo
                    System.out.println("\nCatálogo de productos:");
                    catalogo.imprimirCatalogo();
                }
                case 2 -> {
                    // Agregar productos al carrito de manera continua
                    boolean agregarProductos = true;
                    while (agregarProductos) {
                        System.out.print(menuIdioma.mensajeCompra());
                        int codigoBarras = scanner.nextInt();

                        // Regresar al menú si el usuario ingresa 0
                        if (codigoBarras == 0) {
                            agregarProductos = false;
                        } else {
                            Producto productoSeleccionado = catalogo.buscarProductoPorCodigo(codigoBarras);

                            if (productoSeleccionado != null) {
                                carrito.agregarProducto(productoSeleccionado);
                                System.out.println(menuIdioma.mensajeCarrito(productoSeleccionado.getNombre()));
                            } else {
                                System.out.println(menuIdioma.mensajeError());
                            }
                        }
                    }
                }
                case 3 -> {
                    // Mostrar el carrito
                    menuIdioma.mensajeCarrito(carrito.calcularTotal(), carrito);
                }
                case 4 -> {
                    // Finalizar compra
                    menuIdioma.mensajeFinalizarCompra(carrito.calcularTotal(), carrito);
                    continuar = false;
                }
                case 5 -> {
                    // Salir
                    System.out.println(menuIdioma.agradecimiento());
                    continuar = false;
                }
                default -> System.out.println(menuIdioma.mensajeInvalido());
            }
        }

        scanner.close();

//        // Suponemos que el cliente es de México
//        String paisCliente = "Mexico";
//
//        Catalogo catalogo = new Catalogo();
//        catalogo.crearCatalogo(paisCliente);  // Crear el catálogo con descuentos según el país
//        catalogo.imprimirCatalogo();  // Imprimir el catálogo
//
//        // Crear el carrito
//        Carrito carrito = new Carrito();
//
//        // Agregar productos del catálogo al carrito
//        Producto licuadora = catalogo.productos.get(5);  // Ejemplo: índice de la licuadora
//        Producto smartTV = catalogo.productos.get(11);  // Ejemplo: índice del SmartTV
//        Producto lifeSavers = catalogo.productos.get(3);
//        Producto waflera = catalogo.productos.get(7);
//
//        carrito.agregarProducto(licuadora);
//        carrito.agregarProducto(smartTV);
//        carrito.agregarProducto(lifeSavers);
//        carrito.agregarProducto(smartTV);
//        carrito.agregarProducto(waflera);
//
//        // Imprimir el carrito con los productos seleccionados
//        carrito.imprimirCarrito();
//
//        // Mostrar el total
//        System.out.println("-------------------------------" + "\nMonto total del carrito: $" + carrito.calcularTotal());

        
    }

}


