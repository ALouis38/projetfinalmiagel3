package serveur.modules.Utilisateur;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import commun.modules.Utilisateur.GestUtilisateurInterface;
import commun.modules.Utilisateur.Utilisateur;


public class GestUtilisateurImpl extends UnicastRemoteObject implements GestUtilisateurInterface {
	
	private HashMap<String, Utilisateur> listeUtilisateurs;
	
	public GestUtilisateurImpl() throws RemoteException {
		super();
		listeUtilisateurs = new HashMap<String, Utilisateur>();
	}

	
	@Override
	public void addUtilisateur(String pseudo, String ip) {
		if(listeUtilisateurs.containsKey(pseudo)){
			System.out.println("Pseudo deja utilis�!");
		}
		else{
			listeUtilisateurs.put(pseudo, new Utilisateur(ip));
		}
	}

	@Override
	public void removeUtilisateur(String pseudo) {
		// TODO Auto-generated method stub
		//
		listeUtilisateurs.remove(pseudo);
	}


	public HashMap<String, Utilisateur> getListeUtilisateurs() {
		return listeUtilisateurs;
	}
}
