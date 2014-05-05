package rmi.client.modules.Notification;

import java.awt.Frame;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JOptionPane;

import rmi.client.modules.chat.EcouteurMessage;
import rmi.commun.modules.Notification.GestNotificationInterface;
import rmi.commun.modules.chat.message.Message;

public class GestNotificationImpl extends UnicastRemoteObject implements GestNotificationInterface {

	private EcouteurMessage eM;
	
	protected GestNotificationImpl() throws RemoteException {
		super();
	}

	@Override
	public Message recupNotif(Message notif,String type) {
		eM.messageRecu(notif);		
		return notif;
	}

	public void setEcouteurMessage(EcouteurMessage ecouteurM) {
		this.eM = ecouteurM;		
	}

}
