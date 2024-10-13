package productos.departamentos.electronica;

import productos.Producto;

public class SmartTV extends DeptoElectronica {

    private Producto producto;

    public SmartTV(Producto producto) {
        this.producto = producto;
        this.precio = 12000;
    }

    @Override
    public String getNombre() {
        return "SmartTV";
    }

    @Override
    public String getDepartamento() {
        return "Electronica";
    }

    @Override
    public double getPrecio() {
        return producto.getPrecio() + this.precio;
    }

    @Override
    public int getCodigoBarras() {
        return 74826;
    }

    @Override
    public String toString() {
        // Llama recursivamente al toString() del producto anterior para acumular la lista
        return producto.toString() + "\n" + getNombre() + " - $" + this.precio;
    }
}
