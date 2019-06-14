package application;

import javax.swing.*;
import java.awt.*;

public class FenetreATM extends JFrame {
	

	public FenetreATM() {
		super();
		buildFrame();
	}
	
	public void buildFrame() {
	    setUndecorated(true);
	    setExtendedState(MAXIMIZED_BOTH);
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
		
		Ruban infosBanque = new Ruban("The Banque", "M.DUPONT");
		contentPane.add(infosBanque, BorderLayout.NORTH);
	
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.Y_AXIS));
		
		/**
		*ConteneurMilieu carreRouge = new ConteneurMilieu(null); a déjà une prefered size
		*centerPane.add(carreRouge);
		*JLabel empty = new JLabel();
		*centerPane.add(empty);
		*/
		
		
		return contentPane;
	}
}
