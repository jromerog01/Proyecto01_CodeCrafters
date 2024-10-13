package productos.departamentos.electrodomesticos;

public class ExtractorJugos extends DeptoElectrodomesticos{

    public ExtractorJugos(){
        this.nombre = "Extractor de Jugos";
        this.departamento = "Electrodomesticos";
        this.precio = 1999;
        this.codigoBarras = 1003;
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

