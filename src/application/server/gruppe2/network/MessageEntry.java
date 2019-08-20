package application.server.gruppe2.network;

import network.Message;
import network.server.ServerApplicationInterface;
import protocol.client2server.ClientMessage;

public class MessageEntry implements ServerApplicationInterface {
	private MessageQueue messageQueue;
	
	public MessageEntry(MessageQueue queue) {
		// TODO Auto-generated constructor stub
		messageQueue = queue;
	}

	@Override
	public void handleMessage(Message message, String connectionId) {
		// TODO Auto-generated method stub
		MessageWrapper wrapper = new MessageWrapper((ClientMessage) message,connectionId);
		messageQueue.append(wrapper);
	}

}
