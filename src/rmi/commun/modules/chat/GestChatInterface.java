package rmi.commun.modules.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import rmi.commun.modules.Utilisateur.Utilisateur;
import rmi.commun.modules.chat.message.Message;
import rmi.commun.modules.chat.message.MessageChat;


public interface GestChatInterface extends Remote {
	
	//Permet l'envoi de notification aux utilisateurs de la liste
	public void envoyerNotif(HashMap<String,Utilisateur> users, Message m, String type) throws RemoteException ;
	public ArrayList<Message> recevoirMessage(int indice) throws RemoteException ;
	
}
