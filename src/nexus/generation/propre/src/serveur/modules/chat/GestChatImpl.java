package serveur.modules.chat;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import commun.modules.Notification.GestNotificationInterface;
import commun.modules.Utilisateur.Utilisateur;
import commun.modules.chat.GestChatInterface;
import commun.modules.chat.message.Message;
import commun.modules.chat.message.MessageChat;

public class GestChatImpl extends UnicastRemoteObject implements
GestChatInterface {

ArrayList<Message> messages;

public GestChatImpl() throws RemoteException {
super();
ArrayList<MessageChat> messages = new ArrayList<MessageChat>();
}


@Override
public ArrayList<Message> recevoirMessage(int indice) {
ArrayList<Message> messagesR = new ArrayList<Message>();
while(indice < this.messages.size()){
	messagesR.add(this.messages.get(indice));
	indice++;
}
return messagesR;
}


public void envoyerNotif(HashMap<String,Utilisateur> users, Message m, String type){	

Set listKeys=users.keySet();  // Obtenir la liste des clés
Iterator iterateur=listKeys.iterator();
// Parcourir les clés et afficher les entrées de chaque clé;
while(iterateur.hasNext())
{
	Object key= iterateur.next();
	Utilisateur user = users.get(key);
	String ip = user.getIp();
	int portReg = user.getPortRegistry();
	System.out.println("IP:" + ip + ", PORT REGISTRY:" + portReg);
	try {
		GestNotificationInterface gN = (GestNotificationInterface) Naming.lookup("rmi://"+  ip  +":"+ portReg + "/gestNotif");
		gN.recupNotif(m, type);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NotBoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}


}

