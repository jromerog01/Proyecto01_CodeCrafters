package productos.departamentos.electronica;

public class IPhone18ProPlusMax extends DeptoElectronica {

    /**
     * Metodo constructor del IPhone 18 Pro Plus Max
     */
    public IPhone18ProPlusMax(){
        this.nombre = "iPhone 18 Pro Plus Max";
        this.departamento = "Electronica";
        this.precio = 39900;
        this.codigoBarras = 1231;
    }


    /**
     * Metodo que devuelve el nombre del producto
     * @return El nombre del producto
     */
    @Override
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Metodo que devuelve el departamento del producto
     * @return El departamento del producto
     */
    @Override
    public String getDepartamento() {
        return this.departamento;
    }

    /**
     * Metodo que devuelve el precio del producto
     * @return El precio del producto
     */
    @Override
    public double getPrecio() {
        return this.precio;
    }

    /**
     * Metodo que devuelve el codigo de barras del producto
     * @return El codigo de barras del producto
     */
    @Override
    public int getCodigoBarras() {
        return this.codigoBarras;
    }

}
