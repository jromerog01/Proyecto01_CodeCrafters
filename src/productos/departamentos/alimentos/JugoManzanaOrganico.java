package productos.departamentos.alimentos;

public class JugoManzanaOrganico extends DeptoAlimentos {

    /**
     * Metodo constructor de Jugo de Manzana Organico
     */
    public JugoManzanaOrganico() {
        this.nombre = "Jugo de Manzana Organico";
        this.departamento = "Alimentos";
        this.precio = 56;
        this.codigoBarras = 7628;
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
