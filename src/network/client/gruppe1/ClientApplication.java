package network.client.gruppe1;

import network.Message;
import network.client.ClientApplicationInterface;

public class ClientApplication implements ClientApplicationInterface{

	@Override
	public void handleMessage(Message message) {
		System.out.println(message.getClass());
	}
}
