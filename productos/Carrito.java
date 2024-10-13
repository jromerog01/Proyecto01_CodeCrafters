package productos;

public class Carrito extends Producto{

    public Carrito(){
        this.nombre = "Carrito";
    }

    @Override
    public String getNombre() {
        return "Costo por Servicio";
    }

    public double getPrecio(){
        return 0;
    }

}
