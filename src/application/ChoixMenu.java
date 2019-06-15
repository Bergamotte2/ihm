package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class ChoixMenu extends JPanel {
	
	public class Option extends JLabel {
		public Option(String text) {
			super(text);
			
			setForeground(Color.BLACK);
			setFont(new Font("Serif", Font.PLAIN, 40));
			setBackground(new Color(200, 200, 200));
			
			setHorizontalAlignment(JLabel.CENTER);
		    setVerticalAlignment(JLabel.CENTER);
		    setAlignmentX(Component.CENTER_ALIGNMENT);
			//setPreferredSize(new Dimension(500, getPreferredSize().height+10));
		    //setMinimumSize(new Dimension(500, getPreferredSize().height));
			setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 5));
			
			setOpaque(true);
			
			addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent e) {
	            	setActive(true);
	            }
	            public void mouseExited(MouseEvent e) {
	            	setActive(false);
	            }
	        });
		}
		
		public void setActive(boolean active) {
			if (active) setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 15));
			else setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 5));
		}
	}

	String code = "";
	
	public ChoixMenu() {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.RED);

		Option depot = new Option("DEPOT");
		Option retrait = new Option("RETRAIT");
		Option historique = new Option("HISTORIQUE DES TRANSACTIONS");

		this.add(depot);
		this.add(Box.createRigidArea(new Dimension(5, 50)));
		this.add(retrait);
		this.add(Box.createRigidArea(new Dimension(5, 50)));
		this.add(historique);
	}
}
