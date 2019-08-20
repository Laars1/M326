package application.server.gruppe1.control;

import application.server.gruppe1.model.Game;
import network.server.Server;
import protocol.client2server.ClientMessage;


/**
 * This abstract class is for all Controller that will handle the actions of the client.
 * 
 * @author Manuel Riesen, Levi Olsen, Sandro Rüfenacht
 */
public abstract class Controller {
	
	/**
	 * Instance of Server class from network package.
	 */
	protected Server server;
	
	/**
	 * Game instance.
	 */
	protected Game game;

	/**
	 * Constructor of Controller
	 * @param server server from network package
	 */
	public Controller(Server server, Game game) {
		this.server = server;
		this.game = game;
	}

	/**
	 * This method handles an incoming client message and its connection id.
	 * 
	 * @param message the message from the client
	 * @param connectionId the id of the client
	 */
	public abstract void handleMessage(ClientMessage message, String connectionId);

}
