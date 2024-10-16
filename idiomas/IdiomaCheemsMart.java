package idiomas;

public interface IdiomaCheemsMart {

    //Bienvenido -nombre-

   /**
    * Metodo que regresa el mensaje de Bienvenida
    * @return Mensaje de saludo correspondiente al idioma 
    */
    public abstract String saludo();

    //mensaje final

   /**
    * Metodo que regresa el mensaje de Despedida
    * @return Mensaje de despedida correspondiente al idioma 
    */
    public abstract String despedida();

    
    // - Gracias por visitar CheemsMart-

   /**
    * Metodo que regresa el mensaje de Agradecimiento 
    * @return Mensaje de agradecimiento correspondiente al idioma 
    */
    public abstract String agradecimiento();


    // - Fecha entrega - 
   /**
    * Metodo que regresa el mensaje de la fecha estimada d entrega  
    * @return Mensaje de fecha estimada  
    */
    public abstract String fechaEntrega();


    // -Mini Menu-
   /**
    * Metodo que regresa el mensaje de Menu de Incio 
    * @return Mensaje del menu de inicio correspondiente al idioma 
    */
    public abstract String menuInicio();


    // -seguir agregando al carrito- 
   /**
    * Metodo que regresa el mensaje instruccion compra 
    * @return Mensaje de la instruccion de compra correspondiente al idioma
    */
    public abstract String mensajeCompra();



    // -No se encontro el id del producto-

   /**
    * Metodo que regresa el mensaje de Error 
    * @return Mensaje de error cuando no se encuentra el articulo correspondiente al idioma 
    */
    public abstract String mensajeError();


   /**
    * Metodo que regres el mensaje de Finalizar compra
    * @param total Valor acumulado del carrito
    * @param carrito El carrito de compra 
    * @return Mensaje de despedida correspondiente al idioma 
    */
    public abstract String mensajeFinalizarCompra();

   /**
    * Metodo que regres el mensaje de error del menu
    * @return Mensaje de error menu correspondiente al idioma 
    */
    public abstract String mensajeInvalido();

    /**
    * Metodo que regres el mensaje del producto agregado
    * @return Mensaje del producto agregado correspondiente al idioma 
    */
    public abstract String mensajeProductoAgregado();

    /**
    * Metodo que regres el mensaje del error cuando el presupuesto no alcanza 
    * @return Mensaje del error del presupuesto correspondiente al idioma 
    */
    public abstract String mensajeErrorPresupuesto();

    
}


