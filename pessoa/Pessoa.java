package pessoa;

public class Pessoa{
    private static final String REGEX_NOME = "^[A-Za-zÀ-ÿ]+( [A-Za-zÀ-ÿ]+)*$";
    private static final String REGEX_CPF = "^\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}$";
    private static final String REGEX_EMAIL = "^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$";
    private String nome;
    private String cpf;
    private String email;

    public Pessoa(String nome, String cpf, String email) {
        if (nome == null || !nome.matches(REGEX_NOME)) {
            throw new IllegalArgumentException("Nome inválido: " + nome);
        }
        if (cpf == null || !cpf.matches(REGEX_CPF)) {
            throw new IllegalArgumentException("CPF inválido: " + cpf);
        }
        if (email == null || !email.matches(REGEX_EMAIL)) {
            throw new IllegalArgumentException("Email inválido: " + email);
        }
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getEmail() {
        return email;
    }
    public String toString() {
        return "Nome: " + nome + "| CPF: " + cpf ;
    }
}
