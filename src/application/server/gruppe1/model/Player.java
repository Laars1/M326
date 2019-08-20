package application.server.gruppe1.model;

import java.awt.Point;

import network.Message;
import protocol.Direction;
import protocol.server2client.PlayerJoined;

/**
 * This class is a model-class. It is used to handle the Players.
 * 
 * @author Manuel Riesen, Levi Olsen, Sandro Rüfenacht
 */
public class Player {
	
	private String name;
	private Point pos;
	
	/**
	 * Constructor
	 * @param name
	 * @param pos
	 */
	public Player(String name, Point pos) {
		this.name = name;
		this.pos = pos;
	}

	/**
	 * Moves the player in a given direction.
	 * Uses the foreseen move position.
	 * @param direction direction to move in
	 */
	public void move(Direction direction) {
		pos = getForeseenMovePos(direction);
	}
	
	
	/**
	 * Returns the position after a move in a direction.
	 * This method does not affect the actual position of the player.
	 * @param direction direction to get position
	 * @return position after move in a direction
	 */
	public Point getForeseenMovePos(Direction direction) {
		Point movedPos = new Point(pos.x, pos.y);

		switch (direction) {
		case LEFT:
			movedPos.x--;
			break;
		case RIGHT:
			movedPos.x++;
			break;
		case UP:
			movedPos.y--;
			break;
		case DOWN:
			movedPos.y++;
			break;
		}
		
		return movedPos;
	}
	
	/**
	 * This method has been written so you can check if the name is equal to a certain name
	 * @param name
	 * @return bool
	 */
	public boolean hasName(String name) {
		return this.name.equals(name);
	}

	
	/**
	 * Getter for the player name
	 * @return name of player
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * This method is used to get the position of the player as a Point-instance.
	 * @return Point
	 */
	public Point getPos() {
		return pos;
	}
}
