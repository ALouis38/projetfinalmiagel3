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
			System.out.println("syso1 "+file.length());

			BufferedInputStream input = new	BufferedInputStream(new FileInputStream("/home/l/lafonth/git/projetfinalmiagel3/src/objetTest/" + fileName));

			System.out.println("syso2");
			
			input.read(buffer, 0, buffer.length);

			input.close();

			return (buffer);

		} catch (Exception e) {

			System.out.println("FileImpl: " + e.getMessage());

			e.printStackTrace();

			return (null);

		}

	}
}