package rmi.client.coreclient;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import rmi.client.coreclient.GestFileInterface;
import rmi.client.coreclient.GestObjetInterface;

public class Client {
	
	private int port;
	private String adresseServ;
	
	public Client(int p, String aS){
		port = p;
		adresseServ = aS;
	}
	
	public Remote getObjetRegistry(String nom){
		System.out.println("Lancement de la connexion");
	      GestObjetInterface r = null;
		try {
			r = (GestObjetInterface) Naming.lookup("rmi://" + adresseServ+ ":" + port + "/gestObjet");
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
	
	public void addObjetRegistry(Remote obj){
		System.out.println("Lancement de la connexion");
		
	    System.out.println("Objet envoyé");
	}
	
	public void downloadFichierRegistry(String nomFichier){
		
		GestFileInterface fileTest = (GestFileInterface) getObjetRegistry("gestFile");
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
	
	
	public void uploadFichierRegistry(String chemin){
		System.out.println("Lancement de la connexion");
		GestFileInterface r = null;
	      try {
				r = (GestFileInterface) Naming.lookup("rmi://" + adresseServ+ ":" + port + "/gestFile");
				
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
	
	public void supprimerFichier(String nomFichier){
		try {
			GestFileInterface gestFile = (GestFileInterface) Naming.lookup("rmi://" + adresseServ+ ":" + port + "/gestFile");
			gestFile.supprFile(nomFichier);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
