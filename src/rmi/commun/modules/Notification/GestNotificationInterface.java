package rmi.commun.modules.Notification;
import java.rmi.Remote;
import java.rmi.RemoteException;

import rmi.commun.modules.chat.message.Message;
public interface GestNotificationInterface extends Remote {
	//Recuperation de la notification chez le client
	public Message recupNotif(Message notif,String type)throws RemoteException; 
}
