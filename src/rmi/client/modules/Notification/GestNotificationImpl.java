package rmi.client.modules.Notification;

import java.awt.Frame;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JOptionPane;

import rmi.commun.modules.Notification.GestNotificationInterface;
import rmi.commun.modules.chat.message.Message;

public class GestNotificationImpl extends UnicastRemoteObject implements GestNotificationInterface {

	protected GestNotificationImpl() throws RemoteException {
		super();
	}

	@Override
	public void recupNotif(Message notif,String type) {
		if(type.equals("message")){
			//TODO gestion message
			System.out.println("Expediteur:"  + notif.getExpediteur());
			System.out.println("Message:"  + notif.getTexte());
		}
		else if(type.equals("error")){
			JOptionPane.showMessageDialog(new Frame(),
					"Expediteur:"  + notif.getExpediteur() + "Message:"  + notif.getTexte(),
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
		}
	}

}
