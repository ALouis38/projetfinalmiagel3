package rmi.client.modules.chat;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import rmi.client.core.Client;
import rmi.interfaces.modules.Utilisateur.GestUtilisateurInterface;
import rmi.interfaces.modules.chat.GestChatInterface;
import rmi.serveur.modules.chat.MessageChat;


public class ClientChat extends Client {
	
	GestChatInterface chatI;
	GestUtilisateurInterface gU;

	public ClientChat(int p, String aS, String pseudo) {
		super(p, aS);
		chatI = (GestChatInterface) getObjetRegistry("gestChat");
		gU = (GestUtilisateurInterface) getObjetRegistry("gestUtilisateur");
		try {
			gU.addUtilisateur(pseudo, InetAddress.getLocalHost().getAddress().toString());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
