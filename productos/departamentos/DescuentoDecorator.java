package productos.departamentos;

import productos.ProductosDecorator;
import productos.Producto;

public class DescuentoDecorator extends ProductosDecorator {

    private Producto producto;
    private double descuento;

    /**
     * Metodo constructor de DescuentosDecorator
     */
    public DescuentoDecorator(Producto producto, double descuento) {
        this.producto = producto;
        this.descuento = descuento;
    }

    /**
     * Metodo que devuelve el nombre del producto con su respectivo descuento
     * @return El nombre del producto con su respectivo descuento
     */
    @Override
    public String getNombre() {
        return producto.getNombre() + " (con descuento del " + descuento + "%)";

    }

    /**
     * Metodo que devuelve el departamento del producto
     * @return El departamento del producto
     */
    @Override
    public String getDepartamento() {
        return producto.getDepartamento();
    }

    /**
     * Metodo que devuelve el precio del producto ya aplicado el descuento
     * @return El precio del producto ya aplicado descuento
     */
    @Override
    public double getPrecio() {
        // Aplicar descuento y limitar a 2 decimales
        double precioConDescuento = producto.getPrecio() * (1 - descuento / 100);
        return Math.round(precioConDescuento * 100.0) / 100.0;  // Redondear a 2 decimales
    }

    /**
     * Metodo que devuelve el codigo de barras del producto
     * @return El codigo de barras del producto
     */
    @Override
    public int getCodigoBarras() {
        return producto.getCodigoBarras();
    }

    /**
     * Metodo que devuelve el objeto como una cadena
     * @return La cadena que representa el producto
     */
    @Override
    public String toString() {
        return producto.getNombre() + " - Precio original: $" + producto.getPrecio() +
                " / Con descuento: $" + getPrecio();
    }


}
