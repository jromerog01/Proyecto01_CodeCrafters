package productos.departamentos.electrodomesticos;

public class ExtractorJugos extends DeptoElectrodomesticos{

    /**
     * Metodo constructor de Extractor de Jugos
     */
    public ExtractorJugos(){
        this.nombre = "Extractor de Jugos";
        this.departamento = "Electrodomesticos";
        this.precio = 1999;
        this.codigoBarras = 1003;
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

