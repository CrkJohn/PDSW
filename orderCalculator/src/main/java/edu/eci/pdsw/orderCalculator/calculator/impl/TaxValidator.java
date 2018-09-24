package edu.eci.pdsw.orderCalculator.calculator.impl;

import edu.eci.pdsw.orderCalculator.model.*;

public interface TaxValidator {
	public double getPercentage(Dish d);
}