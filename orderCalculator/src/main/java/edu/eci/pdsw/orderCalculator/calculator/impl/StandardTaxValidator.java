package edu.eci.pdsw.orderCalculator.calculator.impl;

import edu.eci.pdsw.orderCalculator.model.*;
 
public class StandardTaxValidator implements TaxValidator {

	public double getPercentage(Dish d) {
		return (double) ((d.getType()==DishType.DRINK) ? 0.0 :  0.19);
	}
	
}
