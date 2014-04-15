package rmi;


import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import objetTest.*;

public class Serveur {

	public static void main(String[] argv) {
		try {
			// Crée une instance de l'objet distant : génération du stub
			ObjetTest skeleton = (ObjetTest) UnicastRemoteObject.exportObject(
					new ObjetTestImpl(), 10000);
			// Crée le registre sur lequel se trouvera l'instance
			Registry registry = LocateRegistry.createRegistry(10000);
			// Publie l'instance sur le registre sous le nom "ObjetTest"
			registry.rebind("ObjetTest", skeleton);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
