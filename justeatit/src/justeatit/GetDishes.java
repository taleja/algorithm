package justeatit;

import java.util.LinkedHashSet;
import java.util.List;

public class GetDishes {
	
	private static LinkedHashSet<String> newSet = new LinkedHashSet<String>(); 

	public static void main(String[] args) {
		
		int count = 3; 
		
		newSet.add("Apple");
		newSet.add("Orange");
		newSet.add("Egg");
		newSet.add("Fish");
		newSet.add("Meat");
		newSet.add("Bread");
		newSet.add("Carrot");
		newSet.add("Cucumber");
		newSet.add("Tomat");
		
		List<String> listOfValues = DishesGenerator.genereteDish(newSet, count);
		System.out.println(listOfValues.toString());

	}

}
