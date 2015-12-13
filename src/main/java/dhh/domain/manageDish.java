package dhh.domain;

import java.sql.Time;

public class manageDish {
    private String name;
    private String course;
    private Time preparationTime;
    
    public manageDish (String name, Time preparationTime) {
        this.name = name;
        this.preparationTime = preparationTime;
    }
    
    public String getName() {
        return name;
    }
    
    public Time getPreparationTime() {
        return preparationTime;
    }
    
    public String getCourse() {
        return course;
    }
}
