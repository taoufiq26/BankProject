package annuaire.serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import agence.serveur.IAgenceImpl;
import banque.serveur.IBanque;

public interface IAnnuaire extends Remote{
	public ArrayList<IBanque> getBanque(String code) throws RemoteException;
	public void registerBanque(IBanque ibanque,String codeBanque) throws RemoteException;
}
