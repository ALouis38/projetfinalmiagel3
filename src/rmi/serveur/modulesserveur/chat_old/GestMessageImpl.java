package rmi.serveur.modulesserveur.chat_old;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import rmi.interfaces.core.GestMessageInterface;
import rmi.serveur.modulesserveur.chat.MessageChat;

public class GestMessageImpl extends UnicastRemoteObject implements GestMessageInterface{

	public ArrayList<Utilisateur> listeUser;
	
	protected GestMessageImpl() throws RemoteException {
		super();
		listeUser = new ArrayList<Utilisateur>();
	}

	@Override
	public void recupMessage(MessageChat message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renvoiMessage(MessageChat message) {
		// TODO Auto-generated method stub
		
	}
	
	

}
