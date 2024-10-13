package productos.departamentos.alimentos;

import productos.Producto;

public class JugoManzanaOrganico extends DeptoAlimentos {

    private Producto producto;

    public JugoManzanaOrganico(Producto producto) {
        this.producto = producto;
        this.precio = 57;
    }


    @Override
    public String getNombre() {
        return "Jugo de Manzana Organico";
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
        return 9482;
    }

    @Override
    public String toString() {
        // Llama recursivamente al toString() del producto anterior para acumular la lista
        return producto.toString() + "\n" + getNombre() + " - $" + this.precio;
    }
}
