package productos.departamentos.alimentos;

public class ChipsFuegoFlaminHot extends DeptoAlimentos {

    public ChipsFuegoFlaminHot() {
        this.nombre = "Chips Fuego Flamin Hot";
        this.departamento = "Alimentos";
        this.precio = 35;
        this.codigoBarras = 8425;
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
