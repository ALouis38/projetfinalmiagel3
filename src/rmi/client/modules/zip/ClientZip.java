package rmi.client.modules.zip;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmi.client.core.Client;
import rmi.interfaces.modules.zip.GestZipInterface;
import rmi.serveur.modules.zip.GestZipImpl;

public class ClientZip extends Client {

	GestZipInterface zipI;

	public ClientZip(int p, String aS) {
		super(p, aS);
		//			 zipI = (GestZipInterface) Naming.lookup("rmi://"
//					+ this.adresseServ + ":" + this.port + "/gestZip");
		zipI = (GestZipInterface) getObjetRegistry("gestZip");
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
