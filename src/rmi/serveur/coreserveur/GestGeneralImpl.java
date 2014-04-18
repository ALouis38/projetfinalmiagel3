package rmi.serveur.coreserveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GestGeneralImpl extends UnicastRemoteObject {
	
	public Message msg;

	protected GestGeneralImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message dowloadGeneral(){
		return this.msg;
	}
	
	public void uploadGeneral(Message msg){
		this.msg = msg;
	}

	
	
}
