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
	private String adresse;
	/**
	 * Constructeur du serveur
	 * @param port Port de connexion
	 * @throws UnknownHostException
	 */
	public Serveur(int port) throws UnknownHostException{
		this.port = port;
		this.adresse = InetAddress.getLocalHost().getHostAddress();
		try {
			LocateRegistry.createRegistry(this.port);	
			
			gestObj = new GestObjetImpl();
			gestObj.addObjet(gestObj, "rmi://"+adresse+":"+port+"/"+"gestObj");
			
			System.out.println("Adresse:" + adresse +"  Port:" + this.port);
		    System.out.println("Serveur lancé");
		  } catch (RemoteException e) {
		    e.printStackTrace();
		  } 
	}
	
	public void addGestionnaire(Remote gest, String nom){
		try {
			gestObj.addObjet(gest, "rmi://"+adresse +":"+port+"/"+nom);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
