package rmi.serveur.core;

import java.io.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import rmi.commun.core.GestFileInterface;

public class GestFileImpl extends UnicastRemoteObject implements GestFileInterface {


		ArrayList<String> listeFichiers;
	
	public GestFileImpl() throws RemoteException {

		super(1099);
		listeFichiers = restaureListeFichiers();

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
					updateListeFichiers();
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
		updateListeFichiers();
		
	}

	@Override
	public ArrayList<String> getListeFichiers() throws RemoteException {
		return listeFichiers;
	}
	
	private void updateListeFichiers() {
		FileOutputStream fout;
		try {
			fout = new FileOutputStream ("listefichiers.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(listeFichiers);
			fout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private ArrayList<String> restaureListeFichiers(){
		ArrayList<String> liste = new ArrayList<String>();
		File f = new File("listefichiers.dat");
		if (f.exists()) {
			FileInputStream fin;
			try {
				fin = new FileInputStream ("listefichiers.dat");
				ObjectInputStream ois = new ObjectInputStream(fin);
				liste = (ArrayList<String>)ois.readObject();
				fin.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return liste;
	}

}