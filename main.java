import productos.Carrito;
import productos.Catalogo;
import productos.Producto;
import productos.departamentos.alimentos.*;
import productos.departamentos.electrodomesticos.*;
import productos.departamentos.electronica.*;

public class main {

    public static void main(String[] args) {

        String paisCliente = "Brasil";

        //Creamos el catalogo
        Catalogo catalogo = new Catalogo();
        catalogo.crearCatalogo(paisCliente);
        catalogo.imprimirCatalogo();

        //Este es el carrito
        Producto carrito = new Carrito();


        carrito = new ChipsFuegoFlaminHot(carrito);
        carrito = new JackDanielsApple(carrito);
        carrito = new JugoManzanaOrganico(carrito);
        carrito = new LifeSaversGummies(carrito);
        carrito = new ExtractorJugos(carrito);
        carrito = new LicuadoraNinja(carrito);
        carrito = new MolinilloEspecias(carrito);
        carrito = new Waflera(carrito);
        carrito = new CamaraDigital(carrito);
        carrito = new HomeTheater(carrito);
        carrito = new IPhone18ProPlusMax(carrito);
        carrito = new SmartTV(carrito);


        // Imprimir productos y sus precios individuales
        System.out.println(carrito);


        // Calcular e imprimir el precio total
        double total = carrito.getPrecio();
        System.out.println("-------------------------------------");
        System.out.println("Total: $" + total);



    }

}
