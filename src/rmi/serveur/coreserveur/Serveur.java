package rmi.serveur.coreserveur;


import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
/**
 * Classe représentant le serveur
 * 
 *
 */
public class Serveur {
	
	private int port;
	private GestObjetImpl gestObj;
	/**
	 * Constructeur du serveur
	 * @param port Port de connexion
	 * @throws UnknownHostException
	 */
	public Serveur(int port) throws UnknownHostException{
		this.port = port;
		try {
			LocateRegistry.createRegistry(this.port);	
			
			GestObjetImpl gestObj = new GestObjetImpl();
			gestObj.addObjet(gestObj, "gestObj");
			
		    System.out.println("Serveur lancé");
		  } catch (RemoteException e) {
		    e.printStackTrace();
		  } 
	}
	
	public void addGestionnaire(Remote gest, String nom){
		try {
			gestObj.addObjet(gest, nom);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
