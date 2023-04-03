package servidor;

import comum.ServicoRemotoImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Servico {

    public Servico() throws RemoteException {
        LocateRegistry.createRegistry(8282);
        System.out.println("INICIO");
        try {
            Naming.rebind("rmi://localhost:8282/pessoa", new ServicoRemotoImpl());
            System.out.println("FIM");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws RemoteException {
        new Servico();
    }

}
