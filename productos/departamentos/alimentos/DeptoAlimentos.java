package productos.departamentos.alimentos;

import productos.Producto;
import productos.ProductosDecorator;
import productos.departamentos.ProductoFactory;

public class DeptoAlimentos extends ProductosDecorator implements ProductoFactory{

    public Producto crearProducto(String tipo){
        switch (tipo) {
            case "ChipsFuegoFlaminHot":
                return new ChipsFuegoFlaminHot();
            case "JackDanielsApple":
                return new JackDanielsApple();
            case "JugoManzanaOrganico":
                return new JugoManzanaOrganico();
            case "LifeSaversGummies":
                return new LifeSaversGummies();
            default:
                throw new IllegalArgumentException("Producto de Electrodomésticos no encontrado");
        }
    }
}
