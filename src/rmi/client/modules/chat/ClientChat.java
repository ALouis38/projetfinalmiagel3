package rmi.client.modules.chat;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import rmi.client.core.Client;
import rmi.client.modules.Notification.ClientNotification;
import rmi.client.modules.Utilisateur.ClientUtilisateur;
import rmi.commun.modules.Utilisateur.GestUtilisateurInterface;
import rmi.commun.modules.Utilisateur.Utilisateur;
import rmi.commun.modules.chat.GestChatInterface;
import rmi.commun.modules.chat.message.Message;
import rmi.commun.modules.chat.message.MessageChat;

public class ClientChat extends Client {

	GestChatInterface chatI;
	GestUtilisateurInterface gU;
	String pseudo;
	ClientNotification cN;

	public ClientChat(int p, String aS, String pseudo, int regP) {
		super(p, aS);
		chatI = (GestChatInterface) getObjetRegistry("gestChat");
		cN = new ClientNotification(p, aS, regP);
		ClientUtilisateur cU = new ClientUtilisateur(p, aS, pseudo,regP);
		this.pseudo = pseudo;
	}

	public void envoyerMessage(Message message) {
		try {
			gU = (GestUtilisateurInterface) getObjetRegistry("gestUtilisateur");
			HashMap<String, Utilisateur> users = new HashMap<String, Utilisateur>();
			users.putAll(gU.getListeUtilisateurs());
			System.out.println("Nb Users:" + users.size());
			chatI.envoyerNotif(users, message, "message");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Message> recevoirMessage(int indice) {
		try {
			return chatI.recevoirMessage(indice);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public GestChatInterface getChatI() {
		return chatI;
	}

	public ClientNotification getcN() {
		return cN;
	}

	public void deconnection(String pseudo) {
		try {
			gU.removeUtilisateur(pseudo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
