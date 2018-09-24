package edu.eci.pdsw.orderCalculator;

import static org.junit.Assert.*;
import static org.quicktheories.QuickTheory.qt;

import java.util.List;

import org.junit.Test;

import com.google.inject.Guice;

import edu.eci.pdsw.ManagerGenerator;
import edu.eci.pdsw.OrderGenerator;
import edu.eci.pdsw.PBTClassifier;
import edu.eci.pdsw.orderCalculator.calculator.impl.BasicBillCalculator;
import edu.eci.pdsw.orderCalculator.model.Dish;
import edu.eci.pdsw.orderCalculator.services.Modulo;
import edu.eci.pdsw.orderCalculator.services.OrdersManager;

public class OrdersManagerTest {

	@Test
	public void test() {
BasicBillCalculator basicBillCal = new BasicBillCalculator();
		
		PBTClassifier pbtClassifier = new PBTClassifier("checkBasicBillCalculator");
		pbtClassifier.declare("CORRECT").declare("INCORRECT");
		
		qt().forAll(OrderGenerator.orders()).check( order ->{
			BasicBillCalculator bbcal = Guice.createInjector(new Modulo()).getInstance(BasicBillCalculator.class);
			int amountTotal = bbcal.calculatePrice(order);
			
			List<Dish> dishes = order.getDishes();
			int amountExpected = 0;
			for(Dish d : dishes) {
				amountExpected += d.getPrice();
			}
			if(amountTotal==amountExpected) {
				pbtClassifier.collect("CORRECT");
				return true;
			}
			pbtClassifier.collect("INCORRECT");
			return false;
		});
	}
}
