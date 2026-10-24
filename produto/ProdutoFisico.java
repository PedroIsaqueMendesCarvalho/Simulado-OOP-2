package produto;

import entregavel.Entregavel;

public class ProdutoFisico extends Produto implements Entregavel {
    private double pesoKg;
    public ProdutoFisico(String codigo, String nome, double precoBase, int estoque, double pesoKg) {
        super(codigo, nome, precoBase, estoque);
        if (pesoKg <= 0) {
            throw new IllegalArgumentException("Peso inválido: " + pesoKg);
        }
        this.pesoKg = pesoKg;
    }
    @Override
    public double calcularPrecoFinal() {
        return getPrecoBase() + (getPrecoBase() * 0.1);

    }
    @Override
    public double calcularFrete() {
        return 15.00 + (2.00 * pesoKg);
    }
    @Override
    public int calcularPrazoEntrega(String cep) {
        if (cep.startsWith("6")) {
            return 7;
        }else return 12;
    }

}
