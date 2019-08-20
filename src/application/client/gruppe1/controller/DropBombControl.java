package application.client.gruppe1.controller;

import application.client.gruppe1.model.Game;
import application.client.gruppe1.view.BombermanPanel;
import network.client.ServerProxy;
import protocol.client2server.DropBomb;

public class DropBombControl extends Control{
	
	public DropBombControl(ServerProxy serverProxy, Game game, BombermanPanel view) {
		super(serverProxy, game, view);
	}
	
	public void dropBomb(String playerName, int positionX, int positionY) {
		DropBomb message = new DropBomb(playerName, positionX, positionY);
		serverProxy.send(message);
		
	}
}
