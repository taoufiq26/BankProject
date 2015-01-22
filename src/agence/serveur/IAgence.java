package agence.serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAgence extends Remote {
	public boolean testConnexion() throws RemoteException;

	public String afficher(String string) throws RemoteException;
}
