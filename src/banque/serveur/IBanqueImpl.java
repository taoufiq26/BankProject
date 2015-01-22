package banque.serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import metier.Agence;
import agence.serveur.IAgence;

public class IBanqueImpl extends UnicastRemoteObject implements IBanque{
	private HashMap<String, ArrayList<IAgence> > map;
	Thread testConnexion;
	protected IBanqueImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		map = new HashMap<String, ArrayList<IAgence>>();
		testConnexion = new Thread(new TestConnexionAgenceThread(map));
	}

	@Override
	public  synchronized HashMap<String, ArrayList<IAgence> > getAgences() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("get all agence");
		return map;
	}

	@Override
	public synchronized IAgence getAgence(String code) throws RemoteException {
		// TODO Auto-generated method stub
		if(map.get(code)==null)
			return null;
		return map.get(code).get(0);
	}

	@Override
	public synchronized boolean testConnexion() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("************called test remote " + map.size() + "\n" + map);
		return true;
	}

	@Override
	public synchronized boolean ajouterAgence(IAgence iagence,String codeAgence) throws RemoteException {
		// TODO Auto-generated method stub
		testConnexion.stop();
		if(map.get(codeAgence)==null){
			map.put(codeAgence,new ArrayList<IAgence>());
		}
		map.get(codeAgence).add(iagence);
		testConnexion= new Thread(new TestConnexionAgenceThread(map));
		testConnexion.start();
		return true;
	}

	@Override
	public synchronized boolean initialiserAgence(HashMap<String, ArrayList<IAgence> > mapAgence) throws RemoteException {
		testConnexion.stop();
		map = new HashMap<String, ArrayList<IAgence>>();
		for(String codeAgence : mapAgence.keySet()){
				map.put(codeAgence, new ArrayList<IAgence>(mapAgence.get(codeAgence)));
		}
		testConnexion= new Thread(new TestConnexionAgenceThread(map));
		testConnexion.start();
		return true;
	}

}
