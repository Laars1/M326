package editor.gruppe1;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LabyrinthEditor extends JFrame {
	
	Labyrinth labyrinth = new Labyrinth();
	private final int hoehe;
	private final int breite;
	public LabyrinthEditor(int hoehe, int breite) {
		super("Labyrinth Editor");
		this.hoehe = hoehe;
		this.breite = breite;
		setSize(hoehe * 50, breite * 50);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setResizable(false);
		setVisible(true);
		labyrinth.setHoehe(hoehe/50);
		labyrinth.setBreite(breite/50);
	}
	private boolean validation() {
		return true;
	}
}
