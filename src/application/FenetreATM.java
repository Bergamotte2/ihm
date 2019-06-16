package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sdd.HistoriqueTransferts;

public class FenetreATM extends JFrame {
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = (int) screenSize.getWidth();
	private int height = (int) screenSize.getHeight();
	private HistoriqueTransferts history = new HistoriqueTransferts();
	
	public FenetreATM() {
		super();
		new Thread(() -> {
			fillHistory();
		}).start();
		buildFrame();
	}
	
	public void changeFrame(JPanel content) {
		setContentPane(content);
		setVisible(true);
	}
	
	public void buildFrame() {
	    setUndecorated(true);
	    setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		changeFrame(buildCode());
	}
	
	public JPanel buildHeader() {
		for( ComponentListener al : this.getComponentListeners() ) {
	        this.removeComponentListener( al );
	    }
		
		for( KeyListener al : this.getKeyListeners() ) {
	        this.removeKeyListener( al );
	    }
		
		for( MouseListener al : this.getMouseListeners() ) {
	        this.removeMouseListener( al );
	    }
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.setOpaque(true);
		Color MyGrey = new Color(225, 225, 225);
		contentPane.setBackground(MyGrey);
		
		Ruban infosBanque = new Ruban("The Banque", "M.DUPONT");
		contentPane.add(infosBanque, BorderLayout.NORTH);
		
		return contentPane;
	}
	
public JPanel buildInserer() {
		
		JPanel contentPane = buildHeader();
		
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.Y_AXIS));
		centerPane.setBorder(BorderFactory.createEmptyBorder(80, 200, 100, 200));
		
		Fleche inserer = new Fleche();
		
		ConteneurMilieu cM = new ConteneurMilieu("<html><center>Veuillez insérer votre carte</center></html>", 60, inserer);
		
		centerPane.add(cM);	
		
		JButton btn = new JButton("lol");
		centerPane.add(btn);
		
		btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				changeFrame(buildLectureCarte());
			}
		});
		
		//ICI Débloque
		
		contentPane.add(centerPane, BorderLayout.CENTER);
				
		return contentPane;
	}
	
public JPanel buildLectureCarte() {
	JPanel contentPane = buildHeader();
	
	JPanel centerPane = new JPanel();
	centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.Y_AXIS));
	centerPane.setBorder(BorderFactory.createEmptyBorder(80, 200, 100, 200));

	Chargement lecture = new Chargement();
	
	ConteneurMilieu cM = new ConteneurMilieu("<html><center>Lecture de la carte en cours</center></html>", 60, lecture);
	
	centerPane.add(cM);
	
	new Thread(() -> {
		while(!lecture.isEnded()) {
			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}
		}
		changeFrame(buildCode());
	}).start();
	
	contentPane.add(centerPane, BorderLayout.CENTER);	
	
	return contentPane;
}

public JPanel buildCode() {
	JPanel contentPane = buildHeader();
	
	JPanel centerPane = new JPanel();
	centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.Y_AXIS));
	centerPane.setBorder(BorderFactory.createEmptyBorder(80, 200, 100, 200));

	CodeBanque codeBanque = new CodeBanque(this);
	
	ConteneurMilieu cM = new ConteneurMilieu("<html><center>Veuillez saisir votre code confidentiel</center></html>", 50, codeBanque);
	
	centerPane.add(cM);	
	
	new Thread(() -> {
		while(!codeBanque.getCode().equals("0000")) {
			System.out.println(codeBanque.getCode());
		}
		changeFrame(buildVerification());
	}).start();
	
	
	contentPane.add(centerPane, BorderLayout.CENTER);
	
	
	return contentPane;
}

public JPanel buildVerification() {
	JPanel contentPane = buildHeader();
	
	JPanel centerPane = new JPanel();
	centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.Y_AXIS));
	centerPane.setBorder(BorderFactory.createEmptyBorder(80, 200, 100, 200));

	Chargement lecture = new Chargement();
	
	ConteneurMilieu cM = new ConteneurMilieu("<html><center>Vérification en cours</center></html>", 60, lecture);
	
	centerPane.add(cM);
	
	new Thread(() -> {
		while(!lecture.isEnded()) {
			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}
		}
		changeFrame(buildChoixMenu());
	}).start();
	
	contentPane.add(centerPane, BorderLayout.CENTER);	
	
	return contentPane;
}

public JPanel buildChoixMenu() {
	JPanel contentPane = buildHeader();
	
	JPanel centerPane = new JPanel();
	centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.Y_AXIS));
	centerPane.setBorder(BorderFactory.createEmptyBorder(80, 200, 100, 200));

	ChoixMenu choixMenu = new ChoixMenu();
	
	ConteneurMilieu cM = new ConteneurMilieu(choixMenu);
	
	centerPane.add(cM);
	
	new Thread(() -> {
		while(choixMenu.getChoix()==0) {
			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}
		}
		int c = choixMenu.getChoix();
		if (c==1) changeFrame(buildDepot());
		else if (c==2) changeFrame(buildRetrait());
		else if (c==3) changeFrame(buildHistorique());
	}).start();
	
	Option retour = new Option("QUITER");
	centerPane.add(retour);
	
	retour.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			changeFrame(buildInserer());
		}
	});
	
	contentPane.add(centerPane, BorderLayout.CENTER);	
	
	return contentPane;
}

public JPanel buildDepot() {
	JPanel contentPane = buildHeader();
	
	JPanel centerPane = new JPanel();
	centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.Y_AXIS));
	centerPane.setBorder(BorderFactory.createEmptyBorder(80, 200, 100, 200));

	ChoixMontant choixMontant = new ChoixMontant();
	
	ConteneurMilieu cM = new ConteneurMilieu(choixMontant);
	
	centerPane.add(cM);
	
	/*new Thread(() -> {
		while(choixMontant.getChoix()==0) {
			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}
		}
		int c = choixMontant.getChoix();
		if (c==1) changeFrame(buildDepot());
	}).start();*/
	
	Option retour = new Option("RETOUR");
	centerPane.add(retour);
	
	retour.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			changeFrame(buildChoixMenu());
		}
	});
	
	contentPane.add(centerPane, BorderLayout.CENTER);	
	
	return contentPane;
}

public JPanel buildRetrait() {
	JPanel contentPane = buildHeader();
	
	JPanel centerPane = new JPanel();
	centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.Y_AXIS));
	centerPane.setBorder(BorderFactory.createEmptyBorder(80, 200, 100, 200));

	ChoixMontant choixMontant = new ChoixMontant();
	
	ConteneurMilieu cM = new ConteneurMilieu(choixMontant);
	
	centerPane.add(cM);
	
	/*new Thread(() -> {
		while(choixMontant.getChoix()==0) {
			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}
		}
		int c = choixMontant.getChoix();
		if (c==1) changeFrame(buildDepot());
	}).start();*/
	
	Option retour = new Option("RETOUR");
	centerPane.add(retour);
	
	retour.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			changeFrame(buildChoixMenu());
		}
	});
	
	contentPane.add(centerPane, BorderLayout.CENTER);	
	
	return contentPane;
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

public JPanel buildHistorique() {
	
	//met à jour l'historique à la date d'aujourd'hui si aucun transfert n'a eu lieu
	if(history.get(LocalDate.now())==null){
		history.addData(0);
	}
	
	JPanel contentPane = buildHeader();
	
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
			changeFrame(buildChoixMenu());
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
	 
}
