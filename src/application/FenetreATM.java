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
		
		Ruban nomBanque = new Ruban("Banque machin", "M.DUPONT");
		contentPane.add(nomBanque, BorderLayout.NORTH);
	
		JLabel tmpLabel = new JLabel("test");
		contentPane.add(tmpLabel, BorderLayout.CENTER);
		
		
		return contentPane;
	}
}
