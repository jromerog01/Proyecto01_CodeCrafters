package productos.departamentos.electronica;

public class SmartTV extends DeptoElectronica {

    public SmartTV() {
        this.nombre = "Smart TV";
        this.departamento = "Electronica";
        this.precio = 12000;
        this.codigoBarras = 7482;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getDepartamento() {
        return this.departamento;
    }

    @Override
    public double getPrecio() {
        return this.precio;
    }

    @Override
    public int getCodigoBarras() {
        return this.codigoBarras;
    }
}
