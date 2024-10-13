package productos;

import java.util.ArrayList;

public class Carrito {

    private ArrayList<Producto> productos;

    public Carrito() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void imprimirCarrito() {
        System.out.println("----------- TICKET DEL CARRITO -----------");
        for (Producto producto : productos) {
            System.out.println("ID: " + producto.getCodigoBarras() + " " + producto.getNombre() + " - $" + producto.getPrecio());
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

}
