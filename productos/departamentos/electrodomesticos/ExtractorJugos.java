package productos.departamentos.electrodomesticos;

import productos.Producto;

public class ExtractorJugos extends DeptoElectrodomesticos{

    private Producto producto;

    public ExtractorJugos(Producto producto){
        this.producto = producto;
        this.precio = 1999;
    }

    @Override
    public String getNombre() {
        return "Extractor de Jugos";
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
        return 1003;
    }

    @Override
    public String toString() {
        // Llama recursivamente al toString() del producto anterior para acumular la lista
        return producto.toString() + "\n" + getNombre() + " - $" + this.precio;
    }
}

