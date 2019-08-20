package network.client.gruppe1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import network.Message;
import network.client.ServerProxy;

public class ClientData extends ServerProxy implements Runnable {

	// IP adresse funktion?
	private String ipAdr = "localhost";
	private int port = 5056;
	private Socket connection;

	// Streams
	private ObjectInputStream ojs;
	private ObjectOutputStream oos;

	public ClientData() {
		super(new ClientApplication());
		try {
			connection = new Socket(ipAdr, port);
			System.out.println("Client wurde gestartet");

			ojs = new ObjectInputStream(connection.getInputStream());
			oos = new ObjectOutputStream(connection.getOutputStream());

			new Thread(this).start();
		} catch (IOException e) {
			System.err.println("Verbindung zu Server nicht möglich");
		}
	}

	@Override
	public void run() {
		Message message;
		try {
			while (true) {
				message = (Message) ojs.readObject();
				if (message != null) {
					clientApplication.handleMessage(message);
				}
			}
		} catch (Exception e) {
			System.err.println("Fehler beim Empfangen der Daten");
		}
	}

	@Override
	public void send(Message message) {
		try {
			oos.writeObject(message);
			oos.flush();
		} catch (Exception e) {
			System.err.println("Objekt konnte nicht durchgestellt werden!");
		}
	}

}
