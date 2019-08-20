package editor.gruppe1;

import javax.swing.JButton;

public class Labyrinth {
	private int breite;
	private int hoehe;
	private boolean valid;
	
	char [] [] array = new char[16][16];
	JButton [] [] knöpfe = new JButton[hoehe][breite];

	private void speichern() {
		
	}
	
	public int getBreite() {
		return breite;
	}



	public void setBreite(int breite) {
		this.breite = breite;
	}



	public int getHoehe() {
		return hoehe;
	}



	public void setHoehe(int hoehe) {
		this.hoehe = hoehe;
	}



	public boolean isValid() {
		return valid;
	}



	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
