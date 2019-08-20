package application.client.gruppe2.view;

import application.client.gruppe2.controller.ControlFactory;
import application.client.gruppe2.controller.JoinGameControl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BombermanPanel extends JPanel {

	private static final long serialVersionUID = 123701334789462850L;

	private JTextField playerNameTextField = new JTextField();
	private JButton loginButton = new JButton("Anmelden");

	
	private JTextArea messageTextArea = new JTextArea();
	
	public BombermanPanel() {
		setLayout(new BorderLayout());

		playerNameTextField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JoinGameControl control = ControlFactory.instance().createJoinGameControl();
				control.joinGame(playerNameTextField.getText());
				playerNameTextField.setEnabled(false);
			}
		});
		add(playerNameTextField, BorderLayout.NORTH);
		messageTextArea.setRows(15);
		messageTextArea.setEditable(false);
		messageTextArea.setText("Devil slayed the game");
		add(messageTextArea, BorderLayout.SOUTH);
	}

    public void displayMessage(String s) {
	    messageTextArea.append(s + "\n");
    }
}
