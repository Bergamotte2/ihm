package application;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Fleche extends JPanel{
	
	class dessinFleche extends JPanel {
		int x;
		public dessinFleche() {
			x = 0;
			
			setBackground(Color.RED);
			setPreferredSize(new Dimension(100, 150));
			
			new Timer().scheduleAtFixedRate(new TimerTask() {
			    @Override
			    public void run(){
			    	x = (x+1)%2;
			    	repaint();
			    }
			},800L,800L);
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.WHITE);
			((Graphics2D) g).setStroke(new BasicStroke(1));
			g.fillRect(getWidth()/2-10, 30-x*30, 20, getHeight()-60);
			
			Polygon tete = new Polygon();
			tete.addPoint(getWidth()/2-20, getHeight()-30-x*30);
			tete.addPoint(getWidth()/2+20, getHeight()-30-x*30);
			tete.addPoint(getWidth()/2, getHeight()-x*30);
			
			g.fillPolygon(tete);
		}
	}
	
	public Fleche() {			
		super();
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBackground(Color.RED);
		
		dessinFleche fleche = new dessinFleche();
		
		
		this.add(fleche);
	}
}
