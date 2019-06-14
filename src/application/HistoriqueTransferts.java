package application;

import java.time.format.DateTimeFormatter;
import java.util.*;

public class HistoriqueTransferts {
	
	private TreeMap<String, Integer> collection = new TreeMap<String, Integer>();
	
	public HistoriqueTransferts() {
		
	}
	
	public HistoriqueTransferts(TreeMap<String, Integer> myMap) {
		
		this.collection.putAll(myMap);
	}
	
	public TreeMap<String, Integer> getThirtyLast() {
		
		TreeMap<String, Integer> tmp = new TreeMap<String, Integer>();
		
		String then=/*date du systeme*/;
		
		
		tmp.putAll(this.collection.tailMap(then));
		return tmp;
	}
}
