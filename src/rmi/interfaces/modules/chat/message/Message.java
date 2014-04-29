package rmi.interfaces.modules.chat.message;

import java.io.Serializable;

public class Message implements Serializable{
	String expediteur;
	String texte;
	
	public Message(String exp, String txt){
		this.expediteur =exp;
		this.texte = txt;
	}

	public String getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}
	

}
