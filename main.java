import productos.Carrito;
import productos.Catalogo;
import productos.Producto;

public class main {

    public static void main(String[] args) {

        // Suponemos que el cliente es de México
        String paisCliente = "Mexico";

        Catalogo catalogo = new Catalogo();
        catalogo.crearCatalogo(paisCliente);  // Crear el catálogo con descuentos según el país
        catalogo.imprimirCatalogo();  // Imprimir el catálogo

        // Crear el carrito
        Carrito carrito = new Carrito();

        // Agregar productos del catálogo al carrito
        Producto licuadora = catalogo.productos.get(5);  // Ejemplo: índice de la licuadora
        Producto smartTV = catalogo.productos.get(11);  // Ejemplo: índice del SmartTV
        Producto lifeSavers = catalogo.productos.get(3);

        carrito.agregarProducto(licuadora);
        carrito.agregarProducto(smartTV);
        carrito.agregarProducto(lifeSavers);
        carrito.agregarProducto(smartTV);

        // Imprimir el carrito con los productos seleccionados
        carrito.imprimirCarrito();

        // Mostrar el total
        System.out.println("Total del carrito: $" + carrito.calcularTotal());
    }

}


