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
		paneup.setPreferredSize(new Dimension(150, 150));
		JPanel paned = new JPanel();
		paned.setPreferredSize(new Dimension(150, 150));
		JPanel panew = new JPanel();
		panew.setPreferredSize(new Dimension(250, 200));
		JPanel panee = new JPanel();
		panee.setPreferredSize(new Dimension(250, 200));
		
		CodeBanque codeBanque = new CodeBanque((JFrame)this);
		ChoixMenu choixMenu = new ChoixMenu();
		ChoixMontant choixMontant = new ChoixMontant();
		Chargement lecture = new Chargement();
		Chargement verification = new Chargement();
		Fleche inserer = new Fleche();
		Confirme confirmeRetire = new Confirme();
		Bloque bloque = new Bloque();
	
		//ConteneurMilieu cM = new ConteneurMilieu("<html><center>Veuillez saisir votre code confidentiel</center></html>", 50, codeBanque);
		//ConteneurMilieu cM = new ConteneurMilieu(choixMenu);
		//ConteneurMilieu cM = new ConteneurMilieu(choixMontant);
		//ConteneurMilieu cM = new ConteneurMilieu("<html><center>Lecture de la carte en cours</center></html>", 60, lecture);
		//ConteneurMilieu cM = new ConteneurMilieu("<html><center>Vérification en cours</center></html>", 60, verification);
		//ConteneurMilieu cM = new ConteneurMilieu("<html><center>Veuillez insérer votre carte</center></html>", 60, inserer);
		//ConteneurMilieu cM = new ConteneurMilieu("<html><center>Souhaitez-vous retirer ... € depuis votre compte ?</center></html>", 60, confirmeRetire);
		ConteneurMilieu cM = new ConteneurMilieu("<html><center>Code eronné</center></html>", 80, bloque);
		
		contentPane.add(paneup, BorderLayout.NORTH);
		contentPane.add(paned, BorderLayout.SOUTH);
		contentPane.add(panew, BorderLayout.WEST);
		contentPane.add(panee, BorderLayout.EAST);
		contentPane.add(cM, BorderLayout.CENTER);
		
		
		return contentPane;
	}
}
