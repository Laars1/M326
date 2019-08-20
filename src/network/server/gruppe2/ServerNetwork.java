package network.server.gruppe2;

import java.io.IOException;
import java.net.ServerSocket;

import network.Message;
import network.server.Server;
import network.server.ServerApplicationInterface;

public class ServerNetwork extends Server implements ClientConnectorInterface 
{

	private final int SERVER_PORT = 8001;
	private Connection clientConnections[] = new Connection [4];
	private int clientCount = 0;
	
	public ServerNetwork(ServerApplicationInterface serverInterface) 
	{
		super(serverInterface);
		try 
		{
			ServerSocket serverSocket = new ServerSocket (SERVER_PORT);
			ClientConnector clientConnector = new ClientConnector(this, serverSocket, serverInterface);
			clientConnector.start();
		} 
		catch (IOException exception) 
		{
			exception.printStackTrace();
		}
	}

	@Override
	public void send(Message message, String connectionId) 
	{
		for (Connection connection : clientConnections) 
		{
			if (connection != null && connection.getConnectionId().equals(connectionId))
			{
				try 
				{	
					connection.getOutputStream().writeObject(message);
				}
				catch (IOException exception)
				{
					exception.printStackTrace();
				}
			}
		}
	}

	@Override
	public void broadcast(Message message) 
	{
		for (Connection connection : clientConnections) 
		{
			if (connection != null)
			{
				try 
				{
					connection.getOutputStream().writeObject(message);
				}catch (IOException exception)
				{
					exception.printStackTrace();
				}				
			}
		}
	}

	@Override
	public void onClientConnected(Connection connectedClient) 
	{
		clientConnections [clientCount] = connectedClient;
		clientCount++;
	}
}