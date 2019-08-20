package application.client.gruppe1.controller;

import javax.swing.JFrame;

import application.client.gruppe1.model.Game;
import application.client.gruppe1.view.BombermanFrame;
import application.client.gruppe1.view.BombermanPanel;
import network.Message;
import network.client.ClientApplicationInterface;
import network.client.KenansServerProxStub;
import network.client.ServerProxy;

public class BombermanClient extends JFrame{
	
	private static final long serialVersionUID = 3725488560712236158L;
		
	public static void main(String[] args) {
		Game game = new Game();
		Dispatcher dispatcher = new Dispatcher();
		ServerProxy serverProxy = new KenansServerProxStub(dispatcher);
		BombermanPanel panel = new BombermanPanel();
		new BombermanFrame(panel);
		ControlFactory.initiate(serverProxy, game, panel);
	}
}
