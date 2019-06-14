package application;

import java.awt.*;
import javax.swing.*;

public class Ruban extends JPanel {
	String titreG, titreD;
	
	public Ruban(String titreG, String titreD) {
		super();
		this.titreG = titreG;
		this.titreD = titreD;
		JLabel labelTitreG = new JLabel(titreG);
		JLabel labelTitreD = new JLabel(titreD);
		
		setBackground(Color.GREEN);
		
		this.add(labelTitreG, BorderLayout.WEST);
		this.add(labelTitreD, BorderLayout.EAST);
}
}
