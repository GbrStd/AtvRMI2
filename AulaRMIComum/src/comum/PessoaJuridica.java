package comum;

public class PessoaJuridica extends Pessoa {

    public String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                "cnpj='" + cnpj + '\'' +
                '}';
    }
}
