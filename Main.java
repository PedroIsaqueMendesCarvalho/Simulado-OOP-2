import carrinho.CarrinhoDeCompras;
import excecao.EstoqueInsuficienteException;
import pagamento.PagamentoCartao;
import pagamento.PagamentoPix;
import pedido.Pedido;
import pessoa.*;
import produto.*;

public class Main {
    public static void main(String[] args) {
        try {
            ClienteVip ana = new ClienteVip("Ana Souza", "123.456.789-09", "ana@mail.com", "Rua das Flores, 123", "60000-000", 10);
            CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
            carrinho.adicionar(new ProdutoFisico("F01", "Livro", 50.0, 10, 2.5), 1);
            carrinho.adicionar(new ProdutoDigital("D01", "Ebook", 30.0, 100, 15.0), 1);
            carrinho.adicionar(new Assinatura("A01", "Streaming", 20.0, 100, 6), 1);
            Pedido pedido = new Pedido(ana, carrinho);

            System.out.println("Compra 1 - Pix");
            pedido.finalizar(new PagamentoPix());
            System.out.println(ana);

            System.out.println("Compra 2 - Cartao 6x");
            pedido.finalizar(new PagamentoCartao(6, 50.0));
            System.out.println(ana);
        } catch (EstoqueInsuficienteException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
