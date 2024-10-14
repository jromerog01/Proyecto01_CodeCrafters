package idiomas
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Espanol implements IdiomaCheemsMart {

    @Override
    public String saludo() {
        return "Bienvenido a Cheems Mart";
    }

    @Override
    public String despedida() {
        return "Hasta luego... ";
    }

    @Override 
    public String agradecimiento(){
        return "Gracias por su visita a Cheems Mart \n Vuelva pronto...";
    }

    @Override
    public String fechaEntrega(){
        LocalDate semanaSiguiente = LocalDate.now().plusDays(7);
        DataTimeFormatter formato = DataTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaEntrega = semanaSiguiente.format(formato);
        return "La fehca de entrega esta programada para el dia " + fecha;
    }

    @Override
    public String menuInicio(){
        return "Menu Principal \n" +
                  "1. Ver catálogo \n" +
                  "2. Agregar productos al carrito \n" +
                  "3. Ver carrito \n" +
                  "4. Finalizar Compra \n" +
                  "5. Salir";
    }

    @Override
    public String mensajeCompra() {
        return "Ingresa el código de barras del producto que deseas agregar (o ingresa 0 para regresar al menú):";
    }

    @Override
    public String mensajeCarrito(String producto){
        return "Producto agregado al carrito" + producto;
    }

    @Override
    public String mensajeError(){
        return "Producto no encontrado. Intenta nuevamente.";
    }

    @Override
    public String mensajeCarrito(double total, Carrito carrito) {
        System.out.println("Carrito de compras \n");
        carrito.imprimirCarrito();
        return  "Total: $" + String.valueOf(total);
    }

    @Override
    public String mensajeFinalizarCompra(double total, Carrito carrito){
        System.out.println("Finalizando compra...");
        carrito.imprimirCarrito();
        return "Total: $" + String.valueOf(total) +
                "Gracias por comprar en Cheems Mart";
    }

    @Override
    peublic String mensajeInvalido(){
        return"Opcion invalida. Intente de nuevo"
    }
}
