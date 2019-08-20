package application.server.gruppe2.control;

import application.server.gruppe2.model.Game;
import network.server.Server;
import protocol.client2server.ClientMessage;

public abstract class Controller {

	Server server;
	Game game;

	public Controller(Server server,Game game) {
		// TODO Auto-generated constructor stub
		this.server = server;
		this.game = game;
	}

	public abstract void handleMessage(ClientMessage message, String connectionId);

}
