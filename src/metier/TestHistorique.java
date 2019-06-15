package metier;

import java.util.TreeMap;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import sdd.*;

public class TestHistorique {

	public static void main(String[] args) {
		
					// Tests sur l'historique des transferts
		
		// Creation d'un historique rempli depuis 2 semaines
		HistoriqueTransferts h = new HistoriqueTransferts();
		
		h.addData(LocalDate.now().minusDays(14), 1000); //total banque = 1000
		
		h.addData(LocalDate.now().minusDays(7), 10); //total banque = 1010
		
		h.addData(LocalDate.now().minusDays(4), -500); //total banque = 510
		h.addData(LocalDate.now().minusDays(3), -520); //total banque = -10
		
		for (LocalDate date : h.keySet()) {
		     System.out.println("Date: " + goodFormat(date) + " | Montant: " + h.get(date));
		}
		System.out.println();
		
		// Simulation de l'ajout automatique quand on demande l'affichage
		h.addData(0);
		
		// Affichage
		TreeMap<LocalDate, Integer> freshHistory = h.getWeekHistory();
		
		for (LocalDate date : freshHistory.keySet()) {
		     System.out.println("Date: " + goodFormat(date) + " | Montant: " + freshHistory.get(date));
		}

		
	} // END OF MAIN
	
	
	
	public static String goodFormat(LocalDate date) {
		//formate en dd/MM
		String formattedDate = date.format(DateTimeFormatter.ofPattern("MM/dd"));
		return formattedDate;
	}
	
	

}
