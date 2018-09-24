package edu.eci.pdsw;

import org.quicktheories.generators.Generate;
import edu.eci.pdsw.orderCalculator.model.Dish;
import edu.eci.pdsw.orderCalculator.model.DishType;
import org.quicktheories.core.Gen;
import static org.quicktheories.generators.SourceDSL.*;

public class DishGenerator {
	
	public static Gen<Dish> dishes(){
		return dishType().zip(name(), price(), (DishType,name,price) -> new Dish 
				(DishType, name, price));
	}
	
	private static Gen<DishType> dishType(){
		return Generate.enumValues(DishType.class);
	}
	
	private static Gen<String> name(){
		return strings().basicLatinAlphabet().ofLengthBetween(0, 20);
	}
	
	private static Gen<Integer> price(){
		return integers().allPositive().map( x -> {	return x-1;});
	}
	
	
	
}
