package rmi.serveur;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import rmi.serveur.core.GestFileImpl;
import rmi.serveur.core.Serveur;
import rmi.serveur.modules.chat.GestChatImpl;
import rmi.serveur.modules.zip.GestZipImpl;

public class LanceurServeur {

	public static void main(String[] args) {
		try {
			Serveur serv = new Serveur(1099);
			
			GestFileImpl fileTest;
			GestZipImpl zippeur;
			GestChatImpl chat;
			try {
				fileTest = new GestFileImpl();
				zippeur = new GestZipImpl();
				chat = new GestChatImpl();

				serv.addGestionnaire(fileTest, "gestFile");
				serv.addGestionnaire(zippeur, "gestZip");
				serv.addGestionnaire(chat, "gestChat");
			} catch (RemoteException e) {
				e.printStackTrace();
			}
	
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
