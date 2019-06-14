package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreMomo extends JFrame {
	public FenetreMomo() {
		super();
		buildFrame();
	}
	
	public void buildFrame() {
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setContentPane(buildPanel());
		setVisible(true);
	}
	
	public JPanel buildPanel() {
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.setOpaque(true);
		contentPane.setBackground(Color.WHITE);
		
		JPanel paneup = new JPanel();
		paneup.setPreferredSize(new Dimension(150, 200));
		JPanel paned = new JPanel();
		paned.setPreferredSize(new Dimension(150, 200));
		JPanel panew = new JPanel();
		panew.setPreferredSize(new Dimension(400, 200));
		JPanel panee = new JPanel();
		panee.setPreferredSize(new Dimension(400, 200));
	
		ConteneurMilieu codeBanque = new ConteneurMilieu("Veuillez saisir votre code confidentiel");
		
		contentPane.add(paneup, BorderLayout.NORTH);
		contentPane.add(paned, BorderLayout.SOUTH);
		contentPane.add(panew, BorderLayout.WEST);
		contentPane.add(panee, BorderLayout.EAST);
		contentPane.add(codeBanque, BorderLayout.CENTER);
		
		
		return contentPane;
	}
}