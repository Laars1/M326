package protocol.server2client;

import network.Message;

/**
 * Diese Meldung wird vom Server an alle Clients gesendet, sobald genügend Spieler angemeldet
 * sind und das Spiel los geht.
 * Die Nachricht enthält einen zweidimensionalen Array von chars für das Labyrinth. Jedes Element
 * im Array entspricht einer Zelle des Labyrinthes. Dabei bedeutet
 * . leere Zelle
 * o zerstörbarer Block
 * x unzerstörbarer Block
 * 
 * @author Andres Scheidegger
 *
 */
public class StartGame implements Message {
  private char[][] labyrinth;

  public StartGame(char[][] labyrinth) {
    this.labyrinth = labyrinth;
  }

  public char[][] getLabyrinth() {
    return labyrinth;
  }
}
