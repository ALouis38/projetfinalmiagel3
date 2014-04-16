package rmi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;

import objetTest.FileInterface;

public class LanceurClient {

	public static void main(String[] args) {
		Client c = new Client();
		FileInterface fileTest = (FileInterface)c.getObjetRegistry(1099, "152.77.116.53", "FileTest");

		try {
			byte[] tab = fileTest.downloadFile("fileTest");
			
			try {
				FileOutputStream fos = new FileOutputStream("fileTest");
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
