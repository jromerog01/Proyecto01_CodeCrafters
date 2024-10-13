package productos.departamentos.electronica;

import productos.Producto;

public class CamaraDigital extends DeptoElectronica {

    private Producto producto;


    public CamaraDigital(Producto producto){
        this.producto = producto;
        this.precio = 4000;
    }
    
    @Override
    public String getNombre() {
        return "Camara Digital";
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
        return 1921;
    }

    @Override
    public String toString() {
        // Llama recursivamente al toString() del producto anterior para acumular la lista
        return producto.toString() + "\n" + getNombre() + " - $" + this.precio;
    }

}
