package productos.departamentos.alimentos;

import productos.Producto;

public class LifeSaversGummies extends DeptoAlimentos {

    private Producto producto;

    public LifeSaversGummies(Producto producto) {
        this.producto = producto;
        this.precio = 69;
    }


    @Override
    public String getNombre() {
        return "Life Savers Gummies";
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
        return 7521;
    }

    @Override
    public String toString() {
        // Llama recursivamente al toString() del producto anterior para acumular la lista
        return producto.toString() + "\n" + getNombre() + " - $" + this.precio;
    }
}
