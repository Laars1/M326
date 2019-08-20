package editor.gruppe1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class StartFrame extends JFrame implements ActionListener {
	static EingabeFrame eingabeFrame;
	GridLayout layout = new GridLayout(2, 1);
	JButton neu = new JButton("Neues Labyrinth erstellen");
	JButton laden = new JButton("Bestehendes Labyrinth laden");
	public StartFrame() {
		super("Labyrinth Editor");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

		
		setLayout(layout);
		add(neu);
		add(laden);

		neu.addActionListener(this);
		neu.setActionCommand("neu");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("neu")) {
			new EingabeFrame();
			neu.setEnabled(false);
			
		}

	}
}
