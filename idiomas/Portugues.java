package idiomas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Portugues implements IdiomaCheemsMart {

    /**
    * Metodo que regresa el mensaje de Bienvenida
    * @return Mensaje de saludo correspondiente al idioma 
    */
    @Override
    public String saludo() {
        return "\n Bem-vindo ao Cheems Mart\n";
    }

    /**
    * Metodo que regresa el mensaje de Despedida
    * @return Mensaje de despedida correspondiente al idioma 
    */
    @Override
    public String despedida() {
        return "Até mais...";
    }

    /**
    * Metodo que regresa el mensaje de Agradecimiento 
    * @return Mensaje de agradecimiento correspondiente al idioma 
    */
    @Override 
    public String agradecimiento(){
        return "Obrigado por visitar o Cheems Mart \n" + 
                        "Volte em breve...";
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
        return "A data de entrega está marcada para o dia " + fechaEntrega;
    }

    /**
    * Metodo que regresa el mensaje de Menu de Incio 
    * @return Mensaje del menu de inicio correspondiente al idioma 
    */
    @Override
    public String menuInicio(){
        return "Menu CheemsMart:\n" +
                    "1. Ver catálogo \n" +
                    "2. Faça uma compra\n" +
                    "3. Sair\n";
    }

    /**
    * Metodo que regresa el mensaje instruccion compra 
    * @return Mensaje de la instruccion de compra correspondiente al idioma
    */
    @Override
    public String mensajeCompra() {
        return "\n Digite o código de barras do produto que deseja adicionar (ou digite 0 para retornar ao menu):";
    }

    /**
    * Metodo que regresa el mensaje de Error 
    * @return Mensaje de error cuando no se encuentra el articulo correspondiente al idioma 
    */
    @Override
    public String mensajeError(){
        return "Produto não encontrado. Tente novamente.";
    }

    /**
    * Metodo que regres el mensaje de Finalizar compra
    * @return Mensaje de despedida correspondiente al idioma 
    */
    @Override
    public String mensajeFinalizarCompra(){
        String mensaje = "Obrigado por comprar no Cheems Mart";
        return mensaje.toString();
    }

    /**
    * Metodo que regres el mensaje de error del menu
    * @return Mensaje de error menu correspondiente al idioma 
    */
    @Override
    public String mensajeInvalido(){
        return "Opção inválida. Tente novamente";
    }

    /**
    * Metodo que regres el mensaje del producto agregado
    * @return Mensaje del producto agregado correspondiente al idioma 
    */
    @Override
    public String mensajeProductoAgregado(){
        return "Produto adicionado ao carrinho";
    }

    /**
    * Metodo que regres el mensaje del error cuando el presupuesto no alcanza 
    * @return Mensaje del error del presupuesto correspondiente al idioma 
    */
    @Override
    public String mensajeErrorPresupuesto(){
        return "O carrinho excede seu orçamento, a compra foi cancelada";
    }

    /**
     * Metodo que pide al usuario que decida entre comprar o salir del carrito
     * @return Mensaje que solicita al usuario que ingrese una opcion para comprar;
     */
    @Override
    public String opcionPagarOSalir() {
        return "\nInsira o código de barras do produto que deseja adicionar (ou digite 0 para retornar ao menu ou 1 para efetuar o pagamento): ";
    }

    /**
     * Metodo que regresa una cadena solicitando al usuario que ingrese su numro de cuenta
     * @return Mensaje que solicita el numero de cuenta
     */
    @Override
    public String solicitarNCuenta() {
        return "Digite o número da sua conta";
    }

    /**
     * Metodo que devuelve el mensaje que el numero de cuenta es incorrecto 
     * @return Mensaje que el numero de cuentas es incorrecto al registrado
     */
    @Override
    public String nCuentaIncorrecto() {
        return "Número de conta incorreto";
    }
}
