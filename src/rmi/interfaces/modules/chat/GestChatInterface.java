package rmi.interfaces.modules.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import rmi.serveur.modulesserveur.chat.MessageChat;


public interface GestChatInterface extends Remote {
	
	void envoyerMessage(MessageChat message);
	ArrayList<MessageChat> recevoirMessage(int indice);
	
}
