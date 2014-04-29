package rmi.client.modules.Utilisateur;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import rmi.client.core.Client;
import rmi.interfaces.modules.Utilisateur.GestUtilisateurInterface;
public class ClientUtilisateur extends Client {
	GestUtilisateurInterface gestI;
	
	public ClientUtilisateur(int p, String aS, String pseudo) {
		super(p, aS);
		gestI = (GestUtilisateurInterface) getObjetRegistry("gestUtilisateur");
		ajouterUtilisateur(pseudo);
		
	}
	
	public void ajouterUtilisateur(String pseudo){
		try {
			try {
				gestI.addUtilisateur(pseudo, InetAddress.getLocalHost().getAddress().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void supprimerUtilisateur(String pseudo){
		try {
			gestI.removeUtilisateur(pseudo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
