package application.client.gruppe1.controller;
import application.client.gruppe1.model.Game;
import application.client.gruppe1.view.BombermanPanel;
import network.client.ServerProxy;
import protocol.server2client.Update;

public class UpdateControl extends Control {

	public UpdateControl(ServerProxy serverProxy, Game game, BombermanPanel view) {
		super(serverProxy, game, view);
	}
	
	public void update(Update message) {
		game.update(message);
		//view.displayMessage(message.getPlayerName() + " hat sich angemeldet");
	}

}
