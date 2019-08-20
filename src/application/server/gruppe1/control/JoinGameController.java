package application.server.gruppe1.control;

import java.awt.Point;

import application.server.gruppe1.model.Game;
import application.server.gruppe1.model.Player;
import network.Message;
import network.server.Server;
import protocol.client2server.ClientMessage;
import protocol.server2client.ErrorMessage;
import protocol.server2client.PlayerJoined;
import protocol.server2client.StartGame;

/**
 * This is the Controller which handles all joining clients.
 * 
 * @author Manuel Riesen, Levi Olsen, Sandro Rüfenacht
 */
public class JoinGameController extends Controller {
	
	/**
	 * Constructor.
	 * @param server Server instance
	 * @param game Game instance
	 */
	public JoinGameController(Server server, Game game) {
		super(server, game);
	}

	/**
	 * This method handles an incoming JoinGame-message and its connection id.
	 * 
	 * @param message the message from the client
	 * @param connectionId the id of the client
	 */
	@Override
	public void handleMessage(ClientMessage message, String connectionId) {
		
		if( game.isRunning() ) {
			Message response = new ErrorMessage("Spiel läuft bereits"); 
			server.send(response, connectionId);
			
		} else if( game.playerIsUnique(message.getPlayerName()) ) {
			
			Player player = game.createPlayer( message.getPlayerName() );
			Point playerPos = player.getPos();
			Message responseJoined = new PlayerJoined(player.getName(), playerPos.x, playerPos.y);
			server.broadcast(responseJoined);
			
			if( game.maxNumPlayersReached() ) {
				game.setRunning(true);
				Message responseStartGame = new StartGame(game.getLabyrinth());
				server.broadcast(responseStartGame);
			}
			
			
		} else {
			
			Message response = new ErrorMessage("Name wird bereits verwendet"); //TODO set to real value
			server.send(response, connectionId);
		}
		
	}
	
}
