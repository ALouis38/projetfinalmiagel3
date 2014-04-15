package rmi;


import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import objetTest.*;

public class Serveur {

	public static void main(String[] argv) throws java.net.UnknownHostException{
		
		try {
			String port = "11000";
			LocateRegistry.createRegistry(Integer.parseInt(port));

		    System.out.println("Mise en place du Security Manager ...");	
		    if (System.getSecurityManager() == null) {
		      System.setSecurityManager(new RMISecurityManager());
		    }
		    
		    ObjetTestImpl informationImpl = new ObjetTestImpl();
		 
		    String url = "TestRMI";
		    System.out.println("Enregistrement de l'objet avec l'url : rmi://" + InetAddress.getLocalHost().getHostAddress() +":"+ port +"/" + url);
		    Naming.rebind(url, informationImpl);

		    System.out.println("Serveur lancé");
		  } catch (RemoteException e) {
		    e.printStackTrace();
		  } catch (MalformedURLException e) {
		    e.printStackTrace();
		  }
		
		
		
		
//		try {
//			// Crée une instance de l'objet distant : génération du stub
//			ObjetTest skeleton = (ObjetTest) UnicastRemoteObject.exportObject(
//					new ObjetTestImpl(), 10000);
//			// Crée le registre sur lequel se trouvera l'instance
//			Registry registry = LocateRegistry.createRegistry(10000);
//			// Publie l'instance sur le registre sous le nom "ObjetTest"
//			registry.rebind("ObjetTest", skeleton);
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
	}
}
