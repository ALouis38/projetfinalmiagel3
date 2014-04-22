package rmi.interfaces.modules.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import rmi.serveur.modules.chat.MessageChat;


public interface GestChatInterface extends Remote {
	
	public void envoyerMessage(MessageChat message) throws RemoteException ;
	public ArrayList<MessageChat> recevoirMessage(int indice) throws RemoteException ;
	
}
