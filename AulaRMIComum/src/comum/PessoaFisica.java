package comum;

public class PessoaFisica extends Pessoa {

    public String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                "cpf='" + cpf + '\'' +
                '}';
    }
}
