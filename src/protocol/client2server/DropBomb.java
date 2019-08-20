package protocol.client2server;

/**
 * Diese Meldung wird vom Client an den Server gesendet, wenn der Spieler eine neue Bombe ablegt.
 * Die Meldung enthält den Ort der Bombe.
 * 
 * @author Andres Scheidegger
 *
 */
public class DropBomb extends ClientMessage {
  private int positionX;
  private int positionY;

  public DropBomb(String playerName, int positionX, int positionY) {
    super(playerName);
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
