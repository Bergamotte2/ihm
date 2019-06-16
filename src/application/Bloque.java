package application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bloque extends JPanel {
	
	boolean blocked = true;
	
	public Bloque() {
		super();
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBackground(Color.RED);
		
		JLabel points = new JLabel("Accès bloqué durant 10 minutes");
		points.setForeground(Color.WHITE);
		points.setFont(new Font("Serif", Font.PLAIN,30));
		
		new Timer().schedule(new TimerTask() {
		    @Override
		    public void run(){
		    	blocked = false;
		    }
		},10000L);
		
		this.add(points);
	}
	
	public boolean isBlocked() {
		return blocked;
	}
}