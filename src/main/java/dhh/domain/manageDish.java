package dhh.domain;

import java.sql.Time;

public class manageDish {
    private String name;
    private double price;
    private String description;
    private String course;
    private String category;
    private Time preparationTime;
    
    public manageDish (String name, double price, String description, String course, String category, Time preparationTime) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.course = course;
        this.category = category;
        this.preparationTime = preparationTime;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getCategory() {
        return category;
    }
    
    public String getCourse() {
        return course;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Time getPreparationTime() {
        return preparationTime;
    }
}
