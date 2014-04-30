package rmi.client;

import rmi.client.core.Client;
import rmi.client.modules.Utilisateur.ClientUtilisateur;
import rmi.client.modules.chat.ClientChat;
import rmi.interfaces.modules.chat.message.Message;
import rmi.interfaces.modules.chat.message.MessageChat;


public class LanceurClient {

	public static void main(String[] args) {
//		Client c = new Client(1099,"192.168.1.5");
		ClientChat cC = new ClientChat(1099, "192.168.1.5", "Jumbaa", 2000);
		ClientChat cC2 = new ClientChat(1099, "192.168.1.5", "Zerooid", 2111);
		ClientChat cC3 = new ClientChat(1099, "192.168.1.5", "Le3emeType", 2222);
		cC.envoyerMessage(new Message(cC.getPseudo(), "COUCOU"));
	}

}
