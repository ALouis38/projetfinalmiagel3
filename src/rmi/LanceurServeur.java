package rmi;

import java.net.UnknownHostException;

public class LanceurServeur {

	public static void main(String[] args) {
		try {
			Serveur serv = new Serveur(1099);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
