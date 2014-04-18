package rmi.client.coreclient;

import rmi.serveur.modulesserveur.chat.Message;
import rmi.serveur.modulesserveur.chat.Utilisateur;

public interface GestMessageInterface {

	public void recupMessage(Utilisateur user, Message message);
	public void renvoiMessage(Message message);
	
}
