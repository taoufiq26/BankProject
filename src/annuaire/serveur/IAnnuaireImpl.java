package annuaire.serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import banque.serveur.IBanque;

public class IAnnuaireImpl extends UnicastRemoteObject implements IAnnuaire{
	private HashMap<String,ArrayList<IBanque> > map;
	private Thread testConnexion;
	protected IAnnuaireImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		map = new HashMap<String,ArrayList<IBanque> >();
		testConnexion= new Thread(new TestConnexionThread(map));
		testConnexion.start();
	}

	@Override
	public synchronized IBanque getBanque(String code) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public synchronized void registerBanque(IBanque ibanque,String code) throws RemoteException {
		// TODO Auto-generated method stub
		testConnexion.stop();
		if(map.get(code)==null){
			map.put(code, new ArrayList<IBanque>());
		}
		map.get(code).add(ibanque);
		testConnexion= new Thread(new TestConnexionThread(map));
		testConnexion.start();
	}
}