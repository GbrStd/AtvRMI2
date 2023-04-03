package comum;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServicoRemotoImpl extends UnicastRemoteObject implements IServicoRemoto {

    private static final List<Pessoa> listPessoa = new ArrayList<>();

    public ServicoRemotoImpl() throws RemoteException {
    }

    @Override
    public void inserir(Pessoa p) throws RemoteException {
        listPessoa.add(p);
    }

    @Override
    public List<Pessoa> listarPessoa() throws RemoteException {
        return listPessoa;
    }

    @Override
    public void gerarAumento(Pessoa p) throws RemoteException {

        System.out.println("Entrou");

        Pessoa alvo = null;
        for (Pessoa pessoa : listarPessoa()) {
            if (pessoa.getId() == p.getId()) {
                alvo = pessoa;
                break;
            }
        }

        if (alvo == null) {
            System.out.println("Nenhuma pessoa encontrada!");
            return;
        }

        if (alvo.getIdade() < 20) { // 10%
            alvo.setSalario(alvo.getSalario() + (alvo.getSalario() * 0.1f));
        } else if (alvo.getIdade() >= 20 && alvo.getIdade() <= 30) { // 15%
            alvo.setSalario(alvo.getSalario() + (alvo.getSalario() * 0.15f));
        } else { // 20%
            alvo.setSalario(alvo.getSalario() + (alvo.getSalario() * 0.20f));
        }
    }

    @Override
    public void imprimirPessoas() throws RemoteException {
        System.out.println("Testeee");
        for (Pessoa pessoa : listarPessoa()) {
            System.out.println("-----");
            System.out.println(pessoa);
            System.out.println("-----");
        }
    }
}
