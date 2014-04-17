package rmi.serveur.objetFonc;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GestFileInterface extends Remote {
	public byte[] downloadFile(String fileName) throws RemoteException;
	public void uploadFile(byte[] tab, String name) throws RemoteException;

}