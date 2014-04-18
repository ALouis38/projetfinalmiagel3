package rmi.serveur.modulesserveur.chat;

public interface GestMessageInterface {
	
	public void recupMessage(Utilisateur user, Message message);
	public void renvoiMessage(Message message);

}
