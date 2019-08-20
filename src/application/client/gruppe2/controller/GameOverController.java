package application.client.gruppe2.controller;

import application.client.gruppe2.model.Game;
import application.client.gruppe2.view.BombermanPanel;
import network.client.ServerProxy;

public class GameOverController extends  Control {
    public GameOverController(ServerProxy serverProxy, Game game, BombermanPanel viwe) {
        super(serverProxy, game, viwe);
    }
}
