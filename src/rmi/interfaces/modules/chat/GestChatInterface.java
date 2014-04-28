package rmi.interfaces.modules.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import rmi.messages.Message;
import rmi.messages.MessageChat;


public interface GestChatInterface extends Remote {
	
	public void envoyerMessage(Message message) throws RemoteException ;
	public ArrayList<Message> recevoirMessage(int indice) throws RemoteException ;
	
}
