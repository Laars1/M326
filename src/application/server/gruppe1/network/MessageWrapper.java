package application.server.gruppe1.network;

import protocol.client2server.ClientMessage;

/**
 * This class will surround a message.
 * This way we can give the message certain methods to make the application cleaner.
 * 
 * @author Manuel Riesen, Levi Olsen, Sandro Rüfenacht
 */
public class MessageWrapper {
	
	/**
	 * The client message.
	 */
	private ClientMessage message;
	
	/**
	 * The connection id of the client.
	 */
	private String connectionId;
	
	/**
	 * Constructor.
	 * It will save the data in the private fields.
	 * 
	 * @param message holds the ClientMessage sent by a client
	 * @param connectionId holds the ID of the client who sent the message
	 */
	public MessageWrapper(ClientMessage message, String connectionId) {
		this.message = message;
		this.connectionId = connectionId;
	}
	
	/**
	 * This function is able to return the Message of the chosen wrapper.
	 * 
	 * @return ClientMessage is a String that holds the message of the client.
	 */
	public ClientMessage getMessage() {
		return message;
	}

	/**
	 * This method will return the connection ID of the client who sent this message.
	 * 
	 * @return connectionId holds the ID of the client
	 */
	public String getConnectionId() {
		return connectionId;
	}
	
}
