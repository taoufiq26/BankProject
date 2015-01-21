package banque.serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import agence.serveur.IAgence;
import metier.Agence;

public interface IBanque extends Remote {
	public ArrayList<Agence> getAgences() throws RemoteException;
	public IAgence getAgence(String code) throws RemoteException;
	public boolean testConnexion() throws RemoteException;
}
