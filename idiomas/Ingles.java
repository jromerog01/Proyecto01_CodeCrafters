package idiomas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Ingles implements IdiomaCheemsMart {

    @Override
    public String saludo() {
        return "\nWelcome to Cheems Mart\n";
    }


    @Override
    public String despedida() {
        return "\n See you later...";
    }

    
    @Override 
    public String agradecimiento(){
        return "Thank you for visiting Cheems Mart \n" + 
                        "Please come back soon...";
    }

    @Override
    public String fechaEntrega(){
        LocalDate semanaSiguiente = LocalDate.now().plusDays(7);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaEntrega = semanaSiguiente.format(formato);
        return "The delivery date is scheduled for the day " + fechaEntrega;
    }

    @Override
    public String menuInicio(){
        return "CheemsMart Menu: \n" +
                    "1. View catalog \n" +
                    "2. Make a purchase\n" +
                    "3. Close Session\n";
    }

    @Override
    public String mensajeCompra() {
        return "\n Enter the barcode of the product you want to add (or enter 0 to return to the menu):";
    }

    @Override
    public String mensajeError(){
        return "Product not found. Please try again.";
    }


    @Override
    public String mensajeFinalizarCompra(){
        String mensaje = "Thank you for shopping at Cheems Mart";
        return mensaje.toString();
    }

    @Override
    public String mensajeInvalido(){
        return "Invalid option. Please try again.";
    }

    @Override
    public String mensajeProductoAgregado(){
        return "Product added to cart";
    }

    @Override
    public String mensajeErrorPresupuesto(){
        return "The cart exceeds your budget, the purchase is cancelled";
    }
}
