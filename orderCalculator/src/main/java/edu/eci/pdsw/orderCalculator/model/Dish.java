package edu.eci.pdsw.orderCalculator.model;

public class Dish {
    private DishType type;
    private int price;
    private String name;

    public Dish(DishType type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public DishType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}