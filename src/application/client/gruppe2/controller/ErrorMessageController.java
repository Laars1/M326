package application.client.gruppe2.controller;

import application.client.gruppe2.model.Game;
import application.client.gruppe2.view.BombermanPanel;
import network.client.ServerProxy;

public class ErrorMessageController extends  Control {
    public ErrorMessageController(ServerProxy serverProxy, Game game, BombermanPanel viwe) {
        super(serverProxy, game, viwe);
    }
}
