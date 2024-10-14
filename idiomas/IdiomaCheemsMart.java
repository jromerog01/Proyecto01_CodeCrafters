package idiomas

public abstract class IdiomaCheemsMart {

   /**
    * Metodo que regresa el mensaje de Bienvenida
    * @return Mensaje de saludo correspondiente al idioma 
    */
    public abstract String saludo();

   /**
    * Metodo que regresa el mensaje de Despedida
    * @return Mensaje de despedida correspondiente al idioma 
    */
    public abstract String despedida();

   /**
    * Metodo que regresa el mensaje de Agradecimiento 
    * @return Mensaje de agradecimiento correspondiente al idioma 
    */
    public abstract String agradecimiento();

   /**
    * Metodo que regresa el mensaje de la fecha estimada d entrega  
    * @return Mensaje de fecha estimada  
    */
    public abstract String fechaEntrega();

   /**
    * Metodo que regresa el mensaje de Menu de Incio 
    * @return Mensaje del menu de inicio correspondiente al idioma 
    */
    public abstract String menuInicio();

   /**
    * Metodo que regresa el mensaje instruccion compra 
    * @return Mensaje de la instruccion de compra correspondiente al idioma
    */
    public abstract String mensajeCompra();

   /**
    * Metodo que regresa el mensaje de Error 
    * @return Mensaje de error cuando no se encuentra el articulo correspondiente al idioma 
    */
    public abstract String mensajeError();

   /**
    * Metodo que regresa la lista del carrito 
    * @param total Valor acumulado del carrito
    * @param carrito El carrito de compra 
    * @return Mensaje del  carrito correspondiente al idioma 
    */
    public abstract String mensajeCarrito(double total, Carrito carrito);

   /**
    * Metodo que regres el mensaje de Finalizar compra
    * @param total Valor acumulado del carrito
    * @param carrito El carrito de compra 
    * @return Mensaje de despedida correspondiente al idioma 
    */
    public abstract String mensajeFinalizarCompra(double total, Carrito carrito)

   /**
    * Metodo que regres el mensaje de error del menu
    * @return Mensaje de error menu correspondiente al idioma 
    */
    public abstract String mensajeInvalido();

}
