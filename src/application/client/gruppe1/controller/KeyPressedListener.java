package application.client.gruppe1.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import protocol.Direction;
import protocol.client2server.DropBomb;
import protocol.client2server.MovePlayer;

public class KeyPressedListener extends KeyAdapter {
	
	private JTextField jTextField;
	public KeyPressedListener(JTextField jTextField) {
		this.jTextField = jTextField;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		MovePlayerControl moveControl = ControlFactory.instance().createMovePlayerControl();
		DropBombControl bombControl = ControlFactory.instance().createDropBombControl();
		int keyCode = e.getKeyCode();
		switch(keyCode) {
			case KeyEvent.VK_W:
				moveControl.movePlayer(jTextField.getText(), Direction.UP); break;
			case KeyEvent.VK_A:
				moveControl.movePlayer(jTextField.getText(), Direction.LEFT); break;
			case KeyEvent.VK_S:
				moveControl.movePlayer(jTextField.getText(), Direction.DOWN); break;
			case KeyEvent.VK_D:
				moveControl.movePlayer(jTextField.getText(), Direction.RIGHT); break;
			case KeyEvent.VK_SPACE:
				//bombControl.dropBomb(playerName, positionX, positionY); break;
		}
	}
	
}
