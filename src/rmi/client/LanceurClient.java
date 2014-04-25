package rmi.client;

import rmi.client.core.Client;
import rmi.client.modules.chat.ClientChat;
import rmi.serveur.modules.chat.MessageChat;


public class LanceurClient {

	public static void main(String[] args) {
		Client c = new Client(1099,"152.77.116.62");
		
	}

}
