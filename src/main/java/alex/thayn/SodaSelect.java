package alex.thayn;

import java.util.ArrayList;
import java.util.List;

public class SodaSelect{

	public List getAvailableBrands(SodaType type){
		List brands = new ArrayList();

	
		if(type.equals(SodaType.Pepsico)){
			brands.add("Pepsi");
			brands.add("Mug Root Beer");
			brands.add("Mountain Dew");
		}
		else if(type.equals(SodaType.COCACOLA)){
			brands.add("Coca-Cola");
			brands.add("Sprite");
			brands.add("Fanta");
			brands.add("Fresca");
		}	
		else if(type.equals(SodaType.DRPEPPERSNAPPLE)){
			brands.add("7up");
			brands.add("A&W Root Beer");
			brands.add("Crush");
		}
		else{
			brands.add("No Brand Available");
		}
		
		return brands;
	}
	
	public List getAllDrinks() {
		List brands = new ArrayList();
		brands.add("Pepsi");
		brands.add("Mug Root Beer");
		brands.add("Mountain Dew");
		brands.add("Coca-Cola");
		brands.add("Sprite");
		brands.add("Fanta");
		brands.add("Fresca");
		brands.add("7up");
		brands.add("A&W Root Beer");
		brands.add("Crush");
		
		return brands;
	}
}
