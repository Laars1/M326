package application.server.gruppe1.network;

import network.Message;
import network.server.ServerApplicationInterface;
import protocol.client2server.ClientMessage;

// TODO thread safety
/**
 * This class handles the receiving of all messages.
 * It works closely with the MessageQueue together.
 * 
 * @author Manuel Riesen, Levi Olsen, Sandro Rüfenacht
 */
public class MessageReceiver implements ServerApplicationInterface {

	/**
	 * The message queue instance.
	 */
	private MessageQueue messageQueue;

	/**
	 * Constructor.
	 * 
	 * @param messageQueue holds all messages that will be handled.
	 */
	public MessageReceiver(MessageQueue messageQueue) {
		this.messageQueue = messageQueue;
	}
	
	/**
	 * This function is here to handle a new message.
	 * The message will be added to the queue.
	 * 
	 * @param message holds the Message.
	 * @param connectionId holds the ID of the sender. It will be sent with each message.
	 */
	@Override
	public synchronized void handleMessage(Message message, String connectionId) {
		MessageWrapper wrapper = new MessageWrapper( (ClientMessage) message, connectionId);
		messageQueue.append(wrapper);
	}

}
