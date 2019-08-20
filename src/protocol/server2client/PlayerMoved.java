package protocol.server2client;

import network.Message;
import protocol.Direction;

/**
 * Diese Meldung wird vom Server an die Clients gesendet, wenn ein Spieler sein Bomberman-Figur bewegt hat.
 * Die Meldung enthält den Namen des Spielers und die Richtung, in welche die Figur bewegt worden ist.
 * 
 * @author Andres Scheidegger
 *
 */
public class PlayerMoved implements Message {
  private String playerName;
  private Direction direction;

  public PlayerMoved(String playerName, Direction direction) {
    this.playerName = playerName;
    this.direction = direction;
  }

  public String getPlayerName() {
    return playerName;
  }

  public Direction getDirection() {
    return direction;
  }
}
