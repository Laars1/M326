package application.client.gruppe2.model;

import protocol.server2client.PlayerJoined;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player myPlayer;
    private List<Player> oponents = new ArrayList<Player>();

    public void createMyPlayer(String player)
    {
        myPlayer = new Player(player);
    }

    public void playerJoined(PlayerJoined message)
    {
        String playername = message.getPlayerName();
        int initialX = message.getInitialPositionX();
        int initialY = message.getInitialPositionY();
        if (myPlayer.isYourName(playername))
        {

            myPlayer.setPosition(initialX, initialY);
        }
        else
        {
            oponents.add(new Player(message.getPlayerName(), initialX, initialY));
        }
    }

}
