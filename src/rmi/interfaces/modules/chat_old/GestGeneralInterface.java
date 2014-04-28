package rmi.interfaces.modules.chat_old;

import java.rmi.Remote;

import rmi.messages.Message;

public interface GestGeneralInterface extends Remote{

	public Message dowloadGeneral();
	public void uploadGeneral(Message msg);
	
}
