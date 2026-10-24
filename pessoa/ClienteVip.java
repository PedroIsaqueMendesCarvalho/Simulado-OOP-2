package pessoa;

public class ClienteVip extends Cliente{
    private double percentualDesconto;
        public ClienteVip(String nome, String cpf, String email, String endereco, String cep, double percentualDesconto) {
        super(nome, cpf, email, endereco, cep);
        if(percentualDesconto < 0 || percentualDesconto >= 100) {
            throw new IllegalArgumentException("Percentual de desconto inválido: " + percentualDesconto);
        }
        this.percentualDesconto = percentualDesconto;

    }
    public double getPercentualDesconto() {
        return percentualDesconto;
    }
    public String toString() {
        return super.toString() + "| Percentual de desconto: " + percentualDesconto + "%";
    }



}