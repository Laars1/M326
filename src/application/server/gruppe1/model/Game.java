package application.server.gruppe1.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Vector;

import protocol.Direction;

/**
 * This class is handling the game. It saves all references to the players etc.
 * 
 * @author Manuel Riesen, Levi Olsen, Sandro Rüfenacht
 */
public class Game {

	/**
	 * The maximum of players able to play a game together
	 */
	private static final int MAX_NUM_PLAYERS = 4;
	
	/**
	 * The free labyrinth tile
	 */
	private static final char LABYRINTH_TILE_FREE = '.';
	
	/**
	 * The breakable labyrinth tile
	 */
	private static final char LABYRINTH_TILE_BREAKABLE = 'o';
	
	/**
	 * The unbreakable labyrinth tile
	 */
	private static final char LABYRINTH_TILE_UNBREAKABLE = 'x';

	/**
	 * All connected players as <player name, player>-pair
	 */
	private HashMap<String, Player> players;

	/**
	 * The game map
	 */
	private char[][] labyrinth;

	/**
	 * The running-state of the game
	 */
	private boolean running;

	/**
	 * Constructor of Game class.
	 */
	public Game() {
		this.players = new HashMap<>();
		this.labyrinth = new char[][] {
				{ LABYRINTH_TILE_UNBREAKABLE, LABYRINTH_TILE_UNBREAKABLE, LABYRINTH_TILE_UNBREAKABLE,
						LABYRINTH_TILE_UNBREAKABLE },
				{ LABYRINTH_TILE_UNBREAKABLE, LABYRINTH_TILE_FREE, LABYRINTH_TILE_FREE, LABYRINTH_TILE_UNBREAKABLE },
				{ LABYRINTH_TILE_UNBREAKABLE, LABYRINTH_TILE_FREE, LABYRINTH_TILE_FREE, LABYRINTH_TILE_UNBREAKABLE },
				{ LABYRINTH_TILE_UNBREAKABLE, LABYRINTH_TILE_UNBREAKABLE, LABYRINTH_TILE_UNBREAKABLE,
						LABYRINTH_TILE_UNBREAKABLE } };
		this.running = false;
	}

	/**
	 * This method checks if there are as many players as possible.
	 * 
	 * @return <code>true</code> if the max-player amount has been reached.
	 */
	public boolean maxNumPlayersReached() {
		return players.size() == MAX_NUM_PLAYERS;
	}

	/**
	 * This method will check if a given player name is unique.
	 * 
	 * @param name holds the player name that should be checked.
	 * @return <code>true</code> if the name really is unique.
	 */
	public boolean playerIsUnique(String name) {
		return !players.containsKey(name);
	}

	/**
	 * This method will create a new player and save the reference to it.
	 * 
	 * @param name holds the name of the new player.
	 * @return Player which holds the name in it.
	 */
	public Player createPlayer(String name) {
		Player player = new Player(name, calculateStartPosition(players.size()));
		players.put(name, player);
		return player;
	}

	/**
	 * Calculates the start position of a player by the player count.
	 * @param playercount the position of the last player in the player list
	 * @return the start position of a player
	 */
	private Point calculateStartPosition(int playercount) {
		switch (playercount) {
		case 0:
			return new Point(1, 1);
		case 1:
			return new Point(this.labyrinth[1].length - 2, 1);
		case 2:
			return new Point(this.labyrinth[1].length - 2, this.labyrinth.length - 2);
		case 3:
			return new Point(1, this.labyrinth.length - 2);
		default:
			return new Point(1, 1);
		}
	}

	/**
	 * Getter for player
	 * @param name name of player
	 * @return the player with the given name
	 */
	public Player getPlayer(String name) {
		return players.get(name);
	}

	/**
	 * Setter for labyrinth
	 * @param layrinth the labyrinth to set
	 */
	public void setLabyrinth(char[][] layrinth) {
		this.labyrinth = layrinth;
	}

	/**
	 * Getter for labyrinth
	 * @return the labyrinth
	 */
	public char[][] getLabyrinth() {
		return labyrinth;
	}

	/**
	 * Checks if a player is able to move
	 * @param player player to check
	 * @param direction direction to check
	 * @return moving ability of the player
	 */
	public boolean playerCanMove(Player player, Direction direction) {

		Point newPos = player.getForeseenMovePos(direction);

		return labyrinth[newPos.x][newPos.y] == LABYRINTH_TILE_FREE;

	}

	/**
	 * Handles the bomb detonation on a given point
	 * @param dropPos the drop position of the bomb
	 * @return all players killed by the bomb
	 */
	public List<Player> handleBombDetonation(Point dropPos) {

		List<Player> playerKillList = new ArrayList<>();

		Point[] deltaPos = new Point[] { new Point(-1, 0), new Point(1, 0), new Point(0, -1), new Point(0, 1) };

		for (Point pos : deltaPos) {
			handleBombExplosionVector(dropPos, pos, playerKillList);
		}

		return playerKillList;

	}

	/**
	 * Handles a bomb explosion vector.
	 * The bomb explosion vector is restricted to one direction.
	 * @param dropPos the drop position of the bomb
	 * @param deltaPos the delta position of the bomb explosion, represents the explosion direction
	 * @param playerKillList the player kill list to append killed players to
	 */
	private void handleBombExplosionVector(Point dropPos, Point deltaPos, List<Player> playerKillList) {

		// set cursor position to first tile next to bomb
		Point cursorPos = new Point(dropPos.x + deltaPos.x, dropPos.y + deltaPos.y);
		
		// return if cursor is not in range of x-coordinates of the labyrinth
		if(cursorPos.x >= labyrinth.length || cursorPos.x < 0) {
			return;
		}
		
		// return if cursor is not in range of y-coordinates of the labyrinth
		if(cursorPos.y >= labyrinth[cursorPos.x].length || cursorPos.y < 0) {
			return;
		}
		
		// destroy block next to bomb
		labyrinth[cursorPos.x][cursorPos.y] = LABYRINTH_TILE_FREE;

		// move over the map while the map doesn't end
		while (cursorPos.x < labyrinth.length && cursorPos.y < labyrinth[0].length && cursorPos.x >= 0
				&& cursorPos.y >= 0) {

			// handle player update
			for (Player player : players.values()) {
				if (player.getPos().equals(cursorPos)) {

					// add player to kill list
					playerKillList.add(player);
					
					// remove player from game
					players.remove(player.getName());

				}
			}

			// handle labyrinth update
			switch (labyrinth[cursorPos.x][cursorPos.y]) {

			case LABYRINTH_TILE_UNBREAKABLE:
				// handle unbreakable block
				return;

			case LABYRINTH_TILE_BREAKABLE:
				// handle breakable block

				// remove breakable block
				labyrinth[cursorPos.x][cursorPos.y] = LABYRINTH_TILE_FREE;

				break;
			}

			// move to next tile
			cursorPos.x += deltaPos.x;
			cursorPos.y += deltaPos.y;

		}
		
		// set new running state while checking for players
		setRunning(players.values().size() <= 1);

	}

	/**
	 * Getter for game running state.
	 * @return the running state of the game
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * Setter for game running state.
	 * @param running the running state of the game
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

	/**
	 * Returns <code>true</code> if the game has ended.
	 * Negated running state.
	 * @return <code>true</code> if the game has ended
	 */
	public boolean hasEnded() {
		return !running;
	}

	/**
	 * Returns the winner of the game if there is a winner.
	 * Otherwise null is returned.
	 * @return the winner or null
	 */
	public Player getWinner() {
		if( !running ) {
			return players.values().toArray(new Player[0])[0];
		}
		return null;
	}
}
