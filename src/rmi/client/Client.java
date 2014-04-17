package rmi.client;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.serveur.objetClient.ObjetTest;
import rmi.serveur.objetFonc.GestFileInterface;

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
	
	public void downloadFichierRegistry(int port, String adresseServ, String nomFichier){
		
		GestFileInterface fileTest = (GestFileInterface) getObjetRegistry(port, adresseServ, "gestFile");
		try {
			byte[] tab = fileTest.downloadFile(nomFichier);
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
	
	
	public void uploadFichierRegistry(int port, String adresse, String chemin){
		System.out.println("Lancement de la connexion");
		GestFileInterface r = null;
	      try {
				r = (GestFileInterface) Naming.lookup("rmi://" + adresse+ ":" + port + "/gestFile");
				
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
				r.uploadFile(buffer, nom);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			}
		    System.out.println("Objet renvoyé");
	}
}
