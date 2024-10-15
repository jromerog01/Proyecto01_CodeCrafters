package productos;

public abstract class ProductosDecorator extends Producto {

    /**
     * Metodo abstracto para obtener el nombre del producto
     * @return El nombre del producto
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Metodo abstracto para obtener el departamento del producto
     * @return El departamento del producto
     */
    public String getDepartamento(){
        return this.departamento;
    }

    /**
     * Metodo abstracto para obtener el precio del producto
     * @return El precio del producto
     */
    public double getPrecio(){
        return this.precio;
    }
    
    /**
     * Metodo abstracto para obtener el codigo de barras del producto
     * @return El codigo de barras del producto
     */
    public int getCodigoBarras(){
        return this.codigoBarras;
    }

}
