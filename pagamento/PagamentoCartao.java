package pagamento;

import excecao.PagamentoRecusadoException;

public class PagamentoCartao implements Pagamento {
    private int parcelas;
    private double limite;
    public PagamentoCartao(int parcelas, double limite) {
        if (parcelas <= 0) {
            throw new IllegalArgumentException("Parcelas inválidas: " + parcelas);
        }
        this.parcelas = parcelas;
        this.limite = limite;
    }
    @Override
    public double calcularValorFinal(double valor) {
        double valorFinal = valor;
        if (parcelas > 3) {
            valorFinal = valor + (valor * 0.08);
        }
        if (valorFinal > limite) {
            throw new PagamentoRecusadoException("Valor acima do limite: " + limite);
        }
        return valorFinal;
    }
    @Override
    public String getDescricao() {
        return "Cartão";
    }
}
