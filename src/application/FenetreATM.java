package application;

import javax.swing.*;

import sdd.HistoriqueTransferts;

import java.awt.*;
import java.time.LocalDate;

public class FenetreATM extends JFrame {
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = (int) screenSize.getWidth();
	private int height = (int) screenSize.getHeight();
	private HistoriqueTransferts history = new HistoriqueTransferts();
	

	public FenetreATM() {
		super();
		fillHistory();
		buildFrame();
	}
	
	public void fillHistory() {
		//depart = total banque = 0
		history.addData(LocalDate.now().minusDays(14), 200); //total banque = 200
		//semaine étudiée
		history.addData(LocalDate.now().minusDays(7), 800); //total banque = 1000
		history.addData(LocalDate.now().minusDays(4), -780); //total banque = 220
		history.addData(LocalDate.now().minusDays(3), -220); //total banque = 0
		history.addData(500);
	}
	
	public void buildFrame() {
	    setUndecorated(true);
	    setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setContentPane(buildTransferPane());
		setVisible(true);
	}
	
	public JPanel buildTransferPane() {
		
		
		//met à jour l'historique à la date d'aujourd'hui si aucun transfert n'a eu lieu
		if(history.get(LocalDate.now())==null){
			history.addData(0);
		}
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.setOpaque(true);
		Color MyGrey = new Color(225, 225, 225);
		contentPane.setBackground(MyGrey);
		
		Ruban infosBanque = new Ruban("The Banque", "M.DUPONT");
		contentPane.add(infosBanque, BorderLayout.NORTH);
	
			JPanel centerPane = new JPanel();
			centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.Y_AXIS));
			centerPane.setBorder(BorderFactory.createEmptyBorder(80, 0, 40, 0));
			
			Graphique graphique = new Graphique(history);
			graphique.setMaximumSize(new Dimension((int) (width*0.7), (int) (height*0.58)));
			centerPane.add(graphique);
		
		contentPane.add(centerPane);
		
		/**
		*ConteneurMilieu carreRouge = new ConteneurMilieu(null); a déjà une prefered size
		*centerPane.add(carreRouge);
		*JLabel empty = new JLabel();
		*centerPane.add(empty);
		*/
		
		
		return contentPane;
	}
	 
}
