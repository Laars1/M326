package network.client.gruppe2;

import network.Message;
import network.client.ClientApplicationInterface;
import protocol.client2server.JoinGame;
import protocol.server2client.PlayerJoined;

public class ClientTest implements ClientApplicationInterface 
{
	private ClientNetwork clientNetwork;
	
	@Override
	public void handleMessage(Message message) 
	{
		PlayerJoined serverMessage = (PlayerJoined) message;
		System.out.println("Client received message. Player: " + serverMessage.getPlayerName());
	}

	public ClientTest ()
	{
		clientNetwork = new ClientNetwork(this);
		clientNetwork.send(new JoinGame("TestMessage"));
	}

}
