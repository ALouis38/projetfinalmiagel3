package rmi.interfaces.modules.chat_old;

import java.rmi.Remote;

import rmi.interfaces.modules.chat.message.Message;

public interface GestGeneralInterface extends Remote{

	public Message dowloadGeneral();
	public void uploadGeneral(Message msg);
	
}
