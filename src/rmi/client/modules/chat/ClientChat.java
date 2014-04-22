package rmi.client.modules.chat;

import java.rmi.RemoteException;
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
		try {
			chatI.envoyerMessage(message);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<MessageChat> recevoirMessage(int indice){
		try {
			return chatI.recevoirMessage(indice);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
