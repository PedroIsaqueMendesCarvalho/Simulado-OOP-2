package pessoa;

public class Cliente extends Pessoa {
    private static final String REGEX_ENDERECO = "^[A-Za-zÀ-ÿ0-9 .]+, ?\\d+[A-Za-zÀ-ÿ0-9 ,.-]*$";
    private static final String REGEX_CEP = "^\\d{5}-?\\d{3}$";
    private String endereco;
    private String cep;
    private int pontosFidelidade = 0;

    public Cliente(String nome, String cpf, String email, String endereco, String cep) {
        super(nome, cpf, email);
        if (endereco == null || !endereco.matches(REGEX_ENDERECO)) {
            throw new IllegalArgumentException("Endereço inválido: " + endereco);
        }
        if (cep == null || !cep.matches(REGEX_CEP)) {
            throw new IllegalArgumentException("CEP inválido: " + cep);
        }
        this.endereco = endereco;
        this.cep = cep;
    }
    public void adicionarPontos(int pontos) {
        pontosFidelidade += pontos;
    }
    public String getCep() {
        return cep;
    }
    public int getPontosFidelidade() {
        return pontosFidelidade;
    }
    public String toString() {
        return super.toString() + "| Pontos de fidelidade: " + pontosFidelidade;
    }
}
