package application.client.gruppe2.controller;

import application.client.gruppe2.model.Game;
import application.client.gruppe2.view.BombermanFrame;
import application.client.gruppe2.view.BombermanPanel;
import network.client.KenansServerProxStub;
import network.client.ServerProxy;

public class BombermanClient {

    public static void main(String[] args)
    {
        new BombermanClient();
    }

    private BombermanClient()
    {
        Dispatcher dispatcher = new Dispatcher();
        Game game = new Game();
        ServerProxy serverProxy = new KenansServerProxStub(dispatcher);
        BombermanPanel panel = new BombermanPanel();
        ControlFactory.initiate(serverProxy, game, panel);

        new BombermanFrame(panel);
    }

}
