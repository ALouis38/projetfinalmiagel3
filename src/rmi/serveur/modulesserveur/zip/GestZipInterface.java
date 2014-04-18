package rmi.serveur.modulesserveur.zip;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GestZipInterface extends Remote {
	public void compression(String[] fichiers, String repertoire) throws RemoteException ;
	public void decompression(String nomArchive, String repertoire) throws RemoteException;
}
