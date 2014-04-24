package rmi.serveur.modules.Utilisateur;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import rmi.interfaces.modules.Utilisateur.GestUtilisateurInterface;


public class GestUtilisateurImpl extends UnicastRemoteObject implements GestUtilisateurInterface {
	
	private HashMap<String, String> listeUtilisateurs;
	
	public GestUtilisateurImpl() throws RemoteException {
		super();
		listeUtilisateurs = new HashMap<String, String>();
	}

	
	@Override
	public void addUtilisateur(String pseudo, String ip) {
		if(listeUtilisateurs.containsKey(pseudo)){
			System.out.println("Pseudo deja utilisé!");
		}
		else{
			listeUtilisateurs.put(pseudo, ip);
		}
	}

	@Override
	public void removeUtilisateur(String pseudo) {
		// TODO Auto-generated method stub
		//
		listeUtilisateurs.remove(pseudo);
	}
}
