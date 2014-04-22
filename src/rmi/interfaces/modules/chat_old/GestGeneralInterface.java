package rmi.interfaces.modules.chat_old;

import java.rmi.Remote;

import rmi.serveur.coreserveur.Message;

public interface GestGeneralInterface extends Remote{

	public Message dowloadGeneral();
	public void uploadGeneral(Message msg);
	
}
