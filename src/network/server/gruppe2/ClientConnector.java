package network.server.gruppe2;

import java.io.IOException;
import java.net.ServerSocket;

import network.server.ServerApplicationInterface;

public class ClientConnector extends Thread {
	
	private ClientConnectorInterface connectorInterface;
	private ServerApplicationInterface serverInterface;
	private ServerSocket serverSocket;
	private final int MAX_CLIENTS = 4;
	
	public ClientConnector (ClientConnectorInterface connectorInterface, ServerSocket serverSocket, ServerApplicationInterface serverInterface)
	{
		this.connectorInterface = connectorInterface;
		this.serverSocket = serverSocket;
		this.serverInterface = serverInterface;
	}
	
	@Override
	public void run ()
	{
		try 
		{
			waitForAndConnectClients();
		}
		catch (IOException exception)
		{
			exception.printStackTrace();
		}
		
	}
	
	public void waitForAndConnectClients () throws IOException
	{
		for (int client = 0; client < MAX_CLIENTS; client++)
		{
			Connection connection = new Connection(client + 1, serverSocket.accept());
			connectorInterface.onClientConnected(connection);
			ServerMessageReceiver serverMessageReceiver = new ServerMessageReceiver (connection, serverInterface);
			serverMessageReceiver.start();
		}
		serverSocket.close();
	}
}