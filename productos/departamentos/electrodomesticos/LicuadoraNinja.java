package productos.departamentos.electrodomesticos;

import productos.Producto;

public class LicuadoraNinja extends DeptoElectrodomesticos {

    private Producto producto;

    public LicuadoraNinja(Producto producto) {
        this.producto = producto;
        this.precio = 1881;
    }

    @Override
    public String getNombre() {
        return "Licuadora Ninja";
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
        return 9461;
    }

    @Override
    public String toString() {
        return producto.toString() + "\n" + getNombre() + " - $" + this.precio;
    }
}
