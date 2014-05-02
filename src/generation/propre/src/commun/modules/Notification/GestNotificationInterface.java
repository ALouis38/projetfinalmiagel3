package commun.modules.Notification;
import java.rmi.Remote;
import java.rmi.RemoteException;

import commun.modules.chat.message.Message;

public interface GestNotificationInterface extends Remote {
	public void recupNotif(Message notif,String type)throws RemoteException; 
}

