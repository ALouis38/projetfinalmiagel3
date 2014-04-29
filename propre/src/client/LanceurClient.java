package rmi.client;

import rmi.client.core.Client;
import rmi.client.modules.Utilisateur.ClientUtilisateur;
import rmi.client.modules.chat.ClientChat;
import rmi.messages.MessageChat;


public class LanceurClient {

	public static void main(String[] args) {
		Client c = new Client(1099,"25.82.116.237");
		ClientChat cC = new ClientChat(1099, "192.168.1.5", "Jumbaa");

	}

}
