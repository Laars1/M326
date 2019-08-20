package application.server.gruppe1.network;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds all messages which should be handled.
 * It has control over the queue and offers public functions for accessing said queue.
 * 
 * @author Manuel Riesen, Levi Olsen, Sandro Rüfenacht
 */
public class MessageQueue {
	
	/**
	 * Instance of the MessageQueue Singleton.
	 */
	private static MessageQueue instance;
	
	/**
	 * The message queue.
	 */
	private List<MessageWrapper> queue = new ArrayList<>();
	
	/**
	 * Private constructor for forcing the Singleton design pattern.
	 */
	private MessageQueue() { }
	
	/**
	 * The method for getting the instance of the MessageQueue Singleton.
	 * @return instance of the MessageQueue Singleton.
	 */
	public static MessageQueue getInstance() {
		if(instance == null) {
			synchronized (MessageQueue.class) {
				if(instance == null) {
					instance = new MessageQueue();
				}
			}
		}
		return instance;
	}
	
	/**
	 * This method will add a new MessageWrapper to the queue.
	 * It is synchronized for thread safety.
	 * 
	 * @param wrapper holds the new wrapper that should be added.
	 */
	public synchronized void append(MessageWrapper wrapper) {
		queue.add(wrapper);
		notify();
	}

	/**
	 * This function will remove the first element and return said element of the queue.
	 * The method is synchronized so it won't remove the same element twice because of the Threads.
	 * 
	 * @return MessageWrapper contains the information about the first message in the list.
	 */
	public synchronized MessageWrapper remove() {
		if (queue.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return queue.remove(0);
	}
}
