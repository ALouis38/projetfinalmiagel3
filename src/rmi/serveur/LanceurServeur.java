package rmi.serveur;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import rmi.serveur.core.GestFileImpl;
import rmi.serveur.core.Serveur;
import rmi.serveur.modules.Utilisateur.GestUtilisateurImpl;
import rmi.serveur.modules.chat.GestChatImpl;

public class LanceurServeur {

	public static void main(String[] args) {
		try {
			Serveur serv = new Serveur(1099,false);
			
			GestFileImpl fileTest;
			GestChatImpl chat;
			GestUtilisateurImpl user;
			try {
				fileTest = new GestFileImpl();
				chat = new GestChatImpl();
				user = new GestUtilisateurImpl();

				serv.addGestionnaire(fileTest, "gestFile");
				serv.addGestionnaire(chat, "gestChat");
				serv.addGestionnaire(chat, "gestUtilisateur");
			} catch (RemoteException e) {
				e.printStackTrace();
			}
	
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
