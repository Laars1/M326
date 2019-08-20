package protocol.server2client;

import network.Message;

/**
 * Deise Meldung wird vom Server an die Clients gesendet, wenn die Bomberman-Figur eines Spielers
 * von einer Bombe getroffen wurde.
 * Die Meldung enthält den Namen des getroffenen Spielers.
 * 
 * @author Andres Scheidegger
 *
 */
public class PlayerHit implements Message {
  private String playerName;

  public PlayerHit(String playerName) {
    this.playerName = playerName;
  }

  public String getPlayerName() {
    return playerName;
  }
}
