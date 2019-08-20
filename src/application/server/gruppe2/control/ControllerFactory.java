package application.server.gruppe2.control;

import application.server.gruppe2.model.Game;
import network.server.Server;

public class ControllerFactory {

	private Server server;
	private Game game;
	
	public ControllerFactory(Server server,Game game) {
		this.server = server;
		this.game = game;
	}

	public Object createJoinGameController() {
		return new JoinGameController(server,game);
	}

}
