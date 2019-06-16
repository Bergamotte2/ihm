package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class ChoixMenu extends JPanel {
	
	int choix = 0;
	
	public ChoixMenu() {
		super();
		setLayout(new GridLayout(5,1));
		setBackground(Color.RED);

		Option depot = new Option("DEPOT");
		depot.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				choix=1;
			}
		});
		
		Option retrait = new Option("RETRAIT");
		retrait.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				choix=2;
			}
		});
		
		Option historique = new Option("HISTORIQUE DES TRANSACTIONS");
		historique.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				choix=3;
			}
		});

		this.add(depot);
		this.add(Box.createRigidArea(new Dimension(0, 0)));
		this.add(retrait);
		this.add(Box.createRigidArea(new Dimension(0, 0)));
		this.add(historique);
	}
	
	public int getChoix() {
		return choix;
	}
}
