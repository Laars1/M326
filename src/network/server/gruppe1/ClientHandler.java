package network.server.gruppe1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import network.Message;

public class ClientHandler implements Runnable {

	// Streams
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	// Network
	private Socket connection;
	private ServerData server;

	private String connectionId;

	public ClientHandler(Socket connection, ServerData server, String connectionId) {
		this.connection = connection;
		this.server = server;
		this.connectionId = connectionId;
	}

	@Override
	public void run() {
		try {
			Message message;

			ois = new ObjectInputStream(connection.getInputStream());
			oos = new ObjectOutputStream(connection.getOutputStream());

			//Rceive Message and send it to Client
			while (true) {
				message = (Message) ois.readObject();
				if (message != null) {
					server.getServerApplication().handleMessage(message, connectionId);
				}
			}
		} catch (Exception e) {
			System.err.println("Empfangen der Daten wurde unerwartet abgebrochen");
		}

	}

	public void send(Message message) {
		try {
			oos.writeObject(message);
			oos.flush();
		} catch (Exception e) {
			System.err.println("Nachricht konnte nicht gesendet werden!");
		}
	}

	public String getConnectionId() {
		return connectionId;
	}

}
