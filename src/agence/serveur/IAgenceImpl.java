package agence.serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class IAgenceImpl extends UnicastRemoteObject implements IAgence{

	protected IAgenceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean testConnexion() throws RemoteException {
		// TODO Auto-generated method stub
		//System.out.println("Test connexion agence");
		return false;
	}

	@Override
	public String afficher(String string) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(string);
		return "Hi from Agence ";
	}

}
