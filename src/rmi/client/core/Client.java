package rmi.client.core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmi.client.modules.Notification.GestNotificationImpl;
import rmi.client.modules.Notification.GestObjetImpl;
import rmi.interfaces.core.GestFileInterface;
import rmi.interfaces.core.GestObjetInterface;
/**
 * Classe de base du client. Contient les méthodes manipulant les objets Remote côté client
 *
 */
public class Client {
	
	protected int port;
	protected String adresseServ;
	protected GestFileInterface gestFile;
	
	/**
	 * Constructeur du Client.
	 * @param p le port de connexion
	 * @param aS l'adresse du serveur distant
	 */
	public Client(int p, String aS){
		port = p;
		adresseServ = aS;
		gestFile = (GestFileInterface) getObjetRegistry("gestFile");
		GestObjetImpl gestObj;
		try {
			gestObj = new GestObjetImpl();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			LocateRegistry.createRegistry(2000);
			GestNotificationImpl notif = new GestNotificationImpl();
			gestObj = new GestObjetImpl();
			try {
				gestObj.addObjet(gestObj, "rmi://"+InetAddress.getLocalHost().getHostAddress()+":2000/"+"gestObj");
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	/**
	 * Permet de récupére run objet Remote présent dans le registry, principalement les gesitonnaires de modules
	 * @param nom nom de l'objet Remote à récupérer
	 * @return lobjet Remote récupéré
	 */
	public Remote getObjetRegistry(String nom){
		System.out.println("Lancement de la connexion");
	      GestObjetInterface r = null;
		try {
			r = (GestObjetInterface) Naming.lookup("rmi://" + adresseServ+ ":" + port + "/gestObj");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
	    System.out.println("Objet récupéré");
	      try {
			return r.getObjet(adresseServ, port, nom);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	/**
	 * Permet d'ajouter un objet Remote au registry
	 * @param obj l'objet Remote à ajoute rau registry
	 */
	public void addObjetRegistry(Remote obj){
		System.out.println("Lancement de la connexion");
		
	    System.out.println("Objet envoyé");
	}
	
	public void downloadFichierRegistry(String nomFichier){

		try {
			byte[] tab = gestFile.downloadFile(nomFichier);
			if(tab.length != 0){
				try {
				FileOutputStream fos = new FileOutputStream("data/"+nomFichier);
				try {
					fos.write(tab);
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Permet de placer un fichier sur le serveur, dans le dossier data/
	 * @param chemin Chemin du fichier à uploadé côté client
	 */
	public void uploadFichierRegistry(String chemin){
		System.out.println("Lancement de la connexion");
		GestFileInterface r = null;
	      try {
			
				
				File f = new File (chemin);
				
				byte buffer[] = new byte[(int) f.length()];

				BufferedInputStream input;
				try {
						input = new	BufferedInputStream(new FileInputStream(chemin));

						input.read(buffer, 0, buffer.length);
						input.close();

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String[] bits = chemin.split("/");
				String nom = bits[bits.length-1];
				System.out.println(buffer.length);
				gestFile.uploadFile(buffer, nom);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		    System.out.println("Objet renvoyé");
	}
	
	/**
	 * Permet de supprimer un fichier présent sur le serveur dans le répertoire data/
	 * @param nomFichier Nom du fichier à supprimer
	 */
	public void supprimerFichier(String nomFichier){
		try {
			gestFile.supprFile(nomFichier);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
