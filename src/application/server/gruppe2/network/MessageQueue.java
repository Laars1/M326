package application.server.gruppe2.network;

import java.util.*;

public class MessageQueue {
	private List<MessageWrapper> queue = new ArrayList <MessageWrapper>();
	
	public synchronized void append(MessageWrapper wrapper) {
		queue.add(wrapper);
		notify();
	}
	public MessageWrapper remove() {
		if(queue.isEmpty())
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		return queue.remove(0);
		
	}

}
