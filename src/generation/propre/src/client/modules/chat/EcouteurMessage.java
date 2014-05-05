package client.modules.chat;

import commun.modules.chat.message.Message;

public interface EcouteurMessage {
	public void messageRecu(Message m);
}
