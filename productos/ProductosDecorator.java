package productos;

public abstract class ProductosDecorator extends Producto {

    /**
     * Metodo abstracto para obtener el nombre del producto
     * @return El nombre del producto
     */
    public abstract String getNombre();

    /**
     * Metodo abstracto para obtener el departamento del producto
     * @return El departamento del producto
     */
    public abstract String getDepartamento();

    /**
     * Metodo abstracto para obtener el precio del producto
     * @return El precio del producto
     */
    public abstract double getPrecio();
    
    /**
     * Metodo abstracto para obtener el codigo de barras del producto
     * @return El codigo de barras del producto
     */
    public abstract int getCodigoBarras();

}
