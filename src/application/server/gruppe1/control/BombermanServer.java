package application.server.gruppe1.control;

import application.server.gruppe1.model.Game;
import application.server.gruppe1.network.MessageQueue;
import application.server.gruppe1.network.MessageReceiver;
import network.server.Server;
import network.server.gruppe1.TestServerStub;

/**
 * This is the main-class of the server.
 * It handles every incoming message from the message-stack and handles the whole game.
 * 
 * @author Manuel Riesen, Levi Olsen, Sandro R�fenacht
 */
public class BombermanServer {
	
	/**
	 * The message queue instance
	 */
	private MessageQueue messageQueue;
	
	/**
	 * the message receiver receiving client messages
	 */
	private MessageReceiver messageReceiver;
	
	/**
	 * The server instance
	 */
	private Server server;
	
	/**
	 * The game instance
	 */
	private Game game;
	
	/**
	 * The controller factory to create message controllers
	 */
	private ControllerFactory controllerFactory;
	
	/**
	 * The dispatcher handling dispatching of client messages
	 */
	private Dispatcher dispatcher;
	
	public static void main(String[] args) {
		new BombermanServer();
	}
	
	/**
	 * This is the constructor which handles the connections between the message-stack and the classes of the server.
	 */
	private BombermanServer() {
		
		messageQueue = MessageQueue.getInstance();
		messageReceiver = new MessageReceiver(messageQueue);
		
		server = new TestServerStub(messageReceiver);
		game = new Game();
		controllerFactory = new ControllerFactory(server, game);
		dispatcher = new Dispatcher(messageQueue, controllerFactory);
		dispatcher.start();
		
	}
}
