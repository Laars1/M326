package application.server.gruppe2.model;

import network.Message;
import protocol.server2client.PlayerJoined;

public class Player {
	private String name;
	private int x,y;

	public Player(String playerName) {
		// TODO Auto-generated constructor stub
		name = playerName;
		//jeder spieler richtig selber machen x und y sind noch nicht richtig
		x = 0;
		y = 1;
	}

	public boolean isYourName(String playerName) {
		// TODO Auto-generated method stub
		return name.equals(playerName);
	}

	public Message createPlayerJoined() {
		// TODO Auto-generated method stub
		return new PlayerJoined(name,x,y);
	}

}
