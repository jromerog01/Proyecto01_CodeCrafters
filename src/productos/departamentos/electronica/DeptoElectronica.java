package productos.departamentos.electronica;

import productos.Producto;
import productos.ProductosDecorator;
import productos.departamentos.ProductoFactory;

public class DeptoElectronica extends ProductosDecorator implements ProductoFactory{

    public Producto crearProducto(String tipo){
        switch (tipo) {
            case "CamaraDigital":
                return new CamaraDigital();
            case "HomeTheater":
                return new HomeTheater();
            case "IPhone18ProPlusMax":
                return new IPhone18ProPlusMax();
            case "SmartTV":
                return new SmartTV();
            default:
                throw new IllegalArgumentException("Producto  no encontrado" + tipo);
        }
    }
}
