package rmi.client.modulesclient.chat;

import rmi.serveur.modulesserveur.chat.MessageChat;
import rmi.serveur.modulesserveur.chat.Utilisateur;

public interface GestMessageInterface {

	public void recupMessage(MessageChat message);
	public void renvoiMessage(MessageChat message);
	
}
