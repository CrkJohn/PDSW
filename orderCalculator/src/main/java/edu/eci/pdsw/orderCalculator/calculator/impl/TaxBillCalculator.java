package edu.eci.pdsw.orderCalculator.calculator.impl;

import com.google.inject.Inject;

import edu.eci.pdsw.orderCalculator.calculator.BillCalculator;
import edu.eci.pdsw.orderCalculator.model.Dish;
import edu.eci.pdsw.orderCalculator.model.DishType;
import edu.eci.pdsw.orderCalculator.model.Order;

public class TaxBillCalculator implements  BillCalculator{
	
	TaxValidator taxValidator;
	
	@Inject
	public TaxBillCalculator(TaxValidator taxValidator){
		this.taxValidator = taxValidator;
	}
	
	public int calculatePrice(Order o) {
        int totalPlate=0;
        for (Dish p : o.getDishes()){
        	totalPlate += p.getPrice() + (p.getPrice()*taxValidator.getPercentage(p));
        }        
        return totalPlate;
    }
}
