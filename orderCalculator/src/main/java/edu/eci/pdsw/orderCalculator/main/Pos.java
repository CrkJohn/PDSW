package edu.eci.pdsw.orderCalculator.main;

import java.util.LinkedList;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import edu.eci.pdsw.orderCalculator.calculator.impl.BasicBillCalculator;
import edu.eci.pdsw.orderCalculator.calculator.BillCalculator;
import edu.eci.pdsw.orderCalculator.model.*;
import edu.eci.pdsw.orderCalculator.services.Modulo;
import edu.eci.pdsw.orderCalculator.services.OrdersManager;

public class Pos {

    public static void main(String a[]) throws OrderCalculatorException {
    	Injector guice = Guice.createInjector(new Modulo());
        OrdersManager manager = guice.getInstance(OrdersManager.class);
        loadOrders(manager);
        System.out.println(manager.calculateOrderTotal(0));
        System.out.println(manager.calculateOrderTotal(1));
    }

    private static void loadOrders(OrdersManager manager) {

        Order o = new Order();
        o.addDish(new Dish(DishType.PLATE, "pizza", 7500));
        o.addDish(new Dish(DishType.DRINK, "pepsi 300ml", 3900));
        o.addDish(new Dish(DishType.PLATE, "hamburguesa", 8000));
        o.addDish(new Dish(DishType.DRINK, "sprite 300ml", 2000));

        manager.placeOrder(o);
        o = new Order();
        o.addDish(new Dish(DishType.PLATE, "pizza", 7500));
        o.addDish(new Dish(DishType.PLATE, "pizza", 7500));
        o.addDish(new Dish(DishType.PLATE, "pizza", 7500));
        o.addDish(new Dish(DishType.DRINK, "pepsi litro", 5000));
        manager.placeOrder(o);
    }
}