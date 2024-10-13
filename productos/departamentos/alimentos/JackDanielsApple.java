package productos.departamentos.alimentos;

public class JackDanielsApple extends DeptoAlimentos {

    public JackDanielsApple() {
        this.nombre = "Jack Daniels Apple";
        this.departamento = "Alimentos";
        this.precio = 361;
        this.codigoBarras = 8361;
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
