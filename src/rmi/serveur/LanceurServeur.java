package rmi.serveur;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import rmi.serveur.coreserveur.GestFileImpl;
import rmi.serveur.coreserveur.Serveur;
import rmi.serveur.modulesserveur.chat.GestChatImpl;
import rmi.serveur.modulesserveur.zip.GestZipImpl;

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
