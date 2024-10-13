package productos.departamentos.electrodomesticos;

import productos.departamentos.electronica.DeptoElectronica;

public class Waflera extends DeptoElectronica {

    public Waflera() {
        this.nombre = "Waflera";
        this.departamento = "Electrodomesticos";
        this.precio = 609;
        this.codigoBarras = 2927;
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
