package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConteneurMilieu extends JPanel {
	
	public ConteneurMilieu() {
		super();
		
		setBackground(Color.RED);
	}
	
	public ConteneurMilieu(String mess, int size, JPanel content) {
		super();
		
		setLayout(new BorderLayout());
		JLabel message = new JLabel(mess);
		message.setForeground(Color.white);
		message.setFont(new Font("Serif", Font.PLAIN, size));
		message.setBorder(BorderFactory.createEmptyBorder(100, 200, 50, 200));
		
		
		
		setBackground(Color.RED);

		this.add(message, BorderLayout.NORTH);
		this.add(content, BorderLayout.CENTER);
	}
}
