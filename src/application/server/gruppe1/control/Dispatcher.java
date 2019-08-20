package application.server.gruppe1.control;

import application.server.gruppe1.network.MessageQueue;
import application.server.gruppe1.network.MessageWrapper;
import protocol.client2server.ClientMessage;
import protocol.client2server.DropBomb;
import protocol.client2server.JoinGame;
import protocol.client2server.MovePlayer;

/**
 * This class is the dispatcher. 
 * It will decide which Controller it needs. 
 * Therefore it will check what the message type is.
 * 
 * @author Manuel Riesen, Levi Olsen, Sandro Rüfenacht
 */
public class Dispatcher extends Thread {
	
	/**
	 * The message queue containing all incoming unhandled messages
	 */
	private MessageQueue messageQueue;
	
	/**
	 * The running state of the dispatcher
	 */
	private volatile boolean running = true;
	
	/**
	 *	The controller factory
	 */
	private ControllerFactory controllerFactory;
	
	/**
	 * Constructor.
	 * 
	 * @param messageQueue this holds the incoming messages
	 * @param controllerFactory holds an object of the factory for creating controllers
	 */
	public Dispatcher(MessageQueue messageQueue, ControllerFactory controllerFactory) {
		this.messageQueue = messageQueue;
		this.controllerFactory = controllerFactory;
	}
	
	/**
	 * As long as dispatching is enabled, this function will iterate and handle the messages in the queue.
	 */
	@Override
	public void run() {
		while (running) {
			
			// get the client message from the queue and remove it
			MessageWrapper messageWrapper = messageQueue.remove();
			ClientMessage message = messageWrapper.getMessage();
			String connectionId = messageWrapper.getConnectionId();
			Controller controller = null;
			
			if (message instanceof JoinGame) {
				controller = controllerFactory.getController("JoinGame");	
				
			} else if (message instanceof MovePlayer) {
				controller = controllerFactory.getController("MovePlayer");
				
			} else if(message instanceof DropBomb) {
				controller = controllerFactory.getController("DropBomb");
			}
			
			if(controller != null) {
				controller.handleMessage(message, connectionId);
			}
		}
	}
	
	/**
	 * This function will turn off the dispatching.
	 */
	public void stopDispatcher() {
		running = false;
	}
}
