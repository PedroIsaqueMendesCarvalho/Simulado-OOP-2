package produto;

public class Assinatura extends Produto {
    private int meses;
    public Assinatura(String codigo, String nome, double precoBase, int estoque, int meses) {
        super(codigo, nome, precoBase, estoque);
        if (meses <= 0) {
            throw new IllegalArgumentException("Quantidade de meses inválida: " + meses);
        }
        this.meses = meses;
    }
    @Override
    public double calcularPrecoFinal() {
        if (meses >= 6) {
            return (getPrecoBase() * meses) - ((getPrecoBase() * meses) * 0.1);
        }else return getPrecoBase() * meses;
        
    }
    
}
