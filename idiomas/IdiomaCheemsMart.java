package idiomas;

public interface IdiomaCheemsMart {

    //Bienvenido -nombre-

   /**
    * Metodo que regresa el mensaje de Bienvenida
    * @return Mensaje de saludo correspondiente al idioma 
    */
    public String saludo();

    //mensaje final

   /**
    * Metodo que regresa el mensaje de Despedida
    * @return Mensaje de despedida correspondiente al idioma 
    */
    public String despedida();

    
    // - Gracias por visitar CheemsMart-

   /**
    * Metodo que regresa el mensaje de Agradecimiento 
    * @return Mensaje de agradecimiento correspondiente al idioma 
    */
    public String agradecimiento();


    // - Fecha entrega - 
   /**
    * Metodo que regresa el mensaje de la fecha estimada d entrega  
    * @return Mensaje de fecha estimada  
    */
    public String fechaEntrega();


    // -Mini Menu-
   /**
    * Metodo que regresa el mensaje de Menu de Incio 
    * @return Mensaje del menu de inicio correspondiente al idioma 
    */
    public String menuInicio();


    // -seguir agregando al carrito- 
   /**
    * Metodo que regresa el mensaje instruccion compra 
    * @return Mensaje de la instruccion de compra correspondiente al idioma
    */
    public String mensajeCompra();



    // -No se encontro el id del producto-

   /**
    * Metodo que regresa el mensaje de Error 
    * @return Mensaje de error cuando no se encuentra el articulo correspondiente al idioma 
    */
    public String mensajeError();


   /**
    * Metodo que regres el mensaje de Finalizar compra
    * @param total Valor acumulado del carrito
    * @param carrito El carrito de compra 
    * @return Mensaje de despedida correspondiente al idioma 
    */
    public String mensajeFinalizarCompra();

   /**
    * Metodo que regres el mensaje de error del menu
    * @return Mensaje de error menu correspondiente al idioma 
    */
    public String mensajeInvalido();

    /**
    * Metodo que regres el mensaje del producto agregado
    * @return Mensaje del producto agregado correspondiente al idioma 
    */
    public String mensajeProductoAgregado();

    /**
    * Metodo que regres el mensaje del error cuando el presupuesto no alcanza 
    * @return Mensaje del error del presupuesto correspondiente al idioma 
    */
    public String mensajeErrorPresupuesto();

    /**
     * Metodo que pide al usuario que decida entre comprar o salir del carrito
     * @return Mensaje que solicita al usuario que ingrese una opcion para comprar;
     */
    public String opcionPagarOSalir();

    /**
     * Metodo que regresa una cadena solicitando al usuario que ingrese su numro de cuenta
     * @return Mensaje que solicita el numero de cuenta
     */
    public String solicitarNCuenta();

    /**
     * Metodo que devuelve el mensaje que el numero de cuenta es incorrecto 
     * @return Mensaje que el numero de cuentas es incorrecto al registrado
     */
    public String nCuentaIncorrecto();
    
}


