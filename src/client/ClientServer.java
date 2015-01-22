package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import agence.serveur.IAgence;
import annuaire.serveur.IAnnuaire;
import banque.serveur.IBanque;

public class ClientServer {
	static String numCompte = "abc-100-100";
	//static String annuaireUrl="rmi://192.168.10.1/Annuaire";
	static String annuaireUrl="rmi://localhost/Annuaire";
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		IAnnuaire iAnnuaire = (IAnnuaire) Naming.lookup(annuaireUrl);
		ArrayList<IBanque> ibanqes = iAnnuaire.getBanque(numCompte.split("-")[0]);
		System.out.println(ibanqes+"\n"+ibanqes.get(0).getAgences());
		IAgence iAgence= ibanqes.get(0).getAgence(numCompte.split("-")[0]+"-"+numCompte.split("-")[1]);
		String message = iAgence.afficher("Client "+numCompte+" Connecter ");
		System.out.println(message);
	}
}
