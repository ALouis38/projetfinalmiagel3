package client.modules.Notification;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmi.client.modules.Notification.GestNotificationImpl;
import rmi.client.modules.Notification.GestObjetImpl;
import client.core.Client;
import commun.modules.Notification.GestNotificationInterface;
public class ClientNotification extends Client {
	public ClientNotification(int p, String aS, int regP) {
		super(p, aS);		
		try {
			LocateRegistry.createRegistry(regP);
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
				gestObj.addObjet(gestObj, "rmi://"+InetAddress.getLocalHost().getHostAddress()+":"+ regP +"/gestObj");
				gestObj.addObjet(notif, "rmi://"+InetAddress.getLocalHost().getHostAddress()+":"+ regP +"/gestNotif");
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
