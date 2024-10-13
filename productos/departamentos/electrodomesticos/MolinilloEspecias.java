package productos.departamentos.electrodomesticos;

public class MolinilloEspecias extends DeptoElectrodomesticos {

    public MolinilloEspecias(){
        this.nombre = "Molinillo de Especias";
        this.departamento = "Electrodomesticos";
        this.precio = 219;
        this.codigoBarras = 5736;

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
        // Suma el precio del producto decorado al precio del decorador actual
        return this.precio;
    }

    @Override
    public int getCodigoBarras() {
        return this.codigoBarras;
    }

}
