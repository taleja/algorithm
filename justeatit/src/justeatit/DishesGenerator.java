package justeatit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class DishesGenerator {
	
	public static List<String> genereteDish(LinkedHashSet<String> newSet, int count){
		
		List<String> listOfIngredients = new ArrayList<String>();
		Iterator<String> iterator = newSet.iterator();
		
		while(count != 0 && iterator.hasNext()){
			listOfIngredients.add(iterator.next());
			count--;
		}
		
		return listOfIngredients;
		
	}

}
