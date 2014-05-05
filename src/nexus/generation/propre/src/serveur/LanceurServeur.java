package serveur;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import serveur.core.GestFileImpl;
import serveur.core.Serveur;

public class LanceurServeur {

	public static void main(String[] args) {
		try {
			Serveur serveur = new Serveur(1099,true);
			
			//TODO: Codez ici!
	
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
