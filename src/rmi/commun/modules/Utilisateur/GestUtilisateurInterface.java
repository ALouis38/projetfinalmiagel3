package rmi.commun.modules.Utilisateur;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
public interface GestUtilisateurInterface extends Remote {
	//ajoute un Utilisateur à la liste
	public void addUtilisateur(String pseudo,String ip, int portReg) throws RemoteException;
	//supprime l'utilisateur ayant ce pseudo de la liste
	public void removeUtilisateur(String pseudo)throws RemoteException;
	//Recupere la liste d'utilisateur
	public HashMap<String, Utilisateur> getListeUtilisateurs() throws RemoteException;
}
