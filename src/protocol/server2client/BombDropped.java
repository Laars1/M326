package protocol.server2client;

import network.Message;

/**
 * Diese Meldung wird vom Server an die Clients gesendet, wenn eine neue Bombe abgelegt wurde.
 * Die Meldung enthält die ID der Bombe und den Ort der Bombe.
 * 
 * @author Andres Scheidegger
 *
 */
public class BombDropped implements Message {
  private String id;
  private int positionX;
  private int positionY;

  public BombDropped(String id, int positionX, int positionY) {
    this.id = id;
    this.positionX = positionX;
    this.positionY = positionY;
  }

  public int getPositionY() {
    return positionY;
  }

  public String getId() {
    return id;
  }

  public int getPositionX() {
    return positionX;
  }
}
