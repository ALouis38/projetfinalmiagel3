package rmi.serveur.modules.chat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import rmi.interfaces.modules.chat.GestChatInterface;

public class GestChatImpl extends UnicastRemoteObject implements
		GestChatInterface {
	
	ArrayList<MessageChat> messages;
	
	public GestChatImpl() throws RemoteException {
		super();
		ArrayList<MessageChat> messages = new ArrayList<MessageChat>();
	}

	@Override
	public void envoyerMessage(MessageChat message) {
		this.messages.add(message);
	}

	@Override
	public ArrayList<MessageChat> recevoirMessage(int indice) {
		ArrayList<MessageChat> messagesR = new ArrayList<MessageChat>();
		while(indice < this.messages.size()){
			messagesR.add(this.messages.get(indice));
			indice++;
		}
		return messagesR;
	}
	
	
}
