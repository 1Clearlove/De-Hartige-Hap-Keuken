package dhh.domain;

import java.util.ArrayList;

public class Beverage {
    private String name;
    private double price;
    private ArrayList<String> ingredients;
    private double alcoholPercentage;
    
    public Beverage(String name, double price, double alcoholPercentage) {
        this.name = name;
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getName() {
        return name;
    }
}
