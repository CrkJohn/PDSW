package edu.eci.pdsw.orderCalculator.model;

public class OrderCalculatorException extends Exception {

    public OrderCalculatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderCalculatorException(String message) {
        super(message);
    }
}