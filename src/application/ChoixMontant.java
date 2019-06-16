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
	
	public ChoixMontant() {
		super();
		setLayout(new GridLayout(3,3));
		setBackground(Color.RED);

		Option dix = new Option("10 €");
		Option vingt = new Option("20 €");
		Option cinquante = new Option("50 €");
		Option cent = new Option("100 €");

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
}
