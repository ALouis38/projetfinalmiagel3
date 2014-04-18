package rmi.serveur;

import java.net.UnknownHostException;
import java.rmi.RemoteException;

import rmi.serveur.coreserveur.GestFileImpl;
import rmi.serveur.coreserveur.Serveur;

public class LanceurServeur {

	public static void main(String[] args) {
		try {
			Serveur serv = new Serveur(1099);
			
			GestFileImpl fileTest;
			try {
				fileTest = new GestFileImpl();
				serv.addGestionnaire(fileTest, "gestFile");
			} catch (RemoteException e) {
				e.printStackTrace();
			}
	
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
