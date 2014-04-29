package rmi.client.modules.Utilisateur;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import rmi.client.core.Client;
import rmi.interfaces.modules.Utilisateur.GestUtilisateurInterface;
public class ClientUtilisateur extends Client {
	GestUtilisateurInterface gestI;
	String ip;
	
	public ClientUtilisateur(int p, String aS, String pseudo, int portReg) {
		super(p, aS);
		gestI = (GestUtilisateurInterface) getObjetRegistry("gestUtilisateur");
		try {
			ip = InetAddress.getLocalHost().getAddress().toString();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ajouterUtilisateur(pseudo,ip, portReg);
		
	}
	
	public void ajouterUtilisateur(String pseudo,String ip, int portReg){

			try {
				gestI.addUtilisateur(pseudo, ip, portReg);
			} catch (RemoteException e) {
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
