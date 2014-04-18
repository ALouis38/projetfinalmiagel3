package rmi.client.modulesclient.zip;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmi.client.coreclient.Client;
import rmi.serveur.modulesserveur.zip.GestZipImpl;

public class ClientZip extends Client {

	GestZipInterface zipI;

	public ClientZip(int p, String aS) {
		super(p, aS);
		try {
			GestZipInterface gest = (GestZipInterface) Naming.lookup("rmi://"
					+ this.adresseServ + ":" + this.port + "/gestZip");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public void compression(String[] fichiers, String repertoire){
		try {
			zipI.compression(fichiers, repertoire);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void decompression(String nomArchive, String repertoire){
		try {
			zipI.decompression(nomArchive, repertoire);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
