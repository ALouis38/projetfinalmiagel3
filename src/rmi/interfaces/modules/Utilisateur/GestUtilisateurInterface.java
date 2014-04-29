package rmi.interfaces.modules.Utilisateur;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
public interface GestUtilisateurInterface extends Remote {
	public void addUtilisateur(String pseudo,String ip, int portReg) throws RemoteException;
	public void removeUtilisateur(String pseudo)throws RemoteException;
	public HashMap<String, Utilisateur> getListeUtilisateurs() throws RemoteException;
}
