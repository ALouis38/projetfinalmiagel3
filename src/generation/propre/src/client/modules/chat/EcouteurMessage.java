package generation.propre.src.client.modules.chat;

import rmi.commun.modules.chat.message.Message;

public interface EcouteurMessage {
	public void messageRecu(Message m);
}
