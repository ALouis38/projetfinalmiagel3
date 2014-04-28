package rmi.serveur.modules.chat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import rmi.interfaces.modules.chat.GestChatInterface;
import rmi.messages.Message;
import rmi.messages.MessageChat;

public class GestChatImpl extends UnicastRemoteObject implements
		GestChatInterface {
	
	ArrayList<Message> messages;
	
	public GestChatImpl() throws RemoteException {
		super();
		ArrayList<MessageChat> messages = new ArrayList<MessageChat>();
	}


	@Override
	public ArrayList<Message> recevoirMessage(int indice) {
		ArrayList<Message> messagesR = new ArrayList<Message>();
		while(indice < this.messages.size()){
			messagesR.add(this.messages.get(indice));
			indice++;
		}
		return messagesR;
	}


	@Override
	public void envoyerMessage(Message message) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	
}
