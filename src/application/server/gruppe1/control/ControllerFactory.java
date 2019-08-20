package application.server.gruppe1.control;

import application.server.gruppe1.model.Game;
import network.server.Server;

/**
 * This Factory is here to control the constructing of Controllers
 * 
 * @author Manuel Riesen, Levi Olsen, Sandro Rüfenacht
 */
public class ControllerFactory {
	
	/**
	 * Server instance, used for constructing controllers.
	 */
	private Server server;
	
	/**
	 * Game instance, used for constructing controllers.
	 */
	private Game game;

	/**
	 * Constructor.
	 * 
	 * @param server holds the server instance for some of the Controllers
	 * @param game holds the active game to give it to some Controllers
	 */
	public ControllerFactory(Server server, Game game) {
		this.server = server;
		this.game = game;
	}

	/**
	 * This method creates a requested controller.
	 * @param controllerType type of controller to create
	 * @return new instance of the requested controller
	 */
	public Controller getController(String controllerType) {
		
		if(controllerType.equalsIgnoreCase("JOINGAME")) {
			return new JoinGameController(server, game);
		} else if(controllerType.equalsIgnoreCase("MOVEPLAYER")) {
			return new MovePlayerController(server, game);
		} else if(controllerType.equalsIgnoreCase("DROPBOMB")) {
			return new DropBombController(server, game);
		}
		return null;
	}

}
