package productos.departamentos.electronica;

public class IPhone18ProPlusMax extends DeptoElectronica {

    public IPhone18ProPlusMax(){
        this.nombre = "iPhone 18 Pro Plus Max";
        this.departamento = "Electronica";
        this.precio = 39900;
        this.codigoBarras = 1231;
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
