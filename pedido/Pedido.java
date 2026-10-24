package pedido;

import carrinho.CarrinhoDeCompras;
import excecao.PagamentoRecusadoException;
import pagamento.Pagamento;
import pessoa.Cliente;
import pessoa.ClienteVip;

public class Pedido {
    private Cliente cliente;
    private CarrinhoDeCompras carrinho;
    public Pedido(Cliente cliente, CarrinhoDeCompras carrinho) {
        this.cliente = cliente;
        this.carrinho = carrinho;
    }
    public void finalizar(Pagamento pagamento) {
        try {
            double subtotal = carrinho.calcularTotal() + carrinho.calcularFreteTotal(cliente.getCep());
            if (cliente instanceof ClienteVip) {
                ClienteVip vip = (ClienteVip) cliente;
                subtotal = subtotal - (subtotal * vip.getPercentualDesconto() / 100);
            }
            double valorFinal = pagamento.calcularValorFinal(subtotal);
            pagamento.exibirComprovante(subtotal);
            cliente.adicionarPontos((int) (valorFinal / 10));
        } catch (PagamentoRecusadoException e) {
            System.out.println("Pagamento recusado");
        } finally {
            System.out.println("Pedido encerrado");
        }
    }
}
