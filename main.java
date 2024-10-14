import productos.Carrito;
import productos.Catalogo;
import productos.Producto;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Carrito carrito = new Carrito();

        System.out.println("Biemnvemnimdom a CheemsMart");
        System.out.println("Por favor, selecciona tu país (USA, Mexico, Brasil): ");
        String paisCliente = scanner.nextLine();

        // Crear el catálogo según el país del cliente
        Catalogo catalogo = new Catalogo();
        catalogo.crearCatalogo(paisCliente);

        boolean continuar = true;

        // Interacción principal
        while (continuar) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Ver catálogo");
            System.out.println("2. Agregar productos al carrito");
            System.out.println("3. Ver carrito");
            System.out.println("4. Finalizar compra");
            System.out.println("5. Salir");

            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    // Mostrar el catálogo
                    System.out.println("\nCatálogo de productos:");
                    //catalogo.imprimirCatalogo();
                }
                case 2 -> {
                    // Agregar productos al carrito de manera continua
                    boolean agregarProductos = true;
                    while (agregarProductos) {
                        System.out.print("Ingresa el código de barras del producto que deseas agregar (o ingresa 0 para regresar al menú): ");
                        int codigoBarras = scanner.nextInt();

                        // Regresar al menú si el usuario ingresa 0
                        if (codigoBarras == 0) {
                            agregarProductos = false;
                        } else {
                            Producto productoSeleccionado = catalogo.buscarProductoPorCodigo(codigoBarras);

                            if (productoSeleccionado != null) {
                                carrito.agregarProducto(productoSeleccionado);
                                System.out.println("Producto agregado al carrito: " + productoSeleccionado.getNombre());
                            } else {
                                System.out.println("Producto no encontrado. Intenta nuevamente.");
                            }
                        }
                    }
                }
                case 3 -> {
                    // Mostrar el carrito
                    System.out.println("\nCarrito de compras:");
                    carrito.imprimirCarrito();
                    System.out.println("Total: $" + carrito.calcularTotal());
                }
                case 4 -> {
                    // Finalizar compra
                    System.out.println("\nFinalizando compra...");
                    carrito.imprimirCarrito();
                    System.out.println("Total: $" + carrito.calcularTotal());
                    System.out.println("Gracias por comprar en CheemsMart.");
                    continuar = false;
                }
                case 5 -> {
                    // Salir
                    System.out.println("Gracias por visitar CheemsMart.");
                    continuar = false;
                }
                default -> System.out.println("Opción inválida. Intenta nuevamente.");
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


