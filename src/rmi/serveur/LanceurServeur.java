package rmi.serveur;

import java.net.UnknownHostException;

import rmi.serveur.coreserveur.Serveur;

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
