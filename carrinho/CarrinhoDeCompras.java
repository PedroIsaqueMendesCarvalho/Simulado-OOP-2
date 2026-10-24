package carrinho;

import entregavel.Entregavel;
import excecao.EstoqueInsuficienteException;
import java.util.ArrayList;
import java.util.List;
import produto.Produto;

public class CarrinhoDeCompras {
    private List<Produto> itens = new ArrayList<>();
    public void adicionar(Produto p) {
        itens.add(p);
    }
    public void adicionar(Produto p, int quantidade) throws EstoqueInsuficienteException {
        if (quantidade > p.getEstoque()) {
            throw new EstoqueInsuficienteException(p.getNome(), p.getEstoque());
        }
        for (int i = 0; i < quantidade; i++) {
            adicionar(p);
        }
    }
    public double calcularTotal() {
        double total = 0;
        for (Produto p : itens) {
            total += p.calcularPrecoFinal();
        }
        return total;
    }
    public double calcularFreteTotal(String cep) {
        double frete = 0;
        for (Produto p : itens) {
            if (p instanceof Entregavel) {
                Entregavel e = (Entregavel) p;
                frete += e.calcularFrete();
            }
        }
        return frete;
    }
}
