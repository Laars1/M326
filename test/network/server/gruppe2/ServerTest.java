package network.server.gruppe2;

import network.Message;
import network.server.ServerApplicationInterface;
import protocol.client2server.JoinGame;
import protocol.server2client.PlayerJoined;

public class ServerTest implements ServerApplicationInterface 
{
	private ServerNetwork serverNetwork;
	
	@Override
	public void handleMessage(Message message, String connectionId) {
		JoinGame clientMessage = (JoinGame) message;
		System.out.println("Server received Message from " + clientMessage.getPlayerName());
		serverNetwork.send(new PlayerJoined(clientMessage.getPlayerName(), 1, 1), connectionId);
		System.out.println("Server sent message to " + connectionId);
	}

	public ServerTest() {
		serverNetwork = new ServerNetwork(this);
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		serverNetwork.broadcast(new PlayerJoined("Broadcast", 0, 0));
	}

}
