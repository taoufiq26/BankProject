package annuaire.serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

import banque.serveur.IBanque;

public interface IAnnuaire extends Remote{
	public IBanque getBanque(String code) throws RemoteException;
	public void registerBanque(IBanque ibanque,String code) throws RemoteException;
}
