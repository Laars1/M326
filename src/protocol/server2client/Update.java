package protocol.server2client;

import network.Message;

/**
 * Diese Meldung wird vom Server an alle Clients gesendet, wenn sich das Labyrinth in Folge
 * einer explodierten Bombe verändert hat.
 * Die Nachricht enthält einen zweidimensionalen Array von chars mit dem neuen Labyrinth. Jedes Element
 * im Array entspricht einer Zelle des Labyrinthes. Dabei bedeutet
 * . leere Zelle
 * o zerstörbarer Block
 * x unzerstörbarer Block
 * 
 * @author Andres Scheidegger
 *
 */
public class Update implements Message {
  private char[][] labyrinth;

  public Update(char[][] labyrinth) {
    this.labyrinth = labyrinth;
  }

  public char[][] getLabyrinth() {
    return labyrinth;
  }
}
