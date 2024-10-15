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
    public String imprimirCarrito() {
        StringBuilder ticket = new StringBuilder();
        ticket.append("----------- TICKET DEL CARRITO -----------\n");
        for (Producto producto : productos) {
            ticket.append("ID: ").append(producto.getCodigoBarras())
                  .append(" ").append(producto.getNombre())
                  .append(" - $").append(producto.getPrecio()).append("\n");
        }
        return ticket.toString();
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
