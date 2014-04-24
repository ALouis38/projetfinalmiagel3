package rmi.client.modules.Notification;

import java.awt.Frame;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JOptionPane;

import rmi.interfaces.modules.Notification.GestNotificationInterface;

public class GestNotificationImpl extends UnicastRemoteObject implements GestNotificationInterface {

	public GestNotificationImpl() throws RemoteException {
		super();
		
	}

	@Override
	public String recupNotif(String notif,String type) {
		if(type.equals("message")){
			//TODO gestion message
		}
		else if(type.equals("error")){
			JOptionPane.showMessageDialog(new Frame(),
				    notif,
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
		}
		return notif;
	}

}
