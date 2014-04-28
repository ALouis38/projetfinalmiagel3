package rmi.client;

import rmi.client.core.Client;
import rmi.client.modules.Utilisateur.ClientUtilisateur;
import rmi.client.modules.chat.ClientChat;
import rmi.messages.MessageChat;


public class LanceurClient {

	public static void main(String[] args) {
		Client c = new Client(1099,"152.77.116.62");
		ClientUtilisateur cU = new ClientUtilisateur(1099, "", "BITE");
	}

}
