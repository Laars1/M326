package application.server.gruppe2.network;

import protocol.client2server.ClientMessage;

public class MessageWrapper {
	
	private ClientMessage message;
	private String connectionId;
	
	public MessageWrapper(ClientMessage message2, String connectionId) {
		
		this.connectionId = connectionId;
		this.message = message2;
	}

	public ClientMessage getMassage() {
		// TODO Auto-generated method stub
		return message;
	}

	public String getconnectionId() {
		// TODO Auto-generated method stub
		return connectionId;
	}
	

}
