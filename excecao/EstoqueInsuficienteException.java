package excecao;

public class EstoqueInsuficienteException extends Exception {
    public EstoqueInsuficienteException(String nome, int quantidadeDisponivel) {
        super("Estoque insuficiente para " + nome + ". Disponível: " + quantidadeDisponivel);
    }
}
