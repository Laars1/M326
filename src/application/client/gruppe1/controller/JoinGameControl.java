package application.client.gruppe1.controller;

import application.client.gruppe1.model.Game;
import application.client.gruppe1.view.BombermanPanel;
import network.client.ServerProxy;
import protocol.client2server.JoinGame;

public class JoinGameControl extends Control {

	public JoinGameControl(ServerProxy serverProxy, Game game, BombermanPanel view) {
		super(serverProxy, game, view);
	}
	
	public void joinGame(String playerName) {
		game.createMyPlayer(playerName);
		JoinGame message = new JoinGame(playerName);
		serverProxy.send(message);
		
	}
}
