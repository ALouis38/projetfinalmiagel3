package rmi.client.modules.Notification;

import java.awt.Frame;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JOptionPane;

import rmi.interfaces.modules.Notification.GestNotificationInterface;
import rmi.messages.Message;

public class GestNotificationImpl extends UnicastRemoteObject implements GestNotificationInterface {

	public GestNotificationImpl() throws RemoteException {
		super();
		
	}

	@Override
	public void recupNotif(Message notif,String type) {
		if(type.equals("message")){
			//TODO gestion message
			System.out.println("Message:" + notif);
		}
		else if(type.equals("error")){
			JOptionPane.showMessageDialog(new Frame(),
				    notif,
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
		}
	}

}
