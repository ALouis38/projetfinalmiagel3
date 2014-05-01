package serveur.core;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Enumeration;

import rmi.serveur.core.GestFileImpl;
/**
 * Classe représentant le serveur
 * 
 *
 */
public class Serveur {
	
	private int port;
	private GestObjetImpl gestObj;
	private GestFileImpl gestFile;
	private String adresse;
	/**
	 * Constructeur du serveur
	 * @param port Port de connexion
	 * @param local Vrai si on sohaite utiliser l'adresse du r�seau local, faux si on utilise l'adresse externe
	 * @throws UnknownHostException
	 */
	public Serveur(int port, boolean local) throws UnknownHostException{
		this.port = port;
		System.setProperty("java.security.policy", "src/java.policy");
		
		if (!local) {
			
			URL whatismyip;
			try {
				whatismyip = new URL("http://checkip.amazonaws.com");
				
				BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
				String ip = in.readLine();
				System.out.println("utilisation via Internet, adresse IP : "+ ip);
				System.setProperty("java.rmi.server.hostname", ip);				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.adresse = InetAddress.getLocalHost().getHostAddress();

		
		try {
			LocateRegistry.createRegistry(this.port);	
			
			gestObj = new GestObjetImpl();
			gestObj.addObjet(gestObj, "rmi://"+adresse+":"+port+"/"+"gestObj");
			
			gestFile = new GestFileImpl();
			gestObj.addObjet(gestFile, "rmi://"+adresse+":"+port+"/"+"gestFile");
			
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
