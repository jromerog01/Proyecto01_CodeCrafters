package productos;

public abstract class ProductosDecorator extends Producto {

    public abstract String getNombre();

    public abstract String getDepartamento();

    public abstract double getPrecio();

    public abstract int getCodigoBarras();

}
