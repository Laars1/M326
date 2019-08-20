package network.server.gruppe1;

import network.Message;
import network.server.ServerApplicationInterface;

public class ServerApplication implements ServerApplicationInterface {

	@Override
	public void handleMessage(Message message, String connectionId) {
		System.out.println(message.getClass().toString());
	}

}
