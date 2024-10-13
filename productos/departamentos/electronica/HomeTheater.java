package productos.departamentos.electronica;

import productos.Producto;

public class HomeTheater extends DeptoElectronica {

    private Producto producto;

    public HomeTheater(Producto producto) {
        this.producto = producto;
        this.precio = 8000;
    }

    @Override
    public String getNombre() {
        return producto.getNombre() + ", HomeTheater 5.1";
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
        return 1112;
    }

    @Override
    public String toString() {
        // Llama recursivamente al toString() del producto anterior para acumular la lista
        return producto.toString() + "\n" + getNombre() + " - $" + this.precio;
    }
}
