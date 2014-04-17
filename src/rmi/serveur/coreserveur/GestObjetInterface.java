package rmi.serveur.coreserveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GestObjetInterface extends Remote {
	public Remote getObjet(String adresse, int port, String nom) throws RemoteException;
	public void addObjet(Remote obj, String nom) throws RemoteException;
}