package edu.eci.pdsw.orderCalculator.services;

import com.google.inject.AbstractModule;

import edu.eci.pdsw.orderCalculator.calculator.BillCalculator;
import edu.eci.pdsw.orderCalculator.calculator.impl.BasicBillCalculator;
import edu.eci.pdsw.orderCalculator.calculator.impl.StandardTaxValidator;
import edu.eci.pdsw.orderCalculator.calculator.impl.TaxBillCalculator;
import edu.eci.pdsw.orderCalculator.calculator.impl.TaxValidator;
import edu.eci.pdsw.orderCalculator.calculator.impl.TipBillCalculator;

public class Modulo extends AbstractModule{
	
	@Override 
	protected void configure() {
		bind(OrdersManager.class);
		bind(BillCalculator.class).to(BasicBillCalculator.class);	
		bind(TaxValidator.class).to(StandardTaxValidator.class);
	}
}
