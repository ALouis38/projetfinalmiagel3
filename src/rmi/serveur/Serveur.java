package rmi.serveur;


import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmi.serveur.objetFonc.GestFileImpl;
/**
 * Classe représentant le serveur
 * 
 *
 */
public class Serveur {
	
	private int port;
	/**
	 * Constructeur du serveur. Etablit 
	 * @param port
	 * @throws UnknownHostException
	 */
	public Serveur(int port) throws UnknownHostException{
		this.port = port;
		try {
			LocateRegistry.createRegistry(this.port);
			
			
		GestFileImpl fileTest = new GestFileImpl();
			
			try {
				enregistrerObjetRegistry("gestFile", fileTest);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
		    System.out.println("Serveur lancé");
		  } catch (RemoteException e) {
		    e.printStackTrace();
		  } 
	}
	
	public void enregistrerObjetRegistry(String nom, Remote obj) throws RemoteException, MalformedURLException{
		Naming.rebind(nom, obj);
		try {
			System.out.println("Enregistrement de l'objet avec l'url : rmi://" + 
			InetAddress.getLocalHost().getHostAddress() +":"+ port + "/" + nom);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	} 
}
