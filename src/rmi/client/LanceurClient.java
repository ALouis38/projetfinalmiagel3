package rmi.client;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;

import rmi.serveur.objetFonc.GestFileInterface;

public class LanceurClient {

	public static void main(String[] args) {
		Client c = new Client();
		
		
		//c.uploadFichierRegistry(1099, "152.77.116.58", "/home/a/amorel/git/projetfinalmiagel3/data/HubertLAFONTCV.pdf");
		
		//c.downloadFichierRegistry(1099, "152.77.116.58", "HubertLAFONTCV.pdf");
		
		c.supprimerFichier(1099, "152.77.116.58", "HubertLAFONTCV.pdf");
		
	}

}
