package productos.departamentos.electrodomesticos;

import productos.Producto;
import productos.ProductosDecorator;
import productos.departamentos.ProductoFactory;

public class DeptoElectrodomesticos extends ProductosDecorator implements ProductoFactory {

    public Producto crearProducto(String tipo){
        switch (tipo) {
            case "ExtractorJugos":
                return new ExtractorJugos();
            case "LicuadoraNinja":
                return new LicuadoraNinja();
            case "MolinilloEspecias":
                return new MolinilloEspecias();
            case "Waflera":
                return new Waflera();
            default:
                throw new IllegalArgumentException("Producto de Electrodomésticos no encontrado");
        }
    }
}
