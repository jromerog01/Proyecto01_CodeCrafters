import productos.Carrito;
import productos.Catalogo;
import productos.Producto;
import productos.departamentos.alimentos.*;
import productos.departamentos.electrodomesticos.*;
import productos.departamentos.electronica.*;
import usuario.ListaUsuarios;
import usuario.Usuario;

public class Main {

    public static void main(String[] args) {

        //Creamos el catalogo
        Catalogo catalogo = new Catalogo();
        catalogo.crearCatalogo();
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

        // Crear usuarios y registrarlos
        ListaUsuarios listaU = new ListaUsuarios();
        listaU.registrar(new Usuario("Paco", "1234", "Francisco", "265152", "Azcapo", 123456789, "Mexico", 1));
        System.out.println(listaU.crearNotificacion("Mexico"));
    }

}
