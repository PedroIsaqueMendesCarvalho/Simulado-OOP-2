package excecao;

public class PagamentoRecusadoException extends RuntimeException {
    public PagamentoRecusadoException(String mensagem) {
        super(mensagem);
    }
}
