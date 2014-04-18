package rmi.serveur.modulesserveur.chat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class GestMessageImpl extends UnicastRemoteObject implements GestMessageInterface{

	public ArrayList<Utilisateur> listeUser;
	
	protected GestMessageImpl() throws RemoteException {
		super();
		listeUser = new ArrayList<Utilisateur>();
	}

	@Override
	public void recupMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renvoiMessage(Message message) {
		// TODO Auto-generated method stub
		
	}
	
	

}
