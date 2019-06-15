package application;

import java.awt.*;
import java.awt.geom.Line2D;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import sdd.HistoriqueTransferts;

public class Graphique extends JPanel {
	
	public Graphique(HistoriqueTransferts h) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new GraphContent(h));
		setOpaque(true);
		Color MyGrey = new Color(241, 241, 241);
		setBackground(MyGrey);
		Color MyRed = new Color(220, 52, 61);
		setBorder(BorderFactory.createLineBorder(MyRed, 5));
	}
	
	
		// BEGINNING of GraphContent
		public class GraphContent extends JPanel {
			ArrayList<LocalDate> dateArray = new ArrayList<LocalDate>();
			TreeMap<LocalDate, Integer> freshHistory = new TreeMap<LocalDate, Integer>();
			
			public GraphContent(HistoriqueTransferts h) {
			super();
			setBackground(null);
			
			//Remplissage des 8 derniers jours dans un tableau et un TreeMap
			freshHistory.putAll(h.getWeekHistory());
			
			for (LocalDate date : freshHistory.keySet()) {
				dateArray.add(date);
			}
			}
			
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				//Colors
				Color Danger = new Color(147, 42, 91);
				Color MyBrown = new Color(76, 76, 76);
				Color Neutral = new Color(25, 111, 107);
				Color Great = new Color(168, 201, 16);
				
				//X axis
				g.setColor(MyBrown);
				g.fillRect(75, 540, 1200, 8);
				//Y axis
				g.setColor(Neutral);
				g.fillRect(75, 60, 8, 480);
				
				//Y markers
				g.setColor(Neutral);
				for(int i=10; i>=0; i--) {
					g.fillRect(61, 540-i*48, 14, 3);
					g.fillRect(83, 540-i*48+1, 1192, 1);
				}
				g.setColor(Neutral);
				for(int i=10; i>=0; i--) {
					Integer amount = 100*i;
					g.setFont(new Font("Roboto", Font.BOLD, 16)); 
					g.drawString(amount.toString(), 24, 540-i*48+6);
				}
				
				//X markers
				g.setColor(MyBrown);
				for(int i=0; i<8; i++) {
					g.fillRect(83+i*160, 548, 3, 14);
				}
				
				int previousX = 83;
				int previousY = (int)540-freshHistory.get(dateArray.get(0))/100*48;
				for(int i=0; i<8; i++) {
					// Draw the String
					g.setColor(MyBrown);
					g.setFont(new Font("Roboto", Font.BOLD, 17));
					g.drawString(goodFormat(dateArray.get(i)), (83+i*160)-17, 577);
					
					//Draw points
					int x = 83+i*160;
					int y = (int)540-freshHistory.get(dateArray.get(i))/100*48;
					
					
					
					//Draw lines between points
					if (previousY < y) {g.setColor(Danger);}
					else {
						if (previousY > y) {g.setColor(Great);}
						else {g.setColor(Neutral);}
					}
					Graphics2D g2 = (Graphics2D) g;
	                g2.setStroke(new BasicStroke(5));
	                g2.draw(new Line2D.Float(previousX, previousY, x, y));
	           
					g.fillOval(previousX-6, previousY-6, 12, 12);
					g.fillOval(x-6, y-6, 12, 12);
					
					//Update "previous" values
					previousY = y;
					previousX = 83+i*160;
				}

				}
			
			public String goodFormat(LocalDate date) {
				//format: dd/MM
				String formattedDate = date.format(DateTimeFormatter.ofPattern("MM/dd"));
				return formattedDate;
			}
			
		} // END of GraphContent
	
}
