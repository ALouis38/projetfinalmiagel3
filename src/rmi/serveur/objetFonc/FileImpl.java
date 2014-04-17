package rmi.serveur.objetFonc;

import java.io.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class FileImpl extends UnicastRemoteObject implements FileInterface {

	private String name;

	public FileImpl(String s) throws RemoteException {

		super();

		name = s;

	}

	public byte[] downloadFile(String fileName) {

		try {

			File file = new File("/home/l/lafonth/git/projetfinalmiagel3/src/objetTest/" +fileName);
			
			byte buffer[] = new byte[(int) file.length()];

			BufferedInputStream input = new	BufferedInputStream(new FileInputStream("/home/l/lafonth/git/projetfinalmiagel3/src/objetTest/" + fileName));
			
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
				fos = new FileOutputStream("/home/l/lafonth/git/projetfinalmiagel3/src/rmi/serveur/objetClient/" + name);
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