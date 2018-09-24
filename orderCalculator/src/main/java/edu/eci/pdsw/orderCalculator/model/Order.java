package edu.eci.pdsw.orderCalculator.model;

import java.util.LinkedList;
import java.util.List;

public class Order {
    List<Dish> dishes;

    public Order() {
        dishes = new LinkedList<Dish>();
    }

    public void addDish(Dish d) {
        dishes.add(d);
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public String toString(){
        return dishes.toString();
    }
}