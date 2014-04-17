package rmi.serveur.objetFonc;

import java.io.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

import rmi.serveur.Serveur;

public class GestFileImpl extends UnicastRemoteObject implements GestFileInterface {


	public GestFileImpl() throws RemoteException {

		super();

	}

	public byte[] downloadFile(String fileName) {

		try {

			File file = new File("../data/" +fileName);
			
			byte buffer[] = new byte[(int) file.length()];

			BufferedInputStream input = new	BufferedInputStream(new FileInputStream("../data/" + fileName));
			
			input.read(buffer, 0, buffer.length);

			input.close();

			return (buffer);

		} catch (Exception e) {

			System.out.println("FileImpl: " + e.getMessage());

			e.printStackTrace();

			return (null);

		}

	}

	@Override
	public void uploadFile(byte[] tab, String name) throws RemoteException {
		FileOutputStream fos;
		try {
				fos = new FileOutputStream("../data/" + name);
				try {
					fos.write(tab);
					fos.close();
					System.out.println("Fichier écrit");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}