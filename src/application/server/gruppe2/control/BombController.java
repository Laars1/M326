package application.server.gruppe2.control;
import application.server.gruppe2.model.Bomb;
import protocol.BombStatus;

/*public class BombDropController {

}*/




import application.server.gruppe2.model.Game;
import application.server.gruppe2.model.Player;
import network.Message;
import network.server.Server;
import protocol.client2server.ClientMessage;
import protocol.client2server.DropBomb;
import protocol.server2client.ErrorMessage;

public class BombController extends Controller {
	
	public BombController(Server server, Game game) {
		super(server, game);
		// TODO Auto-generated constructor stub
	}

	

	@Override 
	public void handleMessage(ClientMessage message, String connectionId) {
		/*//hier wird die anwendungsfall logic implemntiert wird gemäss sequenzdiagramm
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
		}*/
		
		//in Bomb bomb wird ein der von client empfangene Objekt zugewiesen siehe packet client2server DropBomb
		//die Attributen werden au der messege objekt herausgelesen siehe client2server ClientMessage
		Bomb bomb =  game.dropBomb(message.getPlayerName(), ((DropBomb)message).getPositionX(), ((DropBomb)message).getPositionY());
		Message response = bomb.bombDropped(); //Das MessageObjekt ist  ein verebung bon serializyble und hilft bei der Transport und Umwandlung der nachricht
		server.broadcast(response);  //der Server broadcastet alle users das ein bomb am eine gewiese ort(x,y) Platziert worden ist
		response = bomb.bombExploded(); //Bombe Exploded ist ein Logische folgerung der Dropmethode,
										//Aber wie implementieren?	
		server.broadcast(response);		//?
		
	}

}
