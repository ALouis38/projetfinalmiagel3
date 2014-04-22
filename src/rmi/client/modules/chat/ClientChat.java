package rmi.client.modules.chat;

import java.util.ArrayList;

import rmi.client.core.Client;
import rmi.interfaces.modules.chat.GestChatInterface;
import rmi.serveur.modules.chat.MessageChat;


public class ClientChat extends Client {
	
	GestChatInterface chatI;

	public ClientChat(int p, String aS) {
		super(p, aS);
		chatI = (GestChatInterface) getObjetRegistry("gestChat");
	}
	
	public void envoyerMessage(MessageChat message){
		chatI.envoyerMessage(message);
	}
	
	public ArrayList<MessageChat> recevoirMessage(int indice){
		return chatI.recevoirMessage(indice);
	}
	
}
