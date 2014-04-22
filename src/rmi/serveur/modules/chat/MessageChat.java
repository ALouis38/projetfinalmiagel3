package rmi.serveur.modules.chat;

import java.io.Serializable;

import rmi.serveur.core.Message;

public class MessageChat extends Message{
	
	private String texte;
	private String emetteur;
	
	public MessageChat(String txt){
		texte = txt;
	}
	
	public MessageChat(String txt, String user){
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
