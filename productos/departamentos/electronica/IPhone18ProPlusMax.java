package productos.departamentos.electronica;

import productos.Producto;

public class IPhone18ProPlusMax extends DeptoElectronica {

    Producto producto;

    public IPhone18ProPlusMax(Producto producto){
        this.producto = producto;
        this.precio = 39900;
    }

    @Override
    public String getNombre() {
        return "iPhone 18 Pro Plus Max 512GB";
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
        return 1231;
    }

    @Override
    public String toString() {
        // Llama recursivamente al toString() del producto anterior para acumular la lista
        return producto.toString() + "\n" + getNombre() + " - $" + this.precio;
    }


}
