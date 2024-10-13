package productos.departamentos.electrodomesticos;

public class LicuadoraNinja extends DeptoElectrodomesticos {

    public LicuadoraNinja() {
        this.nombre = "Licuadora Ninja";
        this.departamento = "Electrodomesticos";
        this.precio = 1881;
        this.codigoBarras = 9461;
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
