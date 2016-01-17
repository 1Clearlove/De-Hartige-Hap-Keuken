package dhh.domain;

public class Dish {
    private String name;
    private int amount;
    private String comment;
    
    public Dish (String name, int amount, String comment) {
        this.name = name;
        this.amount = amount;
        this.comment = comment;
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
}
