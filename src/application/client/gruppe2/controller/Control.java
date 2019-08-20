package application.client.gruppe2.controller;

import application.client.gruppe2.model.Game;
import application.client.gruppe2.view.BombermanPanel;
import network.client.ServerProxy;

public class Control {

    protected ServerProxy serverProxy;

    Game game;

    BombermanPanel view;

    public Control(ServerProxy serverProxy, Game game, BombermanPanel viwe) {
        this.game = game;
        this.serverProxy = serverProxy;
        view = viwe;
    }

}
