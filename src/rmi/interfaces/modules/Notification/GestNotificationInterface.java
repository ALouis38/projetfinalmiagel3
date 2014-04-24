package rmi.interfaces.modules.Notification;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface GestNotificationInterface extends Remote {
	public String recupNotif(String notif); 
}
