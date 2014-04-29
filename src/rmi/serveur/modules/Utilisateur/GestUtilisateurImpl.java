package rmi.serveur.modules.Utilisateur;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import rmi.interfaces.modules.Utilisateur.GestUtilisateurInterface;
import rmi.interfaces.modules.Utilisateur.Utilisateur;


public class GestUtilisateurImpl extends UnicastRemoteObject implements GestUtilisateurInterface {
	
	private HashMap<String, Utilisateur> listeUtilisateurs;
	
	public GestUtilisateurImpl() throws RemoteException {
		super();
		listeUtilisateurs = new HashMap<String, Utilisateur>();
	}

	
	@Override
	public void addUtilisateur(String pseudo, String ip, int portReg) {
		if(listeUtilisateurs.containsKey(pseudo)){
			System.out.println("Pseudo deja utilisé!");
		}
		else{
			listeUtilisateurs.put(pseudo, new Utilisateur(ip, portReg));
		}
	}

	@Override
	public void removeUtilisateur(String pseudo) {
		// TODO Auto-generated method stub
		//
		listeUtilisateurs.remove(pseudo);
	}


	public HashMap<String, Utilisateur> getListeUtilisateurs() {
		if(listeUtilisateurs == null){
			System.out.println("!===============! Liste utilisateur vide !================!");
		}
		return listeUtilisateurs;
	}
}
