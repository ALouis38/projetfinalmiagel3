package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import objetTest.ObjetTest;

public class Client {
	public static void main(String[] argv){
		try {
			// Récupère le registre
			Registry registry = LocateRegistry.getRegistry(10000);
			// Récupération de l'instance de l'objet distant
			ObjetTest stub = (ObjetTest) registry.lookup("ObjetTest");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
