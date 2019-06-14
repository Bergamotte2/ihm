package application;

import javax.swing.*;
import java.awt.*;

public class FenetreATM extends JFrame {

	public FenetreATM() {
		super();
		buildFrame();
	}
	
	public void buildFrame() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setSize(screenSize.width, screenSize.height);
	    setUndecorated(true);
		setTitle("Calculatrice");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setContentPane(buildPanel());
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public JPanel buildPanel() {
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
				
		contentPane.setOpaque(true);
		contentPane.setBackground(Color.white);
		
		Ruban nomBanque = new Ruban("Banque machin", "M.DUPONT");
		contentPane.add(nomBanque);
	
		return contentPane;
	}
}
