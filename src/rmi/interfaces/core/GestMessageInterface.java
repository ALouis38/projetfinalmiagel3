package rmi.interfaces.core;

import rmi.interfaces.modules.chat.message.Message;

public interface GestMessageInterface {
	
	public void recupMessage(Message message);
	public void renvoiMessage(Message message);

}
