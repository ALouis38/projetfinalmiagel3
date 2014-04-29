package rmi.interfaces.modules.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import rmi.interfaces.modules.Utilisateur.Utilisateur;
import rmi.interfaces.modules.chat.message.Message;
import rmi.interfaces.modules.chat.message.MessageChat;


public interface GestChatInterface extends Remote {
	
	public void envoyerNotif(HashMap<String,Utilisateur> users, Message m, String type) throws RemoteException ;
	public ArrayList<Message> recevoirMessage(int indice) throws RemoteException ;
	
}
