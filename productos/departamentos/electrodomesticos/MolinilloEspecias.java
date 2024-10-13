package productos.departamentos.electrodomesticos;

import productos.Carrito;
import productos.Producto;

public class MolinilloEspecias extends DeptoElectrodomesticos {

    private Producto producto;

    public MolinilloEspecias(Producto producto){
        this.producto = producto;
        this.precio = 219;
    }

    @Override
    public String getNombre() {
        return "Molinillo de Especias";
    }

    @Override
    public String getDepartamento() {
       return "Electrodomesticos";
    }

    @Override
    public double getPrecio() {
        // Suma el precio del producto decorado al precio del decorador actual
        return producto.getPrecio() + this.precio;
    }

    @Override
    public int getCodigoBarras() {
        return 5736;
    }

    @Override
    public String toString() {
        // Llama recursivamente al toString() del producto anterior para acumular la lista
        return producto.toString() + "\n" + getNombre() + " - $" + this.precio;
    }

    
}
