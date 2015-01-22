package banque.serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import agence.serveur.IAgence;
import metier.Agence;

public interface IBanque extends Remote {
	public HashMap<String, ArrayList<IAgence> > getAgences() throws RemoteException;
	public IAgence getAgence(String code) throws RemoteException;
	public boolean ajouterAgence(IAgence iagence, String codeAgence) throws RemoteException;
	public boolean initialiserAgence(HashMap<String, ArrayList<IAgence> > mapAgence) throws RemoteException;
	public boolean testConnexion() throws RemoteException ;
}
