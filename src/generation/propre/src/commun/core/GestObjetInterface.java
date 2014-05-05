package commun.core;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GestObjetInterface extends Remote {
	/**
	 * getObjet permet de récupérer un objet distant
	 * 
	 * @param adresse l'adresse du serveur
	 * @param port le port de connexion
	 * @param nom le nom de l'objet distant
	 * @return l'objet
	 * @throws RemoteException
	 */
	public Remote getObjet(String adresse, int port, String nom) throws RemoteException;
	/**
	 * addObjet ajoute un objet au registry
	 * 
	 * @param obj l'objet à envoyer
	 * @param nom le nom de l'objet distant
	 * @throws RemoteException
	 */
	public void addObjet(Remote obj, String nom) throws RemoteException;
}