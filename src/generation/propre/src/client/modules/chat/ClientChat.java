package client.modules.chat;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import client.core.Client;
import client.modules.Utilisateur.ClientUtilisateur;
import interfaces.modules.Utilisateur.GestUtilisateurInterface;
import interfaces.modules.Utilisateur.Utilisateur;
import interfaces.modules.chat.GestChatInterface;
import messages.Message;
import messages.MessageChat;

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
