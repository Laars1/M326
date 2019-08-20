package network.server.gruppe2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public final class Connection {

	private final String connectionId;
	private final Socket socket;
	private final ObjectInputStream inputStream;
	private final ObjectOutputStream outputStream;
	
	public Connection (String connectionId, Socket socket)
	{
		this.connectionId = connectionId;
		this.socket = socket;
		ObjectInputStream temporaryInputStream;
		ObjectOutputStream temporaryOutputStream;
		try {
			temporaryInputStream = new ObjectInputStream(socket.getInputStream());
			temporaryOutputStream = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException exception) {
			temporaryInputStream = null;
			temporaryOutputStream = null;
			exception.printStackTrace();
		}
		inputStream = temporaryInputStream;
		outputStream = temporaryOutputStream;
	}
	
	public Connection (int connectionId, Socket socket)
	{
		this (String.valueOf(connectionId), socket);
	}
	
	public ObjectInputStream getInputStream() {
		return inputStream;
	}

	public ObjectOutputStream getOutputStream() {
		return outputStream;
	}

	public String getConnectionId() {
		return connectionId;
	}

	public Socket getSocket() {
		return socket;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		
		Connection connection = (Connection) o;
		
		return this.connectionId.equals(connection.connectionId) && socket.equals(connection.socket) && inputStream.equals(connection.inputStream) && outputStream.equals(connection.outputStream);
	}
	
	@Override
	public int hashCode()
	{
		return connectionId.hashCode() + socket.hashCode() + inputStream.hashCode() + outputStream.hashCode();
	}
}