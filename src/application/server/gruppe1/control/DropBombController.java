package application.server.gruppe1.control;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import application.server.gruppe1.model.Game;
import application.server.gruppe1.model.Player;
import network.Message;
import network.server.Server;
import protocol.client2server.ClientMessage;
import protocol.client2server.DropBomb;
import protocol.server2client.BombDropped;
import protocol.server2client.BombExploded;
import protocol.server2client.ErrorMessage;
import protocol.server2client.GameOver;
import protocol.server2client.PlayerHit;
import protocol.server2client.Update;

public class DropBombController extends Controller {

	/**
	 * The waiting time for a bomb to detonate.
	 */
	private static int DELTA_TIME_DETONATION = 6000;
	
	/**
	 * Constructor.
	 * @param server Server instance
	 * @param game Game instance
	 */
	public DropBombController(Server server, Game game) {
		super(server, game);
	}
	
	
	/**
	 * This method handles an incoming DropBomb-message and its connection id.
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
		
		// get message data
		Player player = game.getPlayer(message.getPlayerName());
		
		// send error message if player is not registered
		if( player == null ) {
			Message response = new ErrorMessage("Spieler nicht registriert!");
			server.send(response, connectionId);
			return;
		}
		
		Point dropPos = new Point( ((DropBomb) message).getPositionX() , ((DropBomb) message).getPositionY());

		// send bomb dropped message
		Message preResponse = new BombDropped(connectionId, dropPos.x, dropPos.y);
		server.broadcast(preResponse);
			
		// create new thread with lambda expression
		Thread detonationHandler = new Thread(() -> {
			
			System.out.println("started bomb ticking at " + Thread.currentThread());
			
			// wait for detonation
			try {
				Thread.sleep(DELTA_TIME_DETONATION);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			List<Message> postResponses = new ArrayList<>();
			
			List<Player> playerKillList = game.handleBombDetonation(dropPos);
			
			// send player hit messages
			for(Player playerToKill : playerKillList) {
				postResponses.add( new PlayerHit(playerToKill.getName()) );
			}
			
			if( game.hasEnded() ) {
				Player winner = game.getWinner();
				String[] highscoreList = new String[] {}; // TODO get highscore list
				postResponses.add( new GameOver(winner.getName(), highscoreList) );
			}

			// add bomb exploded message to response message list
			postResponses.add( new BombExploded(dropPos.x, dropPos.y) );
			
			// add update message to response message list
			postResponses.add( new Update(game.getLabyrinth()) );
			
			// send all responses after bomb detonation
			for(Message postResponse : postResponses) {
				server.broadcast(postResponse);
			}
			
			
		});
		
		// start detonation handler thread
		detonationHandler.start();
		

	}

}
