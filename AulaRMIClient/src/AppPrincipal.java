import comum.IServicoRemoto;
import comum.PessoaFisica;
import comum.PessoaJuridica;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class AppPrincipal {

    public static void main(String[] args) {
        try {
            IServicoRemoto servicoRemoto = (IServicoRemoto) Naming.lookup("rmi://localhost:8282/pessoa");

            PessoaFisica pf1 = new PessoaFisica();

            pf1.setId(1);
            pf1.setNome("Gabriel");
            pf1.setSalario(1200f);
            pf1.setCidade("Trabiju");
            pf1.setEndereco("Rua Bla");
            pf1.setNomeDoPai("Joao");
            pf1.setNomeDaMae("Maria");
            pf1.setIdade(20);
            pf1.setTelefone("(16) 2222-2222");
            pf1.setEstado("SAO PAULO");
            pf1.setCpf("11111111111");

            PessoaJuridica pj1 = new PessoaJuridica();

            pj1.setId(2);
            pj1.setNome("Juliano");
            pj1.setSalario(14500f);
            pj1.setCidade("Araraquara");
            pj1.setEndereco("Rua Bla");
            pj1.setNomeDoPai("Cleiton");
            pj1.setNomeDaMae("Jussara");
            pj1.setIdade(35);
            pj1.setTelefone("(16) 55555-4546");
            pj1.setEstado("SAO PAULO");
            pj1.setCnpj("456484654-55");

            servicoRemoto.inserir(pf1);
            servicoRemoto.inserir(pj1);

            servicoRemoto.gerarAumento(pf1);

            servicoRemoto.imprimirPessoas();

        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }

}
