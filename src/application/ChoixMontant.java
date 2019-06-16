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

public class ChoixMontant extends JPanel {
	
	int choix = 0;
	
	public ChoixMontant() {
		super();
		setLayout(new GridLayout(3,3));
		setBackground(Color.RED);

		Option dix = new Option("10 €");
		dix.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				choix=10;
			}
		});
		
		Option vingt = new Option("20 €");
		vingt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				choix=20;
			}
		});
		
		Option cinquante = new Option("50 €");
		cinquante.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				choix=50;
			}
		});
		
		Option cent = new Option("100 €");
		cent.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				choix=100;
			}
		});

		this.add(dix);
		this.add(Box.createRigidArea(new Dimension(0, 0)));
		this.add(vingt);
		this.add(Box.createRigidArea(new Dimension(0, 0)));
		this.add(Box.createRigidArea(new Dimension(0, 0)));
		this.add(Box.createRigidArea(new Dimension(0, 0)));
		this.add(cinquante);
		this.add(Box.createRigidArea(new Dimension(0, 0)));
		this.add(cent);
	}
	
	public int getChoix() {
		return choix;
	}
}
