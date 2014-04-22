package rmi.interfaces.core;

import rmi.serveur.core.Message;

public interface GestMessageInterface {
	
	public void recupMessage(Message message);
	public void renvoiMessage(Message message);

}
