package rmi.interfaces.core;

import rmi.serveur.modulesserveur.chat.MessageChat;

public interface GestMessageInterface {
	
	public void recupMessage(MessageChat message);
	public void renvoiMessage(MessageChat message);

}
