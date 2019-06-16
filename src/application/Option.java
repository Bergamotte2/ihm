package application;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Option extends JLabel {
	public Option(String text) {
		super(text);
		
		setForeground(Color.BLACK);
		setFont(new Font("Serif", Font.PLAIN, 40));
		setBackground(new Color(200, 200, 200));
		
		setHorizontalAlignment(JLabel.CENTER);
	    setVerticalAlignment(JLabel.CENTER);
	    setAlignmentX(Component.CENTER_ALIGNMENT);
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
		if (active) setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 10));
		else setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 5));
	}
}