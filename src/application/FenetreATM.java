package application;

import javax.swing.*;
import javax.swing.border.Border;

import sdd.HistoriqueTransferts;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

public class FenetreATM extends JFrame {
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = (int) screenSize.getWidth();
	private int height = (int) screenSize.getHeight();
	private HistoriqueTransferts history = new HistoriqueTransferts();
	int actualFrame = 0;
	int nextFrame = 0;
	
	public FenetreATM() {
		super();
		fillHistory();
		buildFrame();
	}
	
	public void changeFrame(JPanel content) {
		setContentPane(content);
		setVisible(true);
	}
	
	public void fillHistory() {
		//depart = total banque = 0
		history.addData(LocalDate.now().minusDays(14), 200); //total banque = 200
		//semaine étudiée
		history.addData(LocalDate.now().minusDays(7), 800); //total banque = 1000
		history.addData(LocalDate.now().minusDays(4), -780); //total banque = 220
		history.addData(LocalDate.now().minusDays(3), +220); //total banque = 0
		history.addData(500);
	}
	
	public void buildFrame() {
	    setUndecorated(true);
	    setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		changeFrame(buildHistorique());
	}
	
	public JPanel buildHeader() {
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.setOpaque(true);
		Color MyGrey = new Color(225, 225, 225);
		contentPane.setBackground(MyGrey);
		
		Ruban infosBanque = new Ruban("The Banque", "M.DUPONT");
		contentPane.add(infosBanque, BorderLayout.NORTH);
		
		return contentPane;
	}
	
	public JPanel buildHistorique() {
		
		//met à jour l'historique à la date d'aujourd'hui si aucun transfert n'a eu lieu
		if(history.get(LocalDate.now())==null){
			history.addData(0);
		}
		
		JPanel contentPane = buildHeader();
		
		/*JButton btn = new JButton("lol");
		btn.setAlignmentX(Component.CENTER_ALIGNMENT);
		centerPane.add(btn);*/
		
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.Y_AXIS));
		centerPane.setBorder(BorderFactory.createEmptyBorder(80, 200, 100, 200));
		
		Graphique graphique = new Graphique(history);
		graphique.setMaximumSize(new Dimension((int) (width*0.7), (int) (height*0.58)));
		
		ConteneurMilieu cM = new ConteneurMilieu(graphique);
		
		centerPane.add(cM);	
		
		Option retour = new Option("RETOUR");
		centerPane.add(retour);
		
		retour.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				changeFrame(buildInserer());
			}
		});
		
		contentPane.add(centerPane, BorderLayout.CENTER);
		
		/**
		*ConteneurMilieu carreRouge = new ConteneurMilieu(null); a déjà une prefered size
		*centerPane.add(carreRouge);
		*JLabel empty = new JLabel();
		*centerPane.add(empty);
		*/
		
		
		return contentPane;
	}
	
	public JPanel buildInserer() {
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.setOpaque(true);
		Color MyGrey = new Color(225, 225, 225);
		contentPane.setBackground(MyGrey);
		
		Ruban infosBanque = new Ruban("The Banque", "M.DUPONT");
		contentPane.add(infosBanque, BorderLayout.NORTH);
		
		/*JButton btn = new JButton("lol");
		btn.setAlignmentX(Component.CENTER_ALIGNMENT);
		centerPane.add(btn);*/
		
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.Y_AXIS));
		centerPane.setBorder(BorderFactory.createEmptyBorder(80, 200, 100, 200));
		
		Fleche inserer = new Fleche();
		
		ConteneurMilieu cM = new ConteneurMilieu("<html><center>Veuillez insérer votre carte</center></html>", 60, inserer);
		
		centerPane.add(cM);	
		
		JButton btn = new JButton("lol");
		centerPane.add(btn);
		
		contentPane.add(centerPane, BorderLayout.CENTER);
		
		/**
		*ConteneurMilieu carreRouge = new ConteneurMilieu(null); a déjà une prefered size
		*centerPane.add(carreRouge);
		*JLabel empty = new JLabel();
		*centerPane.add(empty);
		*/
		
		
		return contentPane;
	}
	 
}
