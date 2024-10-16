package idiomas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Espanol implements IdiomaCheemsMart {

    /**
    * Metodo que regresa el mensaje de Bienvenida
    * @return Mensaje de saludo correspondiente al idioma 
    */
    @Override
    public String saludo() {
        return "\nBienvenido a Cheems Mart\n";
    }

    /**
    * Metodo que regresa el mensaje de Despedida
    * @return Mensaje de despedida correspondiente al idioma 
    */
    @Override
    public String despedida() {
        return "Hasta luego... ";
    }

    /**
    * Metodo que regresa el mensaje de Agradecimiento 
    * @return Mensaje de agradecimiento correspondiente al idioma 
    */
    @Override 
    public String agradecimiento(){
        return "Gracias por su visita a Cheems Mart \n Vuelva pronto...";
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
        return "La fecha de entrega esta programada para el dia " + fechaEntrega;
    }

    /**
    * Metodo que regresa el mensaje de Menu de Incio 
    * @return Mensaje del menu de inicio correspondiente al idioma 
    */
    @Override
    public String menuInicio(){
        return "Menu CheemsMart: \n" +
                  "1. Ver catálogo \n" +
                  "2. Realizar una compra\n" +
                  "3. Cerrar Sesion\n";
    }

    /**
    * Metodo que regresa el mensaje instruccion compra 
    * @return Mensaje de la instruccion de compra correspondiente al idioma
    */
    @Override
    public String mensajeCompra() {
        return "\n Ingresa el código de barras del producto que deseas agregar (o ingresa 0 para regresar al menú):";
    }

    /**
    * Metodo que regresa el mensaje de Error 
    * @return Mensaje de error cuando no se encuentra el articulo correspondiente al idioma 
    */
    @Override
    public String mensajeError(){
        return "Producto no encontrado. Intenta nuevamente.";
    }

    /**
    * Metodo que regres el mensaje de Finalizar compra
    * @return Mensaje de despedida correspondiente al idioma 
    */
    @Override
    public String mensajeFinalizarCompra(){
        String mensaje = "Gracias por comprar en Cheems Mart";
        return mensaje.toString();
    }

    /**
    * Metodo que regres el mensaje de error del menu
    * @return Mensaje de error menu correspondiente al idioma 
    */
    @Override
    public String mensajeInvalido(){
        return"Opcion invalida. Intente de nuevo";
    }

    /**
    * Metodo que regres el mensaje del producto agregado
    * @return Mensaje del producto agregado correspondiente al idioma 
    */
    @Override
    public String mensajeProductoAgregado(){
        return"Producto agregado al carrito";
    }

    /**
    * Metodo que regres el mensaje del error cuando el presupuesto no alcanza 
    * @return Mensaje del error del presupuesto correspondiente al idioma 
    */
    @Override
    public String mensajeErrorPresupuesto(){
        return"El carrito excede tu presupuesto se cancela la compra";
    }

    /**
     * Metodo que pide al usuario que decida entre comprar o salir del carrito
     * @return Mensaje que solicita al usuario que ingrese una opcion para comprar;
     */
    @Override
    public String opcionPagarOSalir(){
        return "\nIngresa el código de barras del producto que deseas agregar (o ingresa 0 para regresar al menú o 1 para realizar el cobro): ";
    }

    /**
     * Metodo que regresa una cadena solicitando al usuario que ingrese su numro de cuenta
     * @return Mensaje que solicita el numero de cuenta
     */
    @Override
    public String solicitarNCuenta() {
        return "Ingrese su numero de Cuenta";
    }

    /**
     * Metodo que devuelve el mensaje que el numero de cuenta es incorrecto 
     * @return Mensaje que el numero de cuentas es incorrecto al registrado
     */
    @Override
    public String nCuentaIncorrecto() {
        return "Numero de cuenta incorrecto";
    }
}
