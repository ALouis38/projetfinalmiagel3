package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import objetTest.ObjetTest;

public class Client {
	
	public Remote getObjetRegistry(int port, String adresse, String nom){
		System.out.println("Lancement de la connexion");
	      Remote r = null;
		try {
			r = Naming.lookup("rmi://" + adresse+ ":" + port + "/" + nom);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	    System.out.println("Objet renvoyé");
	      return r;

	}
}
