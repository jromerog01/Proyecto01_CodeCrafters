package productos.departamentos.alimentos;

public class JugoManzanaOrganico extends DeptoAlimentos {

    public JugoManzanaOrganico() {
        this.nombre = "Jugo de Manzana Organico";
        this.departamento = "Alimentos";
        this.precio = 57;
        this.codigoBarras = 9482;
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
