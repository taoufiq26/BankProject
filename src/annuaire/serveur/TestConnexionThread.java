package annuaire.serveur;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import banque.serveur.IBanque;

public class TestConnexionThread implements Runnable{
	HashMap<String, ArrayList<IBanque> > map;
	public TestConnexionThread(HashMap<String, ArrayList<IBanque> > map) {
		// TODO Auto-generated constructor stub
		this.map=map;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("started testConnexion");
		while(true){
			for(String code : map.keySet()){
				for(int i=0;i<map.get(code).size();i++){
					IBanque banque = map.get(code).get(i);
					try {
						banque.testConnexion();
					} catch (RemoteException e) {
						map.get(code).remove(i);
						System.out.println("Suppresion interface ");
					}
				}
			}
		}
	}

}