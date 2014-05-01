package commun.core;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GestFileInterface extends Remote {
	public byte[] downloadFile(String fileName) throws RemoteException;
	public void uploadFile(byte[] tab, String name) throws RemoteException;
	public void supprFile(String nom) throws RemoteException;
	public ArrayList<String> getListeFichiers() throws RemoteException;

}