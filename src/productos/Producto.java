package productos;

public abstract class Producto {

    protected String nombre;
    protected String departamento;
    protected double precio;
    protected int codigoBarras;

    /**
     * Metodo que devuelve el nombre del producto
     * @return El nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que devuelve el departamento del producto
     * @return El departamento al que pertenece el producto
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Metodo que devuelve el precio del producto
     * @return El precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Metodo que devuelve el codigo de barras del producto
     * @return El codigo de barras del producto
     */
    public int getCodigoBarras() {
        return codigoBarras;
    }

    /**
     * Metodo que devuelve el producto como una cadena
     * @return El producto vuelto una cadena
     */
    @Override
    public String toString() {
        return getNombre() + " - $" + getPrecio();
    }

}
