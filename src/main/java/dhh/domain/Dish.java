package dhh.domain;

import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Dish {
    private String name;
    private int amount;
    private String comment;
    private Timestamp orderdate;
    
    private ArrayList<Ingredient> ingredients;
    
    public Dish (String name, int amount, String comment, Timestamp orderdate) {
        this.name = name;
        this.amount = amount;
        this.comment = comment;
        this.orderdate = orderdate;
        
        ingredients = new ArrayList<>();
    }
    
    public void addIngredient(Ingredient currentIngredient) {
        ingredients.add(currentIngredient);
    }
    
    public String getName() {
        return name;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public String getComment() {
        return comment;
    }

    public String getOrderTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String stringRepresentation = sdf.format(orderdate);
        return stringRepresentation;
    }
}
