package rmi.interfaces.modules.Notification;
import java.rmi.Remote;
import java.rmi.RemoteException;

import rmi.messages.Message;
public interface GestNotificationInterface extends Remote {
	public void recupNotif(Message notif,String type); 
}
