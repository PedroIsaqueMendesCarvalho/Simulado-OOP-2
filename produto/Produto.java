package produto;

public abstract class Produto {
    private String codigo;
    private String nome;
    private double precoBase;
    private int estoque;
    public Produto(String codigo, String nome, double precoBase, int estoque) {
        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("Código inválido: " + codigo);
        }
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido: " + nome);
        }
        if (precoBase < 0) {
            throw new IllegalArgumentException("Preço base inválido: " + precoBase);
        }
        if (estoque < 0) {
            throw new IllegalArgumentException("Estoque inválido: " + estoque);
        }
        this.codigo = codigo;
        this.nome = nome;
        this.precoBase = precoBase;
        this.estoque = estoque;
    }
    public abstract double calcularPrecoFinal();
    public String exibirResumo() {
        return "<" + codigo + "> -" +" <" + nome + ">" + " - R$" + " <" + String.format("%.2f", calcularPrecoFinal()) + ">";
    }
    public void baixarEstoque(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade inválida: " + quantidade);
        }
        if (quantidade > estoque) {
            throw new IllegalArgumentException("Estoque insuficiente. Estoque atual: " + estoque);
        }
        estoque -= quantidade;
    }
    public double getPrecoBase() {
        return precoBase;
    }
    public String getNome() {
        return nome;
    }
    public int getEstoque() {
        return estoque;
    }
}
