package rmi.client.modules.Notification;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import rmi.commun.core.GestObjetInterface;

public class GestObjetImpl extends UnicastRemoteObject implements GestObjetInterface {

	public GestObjetImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Remote getObjet(String adresse, int port, String nom) throws RemoteException {
		
		Remote r = null;
		try {
			r = Naming.lookup("rmi://"+adresse+":"+port+"/"+nom);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (r==null) {
			System.out.println("NULL");
		}
		return r;
	}

	@Override
	public void addObjet(Remote obj, String nom) throws RemoteException {
		try {

			Naming.rebind(nom, obj);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
