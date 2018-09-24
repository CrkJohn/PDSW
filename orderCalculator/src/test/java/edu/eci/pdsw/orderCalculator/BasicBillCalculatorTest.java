package edu.eci.pdsw.orderCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.inject.Guice;

import edu.eci.pdsw.OrderGenerator;
import edu.eci.pdsw.PBTClassifier;
import edu.eci.pdsw.orderCalculator.calculator.impl.*;
import edu.eci.pdsw.orderCalculator.model.Dish;
import edu.eci.pdsw.orderCalculator.services.Modulo;
import edu.eci.pdsw.orderCalculator.services.OrdersManager;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.*;

import java.util.*;

public class BasicBillCalculatorTest {

	@Test
	public void test() {
		
		PBTClassifier pbtClassifier = new PBTClassifier("checkBasicBillCalculator");
		pbtClassifier.declare("CORRECT PRICE").declare("INCORRECT PRICE");
		
		qt().forAll(OrderGenerator.orders()).check( order ->{
			BasicBillCalculator bbcal = Guice.createInjector(new Modulo()).getInstance(BasicBillCalculator.class);
			int amountTotal = bbcal.calculatePrice(order);
			
			List<Dish> dishes = order.getDishes();
			int amountExpected = 0;
			for(Dish d : dishes) {
				amountExpected += d.getPrice();
			}
			if(amountTotal==amountExpected) {
				pbtClassifier.collect("CORRECT PRICE");
				return true;
			}
			pbtClassifier.collect("INCORRECT PRICE");
			return false;
		});
	}
}