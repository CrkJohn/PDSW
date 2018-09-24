package edu.eci.pdsw.orderCalculator.calculator.impl;

import edu.eci.pdsw.orderCalculator.model.*;

public class SpecialRegimeTaxValidator implements TaxValidator{

	public double getPercentage(Dish d) {
		return (double) ((d.getType()==DishType.DRINK) ? 0.29 :  0.19);
	}
	
}
