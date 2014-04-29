package rmi.serveur.core;

import java.io.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import rmi.interfaces.core.GestFileInterface;

public class GestFileImpl extends UnicastRemoteObject implements GestFileInterface {


		ArrayList<String> listeFichiers;
	
	public GestFileImpl() throws RemoteException {

		super(1099);
		listeFichiers = new ArrayList<String>();

	}

	public byte[] downloadFile(String fileName) {

		try {

			File file = new File("data/" +fileName);
			
			byte buffer[] = new byte[(int) file.length()];

			BufferedInputStream input = new	BufferedInputStream(new FileInputStream("data/" + fileName));
			
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
				fos = new FileOutputStream("data/" + name);
				try {
					fos.write(tab);
					fos.close();
					System.out.println("Fichier écrit "+ tab.length );
					listeFichiers.add(name);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void supprFile(String nom) throws RemoteException {
		File f = new File("data/"+nom);
		f.delete();
		listeFichiers.remove(nom);
		
	}

	@Override
	public ArrayList<String> getListeFichiers() throws RemoteException {
		return listeFichiers;
	}

}