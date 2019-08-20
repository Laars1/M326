package protocol.client2server;

import protocol.Direction;

/**
 * Diese Meldung wird vom Client zum Server gesendet, wenn der Spieler seine Bomberman-Figur um
 * ein Feld verschiebt.
 * Die Meldung enthält die Richtung, in welcher die Figur verschoben wurde.
 * 
 * @author Andres Scheidegger
 *
 */
public class MovePlayer extends ClientMessage {
  private Direction direction;

  public MovePlayer(String playerName, Direction direction) {
    super(playerName);
    this.direction = direction;
  }

  public Direction getDirection() {
    return direction;
  }
}
