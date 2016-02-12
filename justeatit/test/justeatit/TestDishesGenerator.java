package justeatit;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestDishesGenerator {

	
	@Test
	public void test1(){
		LinkedHashSet<String> setOfIngredients = new LinkedHashSet<String>();
		
		setOfIngredients.add("Apple");
		setOfIngredients.add("Orange");
		setOfIngredients.add("Egg");
		setOfIngredients.add("Fish");
		setOfIngredients.add("Meat");
		setOfIngredients.add("Bread");
		setOfIngredients.add("Carrot");
		setOfIngredients.add("Cucumber");
		setOfIngredients.add("Tomat");
		
		List<String> actual = DishesGenerator.genereteDish(setOfIngredients, 3);
		
		List<String> expected = new ArrayList<String>();
		expected.add("Apple");
		expected.add("Orange");
		expected.add("Egg");
		
		Assert.assertEquals(expected, actual);
		
		
	}
}
