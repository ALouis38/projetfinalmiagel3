package rmi.client;

import rmi.client.coreclient.Client;


public class LanceurClient {

	public static void main(String[] args) {
		Client c = new Client(1099,"152.77.116.58");
		
		
		//c.uploadFichierRegistry(1099, "152.77.116.58", "/home/a/amorel/git/projetfinalmiagel3/data/HubertLAFONTCV.pdf");
		
		//c.downloadFichierRegistry(1099, "152.77.116.58", "HubertLAFONTCV.pdf");
		
		c.supprimerFichier("HubertLAFONTCV.pdf");
		
	}

}
