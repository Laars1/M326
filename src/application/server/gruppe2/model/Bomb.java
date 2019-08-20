package application.server.gruppe2.model;
import network.Message;
import protocol.server2client.BombDropped;
import protocol.server2client.BombExploded;
import application.server.gruppe2.model.Bomb;

public class Bomb {
	private int x;
	private int y;
	private String name;
	
	
	public Bomb(String playerName, int positionX, int positionY) {
		 	name = playerName;
		    x = positionX;
		    y = positionY;
	}
	
	public Message bombDropped() {
		return new BombDropped(name, x, y );						
	}
	
	public Message bombExploded() {
		return new BombExploded(x, y);
	}
	
}
