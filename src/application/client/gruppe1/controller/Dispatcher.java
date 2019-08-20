package application.client.gruppe1.controller;

import network.Message;
import network.client.ClientApplicationInterface;
import protocol.server2client.BombDropped;
import protocol.server2client.BombExploded;
import protocol.server2client.ErrorMessage;
import protocol.server2client.GameOver;
import protocol.server2client.PlayerHit;
import protocol.server2client.PlayerJoined;
import protocol.server2client.PlayerMoved;
import protocol.server2client.StartGame;
import protocol.server2client.Update;

public class Dispatcher implements ClientApplicationInterface {

	@Override
	public void handleMessage(Message message) {
		if(message instanceof PlayerJoined) {
			
		} else if(message instanceof ErrorMessage) {
			
		} else if(message instanceof StartGame) {
			
		} else if(message instanceof BombDropped) {
			
		} else if(message instanceof BombExploded) {
			
		} else if(message instanceof PlayerHit) {
			
		} else if(message instanceof PlayerJoined) {
			PlayerJoinedControl control = ControlFactory.instance().createPlayerJoinedControl();
			control.playerJoined((PlayerJoined)message);
		} else if(message instanceof PlayerMoved) {
			
		} else if(message instanceof Update) {
			UpdateControl control = ControlFactory.instance().createUpdateControl();
			control.update((Update)message);
			
		} else if(message instanceof GameOver) {
			
		}
	}

}
