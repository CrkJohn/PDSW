package edu.eci.pdsw.orderCalculator.calculator.impl;

import edu.eci.pdsw.orderCalculator.calculator.BillCalculator;
import edu.eci.pdsw.orderCalculator.model.*;


public class TipBillCalculator implements  BillCalculator{

	public int calculatePrice(Order o) {
        int total=0;
        for (Dish p : o.getDishes()){
            total += p.getPrice();
        }
        if(total>=15000) {
        	total+= (int)((double)total*0.10);
        }
        return total;
    }
}
