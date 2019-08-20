package network.client.gruppe2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import network.Message;
import network.client.ClientApplicationInterface;

public class ClientMessageReceiver extends Thread {
	
	private final Socket serverSocket;
	private final ClientApplicationInterface clientInterface;
	
	public ClientMessageReceiver (Socket srvsocket, ClientApplicationInterface applicationInterface)
	{
		this.serverSocket = srvsocket;
		this.clientInterface = applicationInterface;
	}
	
	public void run() 
	{
		try 
		(
			ObjectInputStream serverInputStream = new ObjectInputStream(serverSocket.getInputStream());	
		)
		{
			while (true)
			{
				Message serverMessage = (Message) serverInputStream.readObject();
				clientInterface.handleMessage(serverMessage);
			}
		} 
		catch (IOException | ClassNotFoundException exception)
		{
			exception.printStackTrace();
		}
	}
}
