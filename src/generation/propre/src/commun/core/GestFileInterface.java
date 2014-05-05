package commun.core;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GestFileInterface extends Remote {
	/**
	 * downloadFile permet de télécharger un fichier
	 * 
	 * @param fileName
	 *            le nom du fichier à télécharger
	 * @return un tableau de bytes correspondant au fichier
	 * @throws RemoteException
	 */
	public byte[] downloadFile(String fileName) throws RemoteException;
	/**
	 * uploadFile envoie un tableau de bytes correspondant à un fichier
	 * 
	 * @param tab
	 *            le tableau de bytes
	 * @param name
	 *            le nom à donner au fichier
	 * @throws RemoteException
	 */
	public void uploadFile(byte[] tab, String name) throws RemoteException;
	/**
	 * supprFile supprime le fichier nommé dans le repertoire courant
	 * 
	 * @param nom
	 *            le nom du fichier à supprimer
	 * @throws RemoteException
	 */
	public void supprFile(String nom) throws RemoteException;
	/**
	 * getListeFichiers renvoie la liste des fichiers contenus dans le
	 * repertoire courant
	 * 
	 * @return la liste des fichiers
	 * @throws RemoteException
	 */
	public ArrayList<String> getListeFichiers() throws RemoteException;

}