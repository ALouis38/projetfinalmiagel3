package rmi.client;

import rmi.client.core.Client;
import rmi.client.modules.Utilisateur.ClientUtilisateur;
import rmi.client.modules.chat.ClientChat;
import rmi.messages.MessageChat;


public class LanceurClient {

	public static void main(String[] args) {
		Client c = new Client(1099,"82.225.46.137");
		ClientUtilisateur cU = new ClientUtilisateur(1099, "82.225.46.137", "BITE");
		c.downloadFichierRegistry("caca.txt");

	}

}
