package idiomas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Portugues implements IdiomaCheemsMart {

    @Override
    public String saludo() {
        return "\n Bem-vindo ao Cheems Mart\n";
    }


    @Override
    public String despedida() {
        return "Até mais...";
    }

    
    @Override 
    public String agradecimiento(){
        return "Obrigado por visitar o Cheems Mart \n" + 
                        "Volte em breve...";
    }

    @Override
    public String fechaEntrega(){
        LocalDate semanaSiguiente = LocalDate.now().plusDays(7);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaEntrega = semanaSiguiente.format(formato);
        return "A data de entrega está marcada para o dia " + fechaEntrega;
    }

    @Override
    public String menuInicio(){
        return "Menu CheemsMart:\n" +
                    "1. Ver catálogo \n" +
                    "2. Faça uma compra\n" +
                    "3. Sair\n";
    }

    @Override
    public String mensajeCompra() {
        return "\n Digite o código de barras do produto que deseja adicionar (ou digite 0 para retornar ao menu):";
    }

    @Override
    public String mensajeError(){
        return "Produto não encontrado. Tente novamente.";
    }


    @Override
    public String mensajeFinalizarCompra(){
        String mensaje = "Obrigado por comprar no Cheems Mart";
        return mensaje.toString();
    }

    @Override
    public String mensajeInvalido(){
        return "Opção inválida. Tente novamente";
    }

    @Override
    public String mensajeProductoAgregado(){
        return "Produto adicionado ao carrinho";
    }

    @Override
    public String mensajeErrorPresupuesto(){
        return "O carrinho excede seu orçamento, a compra foi cancelada";
    }
}
