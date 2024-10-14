package productos;

import java.util.ArrayList;

public class Carrito {

    private ArrayList<Producto> productos;

    /**
     * Metodo constructor de Carrito
     */
    public Carrito() {
        productos = new ArrayList<>();
    }
    
    /**
     * Metodo que agrega producto al carriro
     * @param producto El producto que se desea agregar al carriro
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    /**
     * Metodo que imprime todos los productos agregados al carrito
     */
    public void imprimirCarrito() {
        System.out.println("----------- TICKET DEL CARRITO -----------");
        for (Producto producto : productos) {
            System.out.println("ID: " + producto.getCodigoBarras() + " " + producto.getNombre() + " - $" + producto.getPrecio());
        }
    }

    /**
     * Metodo que devuelve el total agregado al carrito de compras
     * @return El total de las compras
     */
    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

}
