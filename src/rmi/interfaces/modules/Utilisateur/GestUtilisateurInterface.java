package rmi.interfaces.modules.Utilisateur;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface GestUtilisateurInterface extends Remote {
	public void addUtilisateur(String pseudo,String ip) throws RemoteException;
	public void removeUtilisateur(String pseudo)throws RemoteException;
}
