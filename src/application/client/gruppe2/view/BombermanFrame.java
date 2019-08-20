package application.client.gruppe2.view;

import javax.swing.*;

public class BombermanFrame extends JFrame{

	private static final long serialVersionUID = 2475391450401588528L;
	
	public BombermanFrame(JPanel panel) {
		setTitle("Bomberman");
		setSize(1000,1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(panel);
		setVisible(true);
	}
}
