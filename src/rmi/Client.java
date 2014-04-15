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
	public static void main(String[] argv){

		System.out.println("Lancement du client");
	    if (System.getSecurityManager() == null) {
	      System.setSecurityManager(new RMISecurityManager());
	    }
	    try {
	      Remote r = Naming.lookup("rmi://127.0.0.1/TestRMI");
	      System.out.println(r);
	      if (r instanceof ObjetTest) {
	        String s = ((ObjetTest) r).test();
	        System.out.println("chaine renvoyee = " + s);
	      }
	    } catch (MalformedURLException e) {
	      e.printStackTrace();
	    } catch (RemoteException e) {
	      e.printStackTrace();
	    } catch (NotBoundException e) {
	      e.printStackTrace();
	    }
	    System.out.println("Fin du client");
		
		
		
		
//		try {
//			// Récupère le registre
//			Registry registry = LocateRegistry.getRegistry(10000);
//			// Récupération de l'instance de l'objet distant
//			ObjetTest stub = (ObjetTest) registry.lookup("ObjetTest");
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		} catch (NotBoundException e) {
//			e.printStackTrace();
//		}
	}
}
