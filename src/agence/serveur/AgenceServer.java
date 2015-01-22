package agence.serveur;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import annuaire.serveur.IAnnuaire;
import banque.serveur.IBanque;

public class AgenceServer {
	static String codeAgence = "abc-100";
	//static String annuaireUrl="rmi://192.168.10.1/Annuaire";
	static String annuaireUrl="rmi://localhost/Annuaire";
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		IAnnuaire iAnnuaire = (IAnnuaire) Naming.lookup(annuaireUrl);
		ArrayList<IBanque> ibanques = iAnnuaire.getBanque(codeAgence.split("-")[0]);
		for(int i=0;i<ibanques.size();i++){
			ibanques.get(i).ajouterAgence(new IAgenceImpl(), codeAgence);
		}
	}
}
