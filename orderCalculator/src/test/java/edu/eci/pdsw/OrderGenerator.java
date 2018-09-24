package edu.eci.pdsw;

import org.quicktheories.generators.Generate;

import edu.eci.pdsw.orderCalculator.model.*;

import org.quicktheories.core.Gen;
import static org.quicktheories.generators.SourceDSL.*;

import java.util.List;

public class OrderGenerator {

	public static Gen<Order> orders() {
		return generatorDishes().map(generatorDishes ->{
				Order order = new Order();
				generatorDishes.forEach(d-> order.addDish(d));
				return order;		
		  });
	}
	
	private static Gen<List<Dish>> generatorDishes(){
		return lists().of(DishGenerator.dishes()).ofSizeBetween(0, 20);
	}	
}
