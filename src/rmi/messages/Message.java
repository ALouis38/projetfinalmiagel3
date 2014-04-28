package rmi.messages;

import java.io.Serializable;

public class Message implements Serializable{
	String expediteur;
	String texte;
	
	public Message(String exp, String txt){
		this.expediteur =exp;
		this.texte = txt;
	}
	

}
