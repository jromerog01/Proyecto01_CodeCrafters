package productos.departamentos.electronica;

public class CamaraDigital extends DeptoElectronica {

    public CamaraDigital(){
        this.nombre = "Camara Digital";
        this.departamento = "Electronica";
        this.precio = 4000;
        this.codigoBarras = 1921;
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
