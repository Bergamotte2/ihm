package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConteneurMilieu extends JPanel {
	
	public ConteneurMilieu() {
		super();
		
		setBackground(Color.RED);
	}
	
	public ConteneurMilieu(String mess) {
		super();
		
		JLabel message = new JLabel(mess, JLabel.CENTER);
		message.setForeground(Color.white);
		message.setFont(new Font("Serif", Font.PLAIN, 80));
		setBackground(Color.RED);
		
		this.add(message);
	}
}
