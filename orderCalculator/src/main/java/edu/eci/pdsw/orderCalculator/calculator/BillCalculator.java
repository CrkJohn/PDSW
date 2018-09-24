package edu.eci.pdsw.orderCalculator.calculator;
import edu.eci.pdsw.orderCalculator.model.Order;


public interface BillCalculator {
	public int calculatePrice(Order o);
}
