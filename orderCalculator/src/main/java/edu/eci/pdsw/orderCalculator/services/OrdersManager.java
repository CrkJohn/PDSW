package edu.eci.pdsw.orderCalculator.services;

import java.util.LinkedList;
import java.util.List;

import com.google.inject.Inject;

import edu.eci.pdsw.orderCalculator.calculator.impl.BasicBillCalculator;
import edu.eci.pdsw.orderCalculator.calculator.BillCalculator;
import edu.eci.pdsw.orderCalculator.model.*;


public class OrdersManager {

    BillCalculator cal;
    List<Order> orders;

    
    @Inject
    public OrdersManager(BillCalculator cal) {
        orders = new LinkedList<Order>();
        this.cal = cal;
    }

    public void placeOrder(Order o) {
        orders.add(o);
    }

    public Order findOrder(int n) throws OrderCalculatorException {
        if (n >= orders.size()) {
            throw new OrderCalculatorException("Order not found");
        }
        return orders.get(n);
    }

    public int calculateOrderTotal(int n) throws OrderCalculatorException {
        if (n >= orders.size()){
            throw new OrderCalculatorException("Order not found");
        }
        return cal.calculatePrice(orders.get(n));
    }
}