package application.server.gruppe1.control;

import application.server.gruppe1.model.Game;
import application.server.gruppe1.model.Player;
import network.Message;
import network.server.Server;
import protocol.Direction;
import protocol.client2server.ClientMessage;
import protocol.client2server.MovePlayer;
import protocol.server2client.ErrorMessage;
import protocol.server2client.PlayerMoved;

public class MovePlayerController extends Controller {

	/**
	 * Constructor.
	 * @param server Server instance
	 * @param game Game instance
	 */
	public MovePlayerController(Server server, Game game) {
		super(server, game);
	}


	/**
	 * This method handles an incoming MovePlayer-message and its connection id.
	 * 
	 * @param message the message from the client
	 * @param connectionId the id of the client
	 */
	@Override
	public void handleMessage(ClientMessage message, String connectionId) {
		
		// handle bomb drop on stopped game
		if( !game.isRunning() ) {
			Message response = new ErrorMessage("Spiel läuft noch nicht!");
			server.send(response, connectionId);
			return;
		}
		
		Direction direction = ((MovePlayer) message).getDirection();
		
		Player player = game.getPlayer(message.getPlayerName());
		
		// send error message if player is not registered
		if( player == null ) {
			Message response = new ErrorMessage("Spieler nicht registriert!");
			server.send(response, connectionId);
			return;
		}
		
		if( game.playerCanMove(player, direction) ) {
		
			player.move(direction);
			
			Message response = new PlayerMoved(connectionId, direction);
			server.broadcast(response);
			
		} // We don't need an else, we agreed with the client teams to just not send an answer if the move action isn't possible.
		
	}

}
