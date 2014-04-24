package rmi.client.modules.Utilisateur;
import java.net.InetAddress;
import java.net.UnknownHostException;

import rmi.client.core.Client;
import rmi.interfaces.modules.Utilisateur.GestUtilisateurInterface;
public class ClientUtilisateur extends Client {
	GestUtilisateurInterface gestI;
	public ClientUtilisateur(int p, String aS) {
		super(p, aS);
		gestI = (GestUtilisateurInterface) getObjetRegistry("gestUtilisateur");
		
	}
	
	public void ajouterUtilisateur(String pseudo){
		try {
			gestI.addUtilisateur(pseudo, InetAddress.getLocalHost().getAddress().toString());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void supprimerUtilisateur(String pseudo){
		gestI.removeUtilisateur(pseudo);
	}
}
