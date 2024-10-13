package productos.departamentos.electrodomesticos;

import productos.Producto;
import productos.departamentos.electronica.DeptoElectronica;

public class Waflera extends DeptoElectronica {

    private Producto producto;

    public Waflera(Producto producto) {
        this.producto = producto;
        this.precio = 609;
    }

    @Override
    public String getNombre() {
        return "Waflera";
    }

    @Override
    public String getDepartamento() {
        return "Electrodomesticos";
    }

    @Override
    public double getPrecio() {
        return producto.getPrecio() + this.precio;
    }

    @Override
    public int getCodigoBarras() {
        return 2927;
    }

    @Override
    public String toString() {
        // Llama recursivamente al toString() del producto anterior para acumular la lista
        return producto.toString() + "\n" + getNombre() + " - $" + this.precio;
    }

}
