package productos.departamentos.electronica;

public class HomeTheater extends DeptoElectronica {

    public HomeTheater() {
        this.nombre = "Home Theater";
        this.departamento = "Electronica";
        this.precio = 8000;
        this.codigoBarras = 1112;
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
