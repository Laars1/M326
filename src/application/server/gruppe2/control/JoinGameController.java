package application.server.gruppe2.control;

import application.server.gruppe2.model.Game;
import application.server.gruppe2.model.Player;
import network.Message;
import network.server.Server;
import protocol.client2server.ClientMessage;
import protocol.server2client.ErrorMessage;

public class JoinGameController extends Controller {
	
	public JoinGameController(Server server, Game game) {
		// TODO Auto-generated constructor stub
		super(server,game);
	}

	@Override 
	public void handleMessage(ClientMessage message, String connectionId) {
		//hier wird die anwendungsfall logic implemntiert wird gemäss sequenzdiagramm
		if(game.nbofPlayersComplete()) {
			Message response = new ErrorMessage("Spiel läuft bereits");
			server.send(message, connectionId);
		}else if(!game.istUnique(message.getPlayerName())) {
			Message response = new ErrorMessage("Spieleraname ist bereits vergeben");
			server.send(message, connectionId);
		}else{
			Player player = game.createPlayer(message.getPlayerName());
			Message response = player.createPlayerJoined();
			server.broadcast(response);
			//todo 
		}
	}

}
