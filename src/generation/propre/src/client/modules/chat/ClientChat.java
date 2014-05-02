package client.modules.chat;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import client.core.Client;
import client.modules.Utilisateur.ClientUtilisateur;
import commun.modules.Utilisateur.GestUtilisateurInterface;
import commun.modules.Utilisateur.Utilisateur;
import commun.modules.chat.GestChatInterface;
import commun.modules.chat.message.Message;
import commun.modules.chat.message.MessageChat;

public class ClientChat extends Client {

	GestChatInterface chatI;
	GestUtilisateurInterface gU;

	public ClientChat(int p, String aS, String pseudo) {
		super(p, aS);
		chatI = (GestChatInterface) getObjetRegistry("gestChat");
		ClientUtilisateur cU = new ClientUtilisateur(p, aS, pseudo);

	}

	public void envoyerMessage(Message message) {
		try {
			HashMap<String, Utilisateur> users = gU.getListeUtilisateurs();
			chatI.envoyerNotif(users, message, adresseServ);
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
