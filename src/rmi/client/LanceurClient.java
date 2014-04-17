package rmi.client;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;

import rmi.serveur.objetFonc.GestFileInterface;

public class LanceurClient {

	public static void main(String[] args) {
		Client c = new Client();
		
		
		
		
		GestFileInterface fileTest = (GestFileInterface)c.getObjetRegistry(1099, "152.77.116.53", "eclipse");
		// air
		try {
			byte[] tab = fileTest.downloadFile("eclipse.tar.gz");
			// plus d'air
			try {
				FileOutputStream fos = new FileOutputStream("eclipse.tar.gz");
				try {
					fos.write(tab);
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
