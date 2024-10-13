package productos.departamentos;

import productos.ProductosDecorator;
import productos.Producto;

public class DescuentoDecorator extends ProductosDecorator {

    private Producto producto;
    private double descuento;

    public DescuentoDecorator(Producto producto, double descuento) {
        this.producto = producto;
        this.descuento = descuento;
    }

    @Override
    public String getNombre() {
        return producto.getNombre() + " (con descuento del " + descuento + ")";

    }

    @Override
    public String getDepartamento() {
        return producto.getDepartamento();
    }

    @Override
    public double getPrecio() {
        // Aplicar descuento y limitar a 2 decimales
        double precioConDescuento = producto.getPrecio() * (1 - descuento / 100);
        return Math.round(precioConDescuento * 100.0) / 100.0;  // Redondear a 2 decimales
    }


    @Override
    public int getCodigoBarras() {
        return producto.getCodigoBarras();
    }

    @Override
    public String toString() {
        return producto.getNombre() + " - Precio original: $" + producto.getPrecio() +
                " / Con descuento: $" + getPrecio();
    }


}
