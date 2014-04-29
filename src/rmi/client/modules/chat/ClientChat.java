package rmi.client.modules.chat;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import rmi.client.core.Client;
import rmi.client.modules.Notification.ClientNotification;
import rmi.client.modules.Utilisateur.ClientUtilisateur;
import rmi.interfaces.modules.Utilisateur.GestUtilisateurInterface;
import rmi.interfaces.modules.Utilisateur.Utilisateur;
import rmi.interfaces.modules.chat.GestChatInterface;
import rmi.interfaces.modules.chat.message.Message;
import rmi.interfaces.modules.chat.message.MessageChat;

public class ClientChat extends Client {

	GestChatInterface chatI;
	GestUtilisateurInterface gU;

	public ClientChat(int p, String aS, String pseudo, int regP) {
		super(p, aS);
		chatI = (GestChatInterface) getObjetRegistry("gestChat");
		ClientNotification cN = new ClientNotification(p, aS, regP);
		ClientUtilisateur cU = new ClientUtilisateur(p, aS, pseudo,regP);
	}

	public void envoyerMessage(Message message) {
		try {
			gU = (GestUtilisateurInterface) getObjetRegistry("gestUtilisateur");
			HashMap<String, Utilisateur> users = new HashMap<String, Utilisateur>();
			users.putAll(gU.getListeUtilisateurs());
			System.out.println("Taille liste:" + users.size());
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

}
