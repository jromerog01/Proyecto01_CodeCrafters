package productos.departamentos.alimentos;

public class LifeSaversGummies extends DeptoAlimentos {

    public LifeSaversGummies() {
        this.nombre = "Life Savers Gummies";
        this.departamento = "Alimentos";
        this.precio = 69;
        this.codigoBarras = 7521;
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
