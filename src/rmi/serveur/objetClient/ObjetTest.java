package rmi.serveur.objetClient;

import java.rmi.*;

public interface ObjetTest extends Remote {
	//La méthode de test renverra le String "OK"
	public String test() throws java.rmi.RemoteException;
}
