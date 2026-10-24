package produto;

public class ProdutoDigital extends Produto {
    private double tamanhoMB;
    public ProdutoDigital(String codigo, String nome, double precoBase, int estoque, double tamanhoMB) {
        super(codigo, nome, precoBase, estoque);
        if (tamanhoMB <= 0) {
            throw new IllegalArgumentException("Tamanho inválido: " + tamanhoMB);
        }
        this.tamanhoMB = tamanhoMB;
    }
    @Override
    public double calcularPrecoFinal() {
        return getPrecoBase() - (getPrecoBase() * 0.05);
    }
    
}
