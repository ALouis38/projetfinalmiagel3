package rmi.client.modules.chat;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import rmi.client.core.Client;
import rmi.client.modules.Utilisateur.ClientUtilisateur;
import rmi.interfaces.modules.Utilisateur.GestUtilisateurInterface;
import rmi.interfaces.modules.chat.GestChatInterface;
import rmi.messages.Message;
import rmi.messages.MessageChat;


public class ClientChat extends Client {
	
	GestChatInterface chatI;
	GestUtilisateurInterface gU;

	public ClientChat(int p, String aS, String pseudo) {
		super(p, aS);
		chatI = (GestChatInterface) getObjetRegistry("gestChat");
		ClientUtilisateur cU = new ClientUtilisateur(p, aS, pseudo);

	}
	
	public void envoyerMessage(Message message){
		try {
			chatI.envoyerMessage(message);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Message> recevoirMessage(int indice){
		try {
			return chatI.recevoirMessage(indice);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
