package banque.serveur;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import agence.serveur.IAgence;

public class TestConnexionAgenceThread implements Runnable{
	HashMap<String, ArrayList<IAgence>> map;
	public TestConnexionAgenceThread(HashMap<String, ArrayList<IAgence>> map) {
		// TODO Auto-generated constructor stub
		this.map = map;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			for(String code : map.keySet()){
				for(int i=0;i<map.get(code).size();i++){
					IAgence iagence = map.get(code).get(i);
					try {
						iagence.testConnexion();
					} catch (RemoteException e) {
						System.out.println("Supprimer agence");
						map.get(code).remove(i);
					}
				}
			}
		}
	}
	
	
}
