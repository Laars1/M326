package application.client.gruppe2.controller;

import application.client.gruppe2.model.Game;
import application.client.gruppe2.view.BombermanPanel;
import network.client.ServerProxy;

public class ControlFactory  {


    private ServerProxy serverProxy;
    private static ControlFactory instance;
    private Game game;
    private BombermanPanel view;

    public static void initiate(ServerProxy serverProxy, Game game, BombermanPanel view) {
        if(instance == null) {
            instance = new ControlFactory(serverProxy, game, view);

        }
    }

    public ControlFactory(ServerProxy serverProxy, Game game, BombermanPanel view) {
        this.serverProxy = serverProxy;
        this.game = game;
        this.view = view;
    }

    public static ControlFactory instance() {
        return instance;
    }

    public JoinGameControl createJoinGameControl() {
        return new JoinGameControl(serverProxy, game, view);
    }

    public PlayerJoinedControl createPlayerJoinedControl() {
        return new PlayerJoinedControl(serverProxy, game, view);
    }
}
