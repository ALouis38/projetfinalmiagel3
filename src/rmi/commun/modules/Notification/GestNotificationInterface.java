package rmi.commun.modules.Notification;
import java.rmi.Remote;
import java.rmi.RemoteException;

import rmi.commun.modules.chat.message.Message;
public interface GestNotificationInterface extends Remote {
	public Message recupNotif(Message notif,String type)throws RemoteException; 
}
