package productos.departamentos.alimentos;

import productos.Producto;

public class JackDanielsApple extends DeptoAlimentos {

    private Producto producto;

    public JackDanielsApple(Producto producto) {
        this.producto = producto;
        this.precio = 361;
    }

    @Override
    public String getNombre() {
        return "Jack Daniels Apple";
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
        return 0;
    }

    @Override
    public String toString() {
        return producto.toString() + "\n" + getNombre() + " - $" + this.precio;
    }
}
