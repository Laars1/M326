package application.server.gruppe2.model;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private static final int NB_OF_PLAYERS = 4;
	private List<Player> players = new ArrayList<>();
	public boolean nbofPlayersComplete() {
		// TODO Auto-generated method stub
		return players.size() == NB_OF_PLAYERS;
	}
	public boolean istUnique(String playerName) {
		// TODO Auto-generated method stub
		for(Player player : players) {
			if(player.isYourName(playerName)) {
				return false;
			}
		}
		return true;
	}
	public Player createPlayer(String playerName) {
		// TODO Auto-generated method stub
		Player player = new Player(playerName);
		players.add(player);
		return player;
	}
	
	public Bomb dropBomb(String PlayerName, int x, int y) {
		Bomb bomb = new Bomb(PlayerName,x,y);
		return bomb;
	}
	
	
	
	

}
