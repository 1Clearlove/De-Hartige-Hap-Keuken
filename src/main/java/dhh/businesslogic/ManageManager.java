package dhh.businesslogic;

import dhh.datastorage.DishDAO;
import dhh.domain.Ingredient;
import dhh.domain.manageDish;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ManageManager {   
    public ArrayList getDishes() {
        ArrayList<manageDish> dishList = new ArrayList<>();
        
        DishDAO dishDAO = new DishDAO();
        ResultSet dishData = dishDAO.getDishes();
        
        try {
            while(dishData.next()) { //Loop through all rows in the query result
                dishList.add(new manageDish(dishData.getString(1), dishData.getDouble(2), dishData.getString(3), dishData.getString(4), dishData.getString(5), dishData.getTime(6)));
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
    
    public manageDish getManageDishFromName(String dishName) {
        DishDAO dishDAO = new DishDAO();
        ResultSet dishData = dishDAO.getManageDishFromName(dishName);
        
        manageDish currentDish = null;
        
        try {
            dishData.first();
            currentDish = new manageDish(dishData.getString(1), dishData.getDouble(2), dishData.getString(3), dishData.getString(4), dishData.getString(5), dishData.getTime(6));
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return currentDish;
    }
    
    public ArrayList<Ingredient> getIngredients(String dishName){
        DishDAO dishDAO = new DishDAO();
        ResultSet dishData = dishDAO.getIngredients(dishName);
        
        ArrayList<Ingredient> ingredientsList = new ArrayList<>();
        
        try {
            while(dishData.next()) { //Loop through all rows in the query result
                ingredientsList.add(new Ingredient(dishData.getString(1), dishData.getDouble(2), dishData.getString(3)));
            }
        }        
        
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return ingredientsList;
    }
    
    public boolean updateDish(String oldDishName, manageDish currentDish){
        DishDAO dishDAO = new DishDAO();
        return dishDAO.updateDish(oldDishName, currentDish);
    }
    
    public boolean insertDish(manageDish currentDish){
        DishDAO dishDAO = new DishDAO();
        return dishDAO.insertDish(currentDish);
    }
}
