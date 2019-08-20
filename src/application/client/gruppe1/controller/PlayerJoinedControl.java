package application.client.gruppe1.controller;

import application.client.gruppe1.model.Game;
import application.client.gruppe1.view.BombermanPanel;
import network.client.ServerProxy;
import protocol.server2client.PlayerJoined;

public class PlayerJoinedControl extends Control {

	public PlayerJoinedControl(ServerProxy serverProxy, Game game, BombermanPanel view) {
		super(serverProxy, game, view);
	}

	public void playerJoined(PlayerJoined message) {
		game.playerJoined(message);
		view.displayMessage(message.getPlayerName() + " hat sich angemeldet");
	}

}
