package annuaire.serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import banque.serveur.IBanque;

public class IAnnuaireImpl extends UnicastRemoteObject implements IAnnuaire{
	private HashMap<String,ArrayList<IBanque> > map;
	protected IAnnuaireImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		map = new HashMap<String,ArrayList<IBanque> >();
		new Thread(new TestConnexionThread(map)).start();
	}

	@Override
	public synchronized IBanque getBanque(String code) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public synchronized void registerBanque(IBanque ibanque,String code) throws RemoteException {
		// TODO Auto-generated method stub
		if(map.get(code)==null){
			map.put(code, new ArrayList<IBanque>());
		}
		map.get(code).add(ibanque);
	}
}
