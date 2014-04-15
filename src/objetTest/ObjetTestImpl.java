package objetTest;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjetTestImpl extends UnicastRemoteObject implements ObjetTest {

	public ObjetTestImpl() throws RemoteException {
		super();
	}

	public String test() throws RemoteException {
		// Renvoie OK
		System.out.print("Execution de la méthode distante");
		return "OK";
	}

}
