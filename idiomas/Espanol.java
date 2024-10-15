package idiomas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Espanol extends IdiomaCheemsMart {

    @Override
    public String saludo() {
        return "\nBienvenido a Cheems Mart\n";
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
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaEntrega = semanaSiguiente.format(formato);
        return "La fecha de entrega esta programada para el dia " + fechaEntrega;
    }

    @Override
    public String menuInicio(){
        return "Menu CheemsMart: \n" +
                  "1. Ver catálogo \n" +
                  "2. Realizar una compra\n" +
                  "3. Cerrar Sesion\n";
    }

    @Override
    public String mensajeCompra() {
        return "Ingresa el código de barras del producto que deseas agregar (o ingresa 0 para regresar al menú):";
    }

    @Override
    public String mensajeError(){
        return "Producto no encontrado. Intenta nuevamente.";
    }


    @Override
    public String mensajeFinalizarCompra(){
        String mensaje = "Gracias por comprar en Cheems Mart";
        return mensaje.toString();
    }

    @Override
    public String mensajeInvalido(){
        return"Opcion invalida. Intente de nuevo";
    }
}
