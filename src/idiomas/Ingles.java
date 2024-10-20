package idiomas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Ingles implements IdiomaCheemsMart {

    /**
    * Metodo que regresa el mensaje de Bienvenida
    * @return Mensaje de saludo correspondiente al idioma 
    */
    @Override
    public String saludo() {
        return "\nWelcome to Cheems Mart\n";
    }

    /**
    * Metodo que regresa el mensaje de Despedida
    * @return Mensaje de despedida correspondiente al idioma 
    */
    @Override
    public String despedida() {
        return "\n See you later...";
    }

    /**
    * Metodo que regresa el mensaje de Agradecimiento 
    * @return Mensaje de agradecimiento correspondiente al idioma 
    */
    @Override 
    public String agradecimiento(){
        return "Thank you for visiting Cheems Mart \n" + 
                        "Please come back soon...";
    }

    /**
    * Metodo que regresa el mensaje de la fecha estimada d entrega  
    * @return Mensaje de fecha estimada  
    */
    @Override
    public String fechaEntrega(){
        LocalDate semanaSiguiente = LocalDate.now().plusDays(7);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaEntrega = semanaSiguiente.format(formato);
        return "The delivery date is scheduled for the day " + fechaEntrega;
    }

    /**
    * Metodo que regresa el mensaje de Menu de Incio 
    * @return Mensaje del menu de inicio correspondiente al idioma 
    */
    @Override
    public String menuInicio(){
        return "CheemsMart Menu: \n" +
                    "1. View catalog \n" +
                    "2. Make a purchase\n" +
                    "3. Close Session\n";
    }

    /**
    * Metodo que regresa el mensaje instruccion compra 
    * @return Mensaje de la instruccion de compra correspondiente al idioma
    */
    @Override
    public String mensajeCompra() {
        return "\n Enter the barcode of the product you want to add (or enter 0 to return to the menu):";
    }

    /**
    * Metodo que regresa el mensaje de Error 
    * @return Mensaje de error cuando no se encuentra el articulo correspondiente al idioma 
    */
    @Override
    public String mensajeError(){
        return "Product not found. Please try again.";
    }

    /**
    * Metodo que regres el mensaje de Finalizar compra
    * @return Mensaje de despedida correspondiente al idioma 
    */
    @Override
    public String mensajeFinalizarCompra(){
        String mensaje = "Thank you for shopping at Cheems Mart";
        return mensaje.toString();
    }

    /**
    * Metodo que regres el mensaje de error del menu
    * @return Mensaje de error menu correspondiente al idioma 
    */
    @Override
    public String mensajeInvalido(){
        return "Invalid option. Please try again.";
    }

    /**
    * Metodo que regres el mensaje del producto agregado
    * @return Mensaje del producto agregado correspondiente al idioma 
    */
    @Override
    public String mensajeProductoAgregado(){
        return "Product added to cart";
    }

    /**
    * Metodo que regres el mensaje del error cuando el presupuesto no alcanza 
    * @return Mensaje del error del presupuesto correspondiente al idioma 
    */
    @Override
    public String mensajeErrorPresupuesto(){
        return "The cart exceeds your budget, the purchase is cancelled";
    }

    /**
     * Metodo que pide al src.usuario que decida entre comprar o salir del carrito
     * @return Mensaje que solicita al src.usuario que ingrese una opcion para comprar;
     */
    @Override
    public String opcionPagarOSalir() {
        return "\nEnter the barcode of the product you want to add (or enter 0 to return to the menu or 1 to make the payment): ";
    }

    /**
     * Metodo que regresa una cadena solicitando al src.usuario que ingrese su numro de cuenta
     * @return Mensaje que solicita el numero de cuenta
     */
    @Override
    public String solicitarNCuenta() {
        return "Enter your account number";
    }

    /**
     * Metodo que devuelve el mensaje que el numero de cuenta es incorrecto 
     * @return Mensaje que el numero de cuentas es incorrecto al registrado
     */
    @Override
    public String nCuentaIncorrecto() {
        return "Incorrect accoun number";
    }

    @Override
    public String intentosRestantes() {
        return "Incorrect account number. You only have 3 attempts";
    }

    @Override
    public String sesionCerrada() {
        return "You have reached the limit of attempts. Closing the program...";
    }

}
