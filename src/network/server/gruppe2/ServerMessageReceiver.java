package network.server.gruppe2;

import java.io.IOException;
import network.Message;
import network.server.ServerApplicationInterface;

public class ServerMessageReceiver extends Thread 
{
	private final ServerApplicationInterface serverInterface;
	private final Connection connection;
	
	public ServerMessageReceiver (Connection connection, ServerApplicationInterface serverInterface) {
		this.connection = connection;
		this.serverInterface = serverInterface;
	}
	
	public void run() 
	{
		try 
		{
			waitForAndForwardMessages ();
		} 
		catch (IOException | ClassNotFoundException exception)
		{
			exception.printStackTrace();
		}
	}
	
	public void waitForAndForwardMessages () throws ClassNotFoundException, IOException
	{
		while (true)
		{
			Message clientMessage = (Message) connection.getInputStream().readObject();
			serverInterface.handleMessage(clientMessage, connection.getConnectionId());
		}
	}
}
