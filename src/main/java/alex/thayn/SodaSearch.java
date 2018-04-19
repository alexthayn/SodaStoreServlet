package alex.thayn;

import java.util.ArrayList;
import java.util.List;

public class SodaSearch {
	private SodaSelect sodas;
	
	public List searchForSoda(String query) {		
		List allSodas = sodas.getAllBrands();
		List queryMatches = new ArrayList();
		
		for(int i=0; i<allSodas.size();i++) {
			String soda = (String) allSodas.get(i);
			if(soda.contains(query)) {
				queryMatches.add(soda);
			}
		}
		return queryMatches;
	}
}
