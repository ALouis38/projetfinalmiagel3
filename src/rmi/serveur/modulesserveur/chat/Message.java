package rmi.serveur.modulesserveur.chat;

import java.io.Serializable;

public class Message implements Serializable{
	
	private String texte;
	private String emetteur;
	
	public Message(String txt, String user){
		texte = txt;
		emetteur = user;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public String getEmetteur() {
		return emetteur;
	}

	public void setEmetteur(String emetteur) {
		this.emetteur = emetteur;
	}

	
}
