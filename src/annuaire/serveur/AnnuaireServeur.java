package annuaire.serveur;

import java.io.ObjectInputStream.GetField;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Locale;

public class AnnuaireServeur {
	static String url="rmi://localhost/Annuaire";
	public static void main(String[] args) throws RemoteException, MalformedURLException{
		System.out.println("Annuaire Serveur started");
		LocateRegistry.createRegistry(1099);
		Naming.rebind(url, new IAnnuaireImpl());
	}
}
