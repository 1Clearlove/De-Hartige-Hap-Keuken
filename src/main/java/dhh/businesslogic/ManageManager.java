package dhh.businesslogic;

import dhh.datastorage.DishDAO;
import dhh.domain.manageDish;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ManageManager {   
    public ArrayList getDishes() {
        ArrayList<manageDish> dishList = new ArrayList<>();
        
        DishDAO dishDAO = new DishDAO();
        ResultSet queryResult = dishDAO.getDishes();
        
        try {
            while(queryResult.next()) { //Loop through all rows in the query result
                dishList.add(new manageDish(queryResult.getString(1), queryResult.getTime(2)));
            }
        }        
        
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return dishList;
    }
    
    public ArrayList getCourses() {
        ArrayList<String> courseList = new ArrayList<>();
        
        DishDAO dishDAO = new DishDAO();
        ResultSet queryResult = dishDAO.getCourses();
        
        try {
            while(queryResult.next()) { //Loop through all rows in the query result
                courseList.add(queryResult.getString(1));
            }
        }        
        
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return courseList;
    }
    
    public ArrayList getCategories() {
        ArrayList<String> categoryList = new ArrayList<>();
        
        DishDAO dishDAO = new DishDAO();
        ResultSet queryResult = dishDAO.getCategories();
        
        try {
            while(queryResult.next()) { //Loop through all rows in the query result
                categoryList.add(queryResult.getString(1));
            }
        }        
        
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return categoryList;
    }
    
    
    public boolean updateDish(manageDish currentDish){
        DishDAO dishDAO = new DishDAO();
        return dishDAO.updateDish(currentDish.getName(), currentDish.getPreparationTime(), currentDish.getCourse());
    }
    
    public boolean insertDish(manageDish currentDish){
        DishDAO dishDAO = new DishDAO();
        return dishDAO.insertDish(currentDish.getName(), currentDish.getPreparationTime(), currentDish.getCourse());
    }
}
