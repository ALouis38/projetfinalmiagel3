package rmi.client.modules.Notification;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmi.client.core.Client;
import rmi.interfaces.modules.Notification.GestNotificationInterface;
public class ClientNotification extends Client {
	GestNotificationInterface gestI;
	public ClientNotification(int p, String aS) {
		super(p, aS);
		gestI = (GestNotificationInterface) getObjetRegistry("gestNotification");
		
		try {
			LocateRegistry.createRegistry(2000);
			GestNotificationImpl notif = new GestNotificationImpl();
			
			GestObjetImpl gestObj;
			try {
				gestObj = new GestObjetImpl();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			gestObj = new GestObjetImpl();
			try {
				gestObj.addObjet(gestObj, "rmi://"+InetAddress.getLocalHost().getHostAddress()+":2000/"+"gestObj");
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
}
