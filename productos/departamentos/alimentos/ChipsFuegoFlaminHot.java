package productos.departamentos.alimentos;

import productos.Producto;

public class ChipsFuegoFlaminHot extends DeptoAlimentos {

    private Producto producto;

    public ChipsFuegoFlaminHot(Producto producto) {
        this.producto = producto;
        this.precio = 35;
    }

    @Override
    public String getNombre() {
        return "Chips Fuego Flamin Hot";
    }

    @Override
    public String getDepartamento() {
        return "Alimentos";
    }

    @Override
    public double getPrecio() {
        return producto.getPrecio() + this.precio;
    }

    @Override
    public int getCodigoBarras() {
        return 8425;
    }

    @Override
    public String toString() {
        return producto.toString() + "\n" + getNombre() + " - $" + this.precio;
    }
}
