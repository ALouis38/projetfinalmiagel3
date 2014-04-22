package rmi.interfaces.core;

import rmi.serveur.modules.chat.MessageChat;

public interface GestMessageInterface {
	
	public void recupMessage(MessageChat message);
	public void renvoiMessage(MessageChat message);

}
