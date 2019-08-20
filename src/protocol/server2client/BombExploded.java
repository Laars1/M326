 package protocol.server2client;

import network.Message;

/**
 * Diese Meldung wird vom Server an die Clients gesendet, wenn eine Bombe explodiert.
 * Die Meldung enthält die ID der explodierenden Bombe.
 * 
 * @author Andres Scheidegger
 *
 */
public class BombExploded implements Message {

  private int positionX;
  private int positionY;

  public BombExploded(int positionX, int positionY) {
    this.positionX = positionX;
    this.positionY = positionY;
  }
  
  public int getPositionX() {
	return positionX;
  }

  public int getPositionY() {
	return positionY;
  }
}

