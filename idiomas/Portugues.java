package idiomas
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Portugues implements IdiomaCheemsMart {

    @Override
    public String saludo() {
        return "Bem-vindo ao Cheems Mart";
    }

    @Override
    public String despedida() {
        return "Até mais...";
    }

    @Override 
    public String agradecimiento(){
        return "Obrigado por visitar o Cheems Mart \nVolte em breve...";
    }

    @Override
    public String fechaEntrega(){
        LocalDate semanaSiguiente = LocalDate.now().plusDays(7);
        DataTimeFormatter formato = DataTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaEntrega = semanaSiguiente.format(formato);
        return "A data de entrega está marcada para o dia" + fecha;
    }

    @Override
    public String menuInicio(){
        return "Menu Principal\n" +
                  "1. Ver catálogo \n" +
                  "2. Adicione produtos ao carrinho \n" +
                  "3. Ver carrinho \n" +
                  "4. Concluir compra \n" +
                  "5. Sair";
    }

    @Override
    public String mensajeCompra() {
        return "Digite o código de barras do produto que deseja adicionar (ou digite 0 para retornar ao menu):";
    }

    @Override
    public String mensajeCarrito(String producto){
        return "Produto adicionado ao carrinho" + producto;
    }

    @Override
    public String mensajeError(){
        return "Produto não encontrado. Tente novamente.";
    }

    @Override
    public String mensajeCarrito(double total, Carrito carrito) {
        System.out.println("Carrinho de compras \n");
        carrito.imprimirCarrito();
        return  "Total: $" + String.valueOf(total);
    }

    @Override
    public String mensajeFinalizarCompra(double total, Carrito carrito){
        System.out.println("Finalizando compra...");
        carrito.imprimirCarrito();
        return "Total: $" + String.valueOf(total) +
               "Obrigado por comprar no Cheems Mart";
    }

    @Override
    peublic String mensajeInvalido(){
        return "Opção inválida. Tente novamente"
    }
}
