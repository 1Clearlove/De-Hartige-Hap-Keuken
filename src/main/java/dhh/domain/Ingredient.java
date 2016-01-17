package dhh.domain;

public class Ingredient {
    private String ingredientName;
    private String measurement;
    private double amount;
    
    public Ingredient (String ingredientName, double amount, String measurement){
        this.ingredientName = ingredientName;
        this.measurement = measurement;
        this.amount = amount;
    }
    
    public String getName() {
        return ingredientName;
    }
    
    public String getMeasurement() {
        return measurement;
    }
    
    public double getAmount() {
        return amount;
    }
}
