package protocol.server2client;

import network.Message;

/**
 * Dies Meldung wird vom Server an die Clients gesendet, wenn das Spiel beendet ist.
 * Die Meldung enthält den Namen des Gewinners und einen Array mit den Punktzahlen aller
 * Spieler. Jedes Element des Arrays ist ein String mit dem Namen des Spielers und dessen Punktzahl.
 * 
 * @author Andres Scheidegger
 *
 */
public class GameOver implements Message {
  private String winnerName;
  private String[] highscoreList;

  public GameOver(String winnerName, String[] highscoreList) {
    this.winnerName = winnerName;
    this.highscoreList = highscoreList;
  }

  public String getWinnerName() {
    return winnerName;
  }

  public String[] getHighscoreList() {
    return highscoreList;
  }
}
