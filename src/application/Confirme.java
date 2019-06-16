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

public class Confirme extends JPanel {
	
	public Confirme() {
		super();
		setLayout(new GridLayout(1,5));
		setBackground(Color.RED);

		Option oui = new Option("OUI");
		Option non = new Option("NON");
		
		this.add(Box.createRigidArea(new Dimension(0, 0)));
		this.add(oui);
		this.add(Box.createRigidArea(new Dimension(0, 0)));
		this.add(non);
		this.add(Box.createRigidArea(new Dimension(0, 0)));
	}
}
