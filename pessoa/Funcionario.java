package pessoa;
class Funcionario extends Pessoa{
    private String matricula;
    private double salario;

    public Funcionario(String nome, String cpf, String email, String matricula, double salario) {
        super(nome, cpf, email);
        if (matricula == null || matricula.isEmpty()) {
            throw new IllegalArgumentException("Matrícula inválida: " + matricula);
        }
        if (salario < 0) {
            throw new IllegalArgumentException("Salário inválido: " + salario);
        }
        this.matricula = matricula;
        this.salario = salario;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getSalario() {
        return salario;
    }
}