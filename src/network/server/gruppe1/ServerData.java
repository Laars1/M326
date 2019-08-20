package network.server.gruppe1;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import network.Message;
import network.server.Server;
import network.server.ServerApplicationInterface;
import protocol.server2client.ErrorMessage;

public class ServerData extends Server {

	//Connections
	private ArrayList<ClientHandler> connections = new ArrayList<ClientHandler>();
	private int maxConnections = 4;
	private int connectionCounter = 0;

	//Network
	private ServerSocket socket;
	private int port = 5056;


	public ServerData(ServerApplicationInterface serverApplication) {
		// Checks if there is already a serverapplication, otherwise, make a new ServerApplication
		super(serverApplication == null ? new ServerApplication() : serverApplication);

		try {
			socket = new ServerSocket(port);
			System.out.println("Server gestartet");
		} catch (Exception e) {
			System.err.println("Server konnte nicht gestartet werden");
		}

		while (true) {
			try {
				String connectionId = String.valueOf(connectionCounter);
				Socket connection = socket.accept();
				ClientHandler handler = new ClientHandler(connection, this,connectionId);
				
				// Check if Lobby is Full
				if (connections.size() < maxConnections) {
					connections.add(handler);
					new Thread(handler).start();
					connectionCounter++;
				} else {
					handler.send(new ErrorMessage("Die Lobby ist bereits voll!"));
				}
			} catch (Exception e) {
				System.err.println("Fehler beim Erstellen des Sockets");
			}
		}
	}

	// Check each Connection if id matches send message to host
	@Override
	public void send(Message message, String connectionId) {
		for (ClientHandler handler : connections) {
			if (handler.getConnectionId().equals(connectionId)) {
				handler.send(message);
				break;
			}
		}
	}

	@Override
	public void broadcast(Message message) {
		for (ClientHandler handler : connections) {
			handler.send(message);
		}
	}

	public ServerApplicationInterface getServerApplication() {
		return serverApplication;
	}

}
