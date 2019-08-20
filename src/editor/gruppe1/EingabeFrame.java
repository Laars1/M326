package editor.gruppe1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EingabeFrame extends JFrame implements ActionListener{	
	JTextField textfeldHoehe = new JTextField();
	JTextField textfeldBreite = new JTextField();
	JLabel textHoehe = new JLabel("Höhe in Kacheln:");
	JLabel textBreite = new JLabel("Breite in Kacheln:");
	JButton ok = new JButton("OK");
	JLabel textError = new JLabel("");





	public EingabeFrame() {
		super("Grösse des Labyrintes");
		setSize(300, 200);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setResizable(false);
		setVisible(true);
		setBackground(Color.GRAY);
		setLayout(null);
		
		

		textfeldHoehe.setSize(100, 20);
		textfeldHoehe.setLocation(120, 10);
		textfeldBreite.setLocation(120, 30);
		textfeldBreite.setSize(100, 20);
		textHoehe.setLocation(10, 10);
		textBreite.setLocation(10, 30);
		textHoehe.setSize(100, 20);
		textBreite.setSize(100, 20);
		ok.setLocation(100, 100);
		ok.setSize(100, 50);
		ok.addActionListener(this);
		ok.setActionCommand("ok");
		textError.setLocation(0, 60);
		textError.setSize(250, 20);
		textError.setForeground(Color.RED);
		
		this.add(ok);
		this.add(textfeldHoehe);
		this.add(textfeldBreite);
		this.add(textHoehe);
		this.add(textBreite);
		this.add(textError);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("ok")) {
			try {
				if(Integer.parseInt(this.textfeldHoehe.getText())< 15 && Integer.parseInt(this.textfeldHoehe.getText())>= 8 && Integer.parseInt(this.textfeldBreite.getText())< 15 && Integer.parseInt(this.textfeldBreite.getText())>= 8) {
					new LabyrinthEditor(Integer.parseInt(this.textfeldHoehe.getText()), Integer.parseInt(this.textfeldBreite.getText()));
					ok.setEnabled(false);
					textError.setText("");
				}
				else {
					textError.setText("Mindestgrösse 8x8, Maximalgrösse 15x15");
				}
				
				
			}
			
			catch(Exception ex){
				textError.setText("Mindestens eine Eingabe ist ungültig!");
			}
		}
		
	}

}
