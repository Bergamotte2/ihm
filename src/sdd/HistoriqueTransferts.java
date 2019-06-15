package sdd;

import java.time.LocalDate;
import java.time.Period;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Set;

public class HistoriqueTransferts {
	
	//Integer = montant du transfert
	
	private TreeMap<LocalDate, Integer> collection = new TreeMap<LocalDate, Integer>();
	private static int lastValue = 0;
	private static LocalDate lastTransfer;
	
	public HistoriqueTransferts() {
		//empty method
	}
	
	public TreeMap<LocalDate, Integer> getWeekHistory() {
		
		TreeMap<LocalDate, Integer> tmp = new TreeMap<LocalDate, Integer>();
		
		LocalDate lastWeek = LocalDate.now().minusWeeks(1);
		
		tmp.putAll(collection.tailMap(lastWeek));
		return tmp;
	}
	
	
	public TreeMap<LocalDate, Integer> getWholeHistory() {
		return collection;
	}
	
	
	// appeler addData à chaque clic sur "consulter les transferts" avec la date d'ajd et la valeur du transfert = 0 
	
	public void addData(LocalDate date, Integer transferValue) {
		//spec : date>lastTransfer
		
		if (lastTransfer!=null) {
			Period period = Period.between(lastTransfer, date);
			int days = period.getDays();
			if (days>0) {
				for(int i=days-1; i>0; i--) {
					collection.put(date.minusDays(i), lastValue);
				}
			}
		}
		
		lastTransfer = date;
		
		collection.put(date, lastValue + transferValue);
		lastValue += transferValue;
	}
	
	public void addData(Integer transferValue) {
		
		addData(LocalDate.now(), transferValue);
	}
	
	
	public Set<LocalDate> keySet() {
		Set<LocalDate> tmp = new TreeSet<LocalDate>();
		tmp = collection.keySet();
		return tmp;
	}
	
	
	public Integer get(LocalDate key) {
		return collection.get(key);
	}
	
}
