package banque.serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import metier.Agence;
import agence.serveur.IAgence;

public class IBanqueImpl extends UnicastRemoteObject implements IBanque{

	protected IBanqueImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Agence> getAgences() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("get all agence");
		return null;
	}

	@Override
	public IAgence getAgence(String code) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("getting agence "+code);
		return null;
	}

	@Override
	public boolean testConnexion() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("called test remote");
		return true;
	}

}
