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
	public synchronized ArrayList<IBanque> getBanque(String code) throws RemoteException {
		return map.get(code);
	}
	@Override
	public synchronized void registerBanque(IBanque ibanque,String codeBanque) throws RemoteException {
		// TODO Auto-generated method stub
		testConnexion.stop();
		if(map.get(codeBanque)!=null && map.get(codeBanque).size()>0)
		ibanque.initialiserAgence(map.get(codeBanque).get(0).getAgences());
		
		
		if(map.get(codeBanque)==null){
			map.put(codeBanque, new ArrayList<IBanque>());
		}
		map.get(codeBanque).add(ibanque);
		testConnexion= new Thread(new TestConnexionThread(map));
		testConnexion.start();
	}
}