package rmi.client;

import rmi.client.core.Client;
import rmi.client.modules.chat.ClientChat;
import rmi.client.modules.zip.ClientZip;
import rmi.serveur.modules.chat.MessageChat;


public class LanceurClient {

	public static void main(String[] args) {
		Client c = new Client(1099,"152.77.116.62");
		//ClientZip cZip = new ClientZip(1099, "152.77.116.58");
//		ClientChat cChat = new ClientChat(1099,"152.77.116.62");
		
		String[] fichiers =  {"cv.pdf","potion.jpg"};
		String repertoire = "../data";
		
		//c.uploadFichierRegistry(1099, "152.77.116.58", "/home/a/amorel/git/projetfinalmiagel3/data/HubertLAFONTCV.pdf");
//		cChat.envoyerMessage(new MessageChat("Coucou"));
		c.downloadFichierRegistry("help.pdf");
		//c.supprimerFichier("HubertLAFONTCV.pdf");
		//cZip.compression(fichiers, repertoire);
		
	}

}
