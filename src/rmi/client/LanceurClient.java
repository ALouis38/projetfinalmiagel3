package rmi.client;

import rmi.client.coreclient.Client;
import rmi.client.modulesclient.chat.ClientChat;
import rmi.client.modulesclient.zip.ClientZip;
import rmi.serveur.modulesserveur.chat.MessageChat;


public class LanceurClient {

	public static void main(String[] args) {
		Client c = new Client(1099,"152.77.116.62");
		//ClientZip cZip = new ClientZip(1099, "152.77.116.58");
		ClientChat cChat = new ClientChat(1099,"152.77.116.62");
		
		String[] fichiers =  {"cv.pdf","potion.jpg"};
		String repertoire = "../data";
		
		//c.uploadFichierRegistry(1099, "152.77.116.58", "/home/a/amorel/git/projetfinalmiagel3/data/HubertLAFONTCV.pdf");
		cChat.envoyerMessage(new MessageChat("Coucou"));
		//c.downloadFichierRegistry(1099, "152.77.116.58", "HubertLAFONTCV.pdf");
		//c.supprimerFichier("HubertLAFONTCV.pdf");
		//cZip.compression(fichiers, repertoire);
		
	}

}
