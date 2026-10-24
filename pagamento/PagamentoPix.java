package pagamento;

public class PagamentoPix implements Pagamento {
    @Override
    public double calcularValorFinal(double valor) {
        return valor - (valor * 0.05);
    }
    @Override
    public String getDescricao() {
        return "Pix";
    }
}
