package idiomas

public class Espanol implements IdiomaCheemsMart {

    @Override
    public String saludo() {
        return "Bienvenido a Cheems Mart";
    }

    @Override
    public String despedida() {
        return "Hasta luego";
    }

    @Override 
    public String agradecimiento(){
        return "Gracias por su visita a Cheems Mart \n Vuelva pronto...";
    }

    @Override
    public String fechaEntrega(){
        return "";
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

    public String mensajeError(){
        return "Producto no encontrado. Intenta nuevamente.";
    }

    public String mensajeCarrito(double total) {
        return "Carrito de compras \n" +
                "Total: $" + String.valueOf(total) +
    }

}
