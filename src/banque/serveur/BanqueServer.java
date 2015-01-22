package banque.serveur;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import annuaire.serveur.IAnnuaire;

public class BanqueServer {
	static String code = "abc";
	//static String annuaireUrl="rmi://192.168.10.1/Annuaire";
	static String annuaireUrl="rmi://localhost/Annuaire";
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		IAnnuaire iAnnuaire = (IAnnuaire) Naming.lookup(annuaireUrl);
		iAnnuaire.registerBanque(new IBanqueImpl(), code);
		System.out.println("banque server started");
	}
}
