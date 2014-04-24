package rmi.serveur.modules.Notification;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.interfaces.modules.Notification.GestNotificationInterface;
public class GestNotificationImpl extends UnicastRemoteObject implements GestNotificationInterface {
	public GestNotificationImpl() throws RemoteException {
		super();
	}
	
}
