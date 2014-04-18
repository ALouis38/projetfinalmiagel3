package rmi.client.modulesclient.zip;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmi.client.coreclient.Client;

public class ClientZip extends Client {

	GestZipInterface zipI;
	
	public ClientZip(int p, String aS) {
		super(p, aS);
		try {
			GestZipInterface gest = (GestZipInterface) Naming.lookup("rmi://" + this.adresseServ + ":" + this.port + "/gestZip");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
