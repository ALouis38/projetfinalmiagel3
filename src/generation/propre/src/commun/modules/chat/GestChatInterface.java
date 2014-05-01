package commun.modules.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import rmi.commun.modules.Utilisateur.Utilisateur;
import rmi.messages.Message;
import rmi.messages.MessageChat;


public interface GestChatInterface extends Remote {
	
	public void envoyerNotif(HashMap<String,Utilisateur> users, Message m, String type) throws RemoteException ;
	public ArrayList<Message> recevoirMessage(int indice) throws RemoteException ;
	
}
