package objetTest;

import java.rmi.RemoteException;

public class ObjetTestImpl implements ObjetTest {

	public String test() throws RemoteException {
		// Renvoie OK
		System.out.print("Execution de la méthode distante");
		return "OK";
	}

}
