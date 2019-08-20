package application.client.gruppe1.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

public class LoginPressedListener extends MouseAdapter {
	
	JTextField playerNameTextField;
	JButton loginButton;
	
	public LoginPressedListener(JTextField textField, JButton button) {
		this.playerNameTextField = textField;
		this.loginButton = button;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		JoinGameControl control = ControlFactory.instance().createJoinGameControl();
		control.joinGame(playerNameTextField.getText());
		playerNameTextField.setEnabled(false);
		loginButton.setEnabled(false);
	}
}
