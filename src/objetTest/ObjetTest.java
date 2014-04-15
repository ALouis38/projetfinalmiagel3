package objetTest;

import java.rmi.*;

public interface ObjetTest extends Remote {
	//La méthode de test renverra le String "OK"
	public String test() throws RemoteException;
}
