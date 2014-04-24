package rmi.client.modules.Notification;
import rmi.client.core.Client;
import rmi.interfaces.modules.Notification.GestNotificationInterface;
public class ClientNotification extends Client {
	GestNotificationInterface gestI;
	public ClientNotification(int p, String aS) {
		super(p, aS);
		gestI = (GestNotificationInterface) getObjetRegistry("gestNotification");
		//prout
	}
}
