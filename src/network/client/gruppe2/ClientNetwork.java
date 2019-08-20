package network.client.gruppe2;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;


import network.Message;
import network.client.ClientApplicationInterface;
import network.client.ServerProxy;

public class ClientNetwork extends ServerProxy{

	private final int SERVER_PORT = 8001;
	private final String SERVER_HOST = "localhost";
	private Socket serverSocket;
	
	public ClientNetwork(ClientApplicationInterface clientInterface)
	{
		super(clientInterface);
		try
		{
			serverSocket = new Socket(SERVER_HOST, SERVER_PORT);
			ClientMessageReceiver clientMessageReceiver = new ClientMessageReceiver(serverSocket, clientInterface);
			clientMessageReceiver.start();
		} 
		catch (IOException exception)
		{
			exception.printStackTrace();
		}
	}

	@Override
	public void send(Message message) 
	{
		try 
		{
			ObjectOutputStream serverSocketOutputStream = new ObjectOutputStream(serverSocket.getOutputStream());
			serverSocketOutputStream.writeObject(message);
		} 
		catch (IOException exception) 
		{
			exception.printStackTrace();
		}
	}

}
