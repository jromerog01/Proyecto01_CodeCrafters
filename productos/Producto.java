package productos;

public abstract class Producto {

    protected String nombre;
    protected String departamento;
    protected double precio;
    protected int codigoBarras;

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCodigoBarras() {
        return codigoBarras;
    }

    @Override
    public String toString() {
        return getNombre() + " - $" + getPrecio();
    }

    // Método para aplicar descuento directamente al producto
    public void aplicarDescuento(double porcentaje) {
        this.precio = this.precio * (1 - porcentaje / 100);
    }
}
