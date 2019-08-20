package application.server.gruppe2.control;

import application.server.gruppe2.network.MessageQueue;
import application.server.gruppe2.network.MessageWrapper;
import protocol.client2server.ClientMessage;
import protocol.client2server.JoinGame;
import protocol.client2server.MovePlayer;

public class Dispatcher extends Thread {

	private volatile boolean running = true;
	private MessageQueue messageQueue;
	private ControllerFactory controllerFactory;
	
	
	public Dispatcher(MessageQueue queue,ControllerFactory controllerFactory) {
		messageQueue = queue;
		this.controllerFactory = controllerFactory;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(running ) {
			MessageWrapper wrapper = messageQueue.remove();
			ClientMessage message = wrapper.getMassage();
			String connectionId = wrapper.getconnectionId();
			Controller controller;
			if(message instanceof JoinGame) {
				//warum muss ich controlle castren?
					controller = (Controller) controllerFactory.createJoinGameController();	
					controller.handleMessage(message, connectionId);
			}else if(message instanceof MovePlayer) {
				
			}
		}
	}
	
	public void stopDispatcher() {
		running = false;
	}

}
