package dhh.datastorage;

import dhh.domain.manageDish;
import java.sql.*;

public class DishDAO {
    Database db;
    
    public DishDAO(){
        db = new Database();
    }
    
    public ResultSet getDishOrders() {
        ResultSet dishData = null;
        
        Database db = new Database();
        
        if(db.openConnection()){ 
            //dhh_orderstatus.statusName en dhh_itemcategory.categoryName wordt nu niet gebruikt
            dishData = db.executeSelectionStatement("SELECT dhh_order.orderNo, dhh_table.tableNo, dhh_order.orderDatetime, dhh_item.itemName, dhh_orderitem.amount, dhh_orderitem.description, dhh_course.courseName, dhh_dish.preparation " +
            "FROM dhh_order " +
            "JOIN dhh_table ON dhh_table.tableNo = dhh_order.TABLEtableNo " +
            "JOIN dhh_orderitem ON dhh_orderitem.ORDERorderNo = dhh_order.orderNo " +
            "JOIN dhh_orderstatus ON dhh_orderstatus.statusName = dhh_orderitem.ORDERSTATUSstatusName " +
            "JOIN dhh_item ON dhh_item.itemName = dhh_orderitem.ITEMitemName " +
            "JOIN dhh_course ON dhh_course.courseName = dhh_item.COURSEcourseName " +
            "JOIN dhh_itemcategory ON dhh_itemcategory.categoryName = dhh_item.ITEMCATEGORYcategoryName " +
            "JOIN dhh_dish ON dhh_dish.ITEMitemName = dhh_item.itemName " +
            "WHERE dhh_orderstatus.statusName = UPPER('In behandeling') " +
            "ORDER BY dhh_order.orderNo ASC");
        }
        return dishData;
    }
    
    public ResultSet getDishes(){
        ResultSet dishData = null;
        
        if(db.openConnection()){ 
            dishData = db.executeSelectionStatement("SELECT i.itemName, i.price, i.description, c.courseName, ic.categoryName, d.preparation " +
            "FROM dhh_item i " +
            "JOIN dhh_course c ON c.courseName = i.COURSEcourseName " +
            "JOIN dhh_itemcategory ic ON ic.categoryName = i.ITEMCATEGORYcategoryName " +
            "JOIN dhh_dish d ON i.itemName = d.ITEMitemName " +
            "ORDER BY i.itemName ASC");
        }
        
        return dishData;
    }
    
    public ResultSet getCourses(){
        ResultSet courseData = null;
        
        if(db.openConnection()){ 
            courseData = db.executeSelectionStatement("SELECT dhh_course.courseName " +
            "FROM dhh_course " +
            "ORDER BY dhh_course.coursename DESC");
        }
        
        return courseData;
    }
    
    public ResultSet getCategories(){
        ResultSet categoryData = null;
        
        if(db.openConnection()){ 
            categoryData = db.executeSelectionStatement("SELECT dhh_itemcategory.categoryName " +
            "FROM dhh_itemcategory " +
            "ORDER BY dhh_itemcategory.categoryName DESC");
        }
        
        return categoryData;
    }
    
    public void readyDish(){
        if(db.openConnection()){
            //readyDishorder = db.executeUpdateStatement(null);
        
        }
        
    
    }
    
    public ResultSet getManageDishFromName(String dishName) {
        ResultSet result = null;
        
        if(db.openConnection()){ 
            result = db.executeSelectionStatement("SELECT i.itemName, i.price, i.description, c.courseName, ic.categoryName, d.preparation " +
            "FROM dhh_item i " +
            "JOIN dhh_course c ON c.courseName = i.COURSEcourseName " +
            "JOIN dhh_itemcategory ic ON ic.categoryName = i.ITEMCATEGORYcategoryName " +
            "JOIN dhh_dish d ON i.itemName = d.ITEMitemName " +
            "WHERE itemName = '" + dishName + "'");
        }
        
        return result;
    }
    
    public boolean updateDish(String oldDishName, manageDish currentDish){
        int result = 0;
        
        if(db.openConnection()){ 
            result += db.executeUpdateStatement("UPDATE dhh_item " +
            "SET itemName='" + currentDish.getName() + "', price='" + currentDish.getPrice() + "', description='" + currentDish.getDescription() + "', COURSEcourseName='" + currentDish.getCourse() + "', ITEMCATEGORYcategoryName='" + currentDish.getCategory() + "'" + 
            "WHERE itemName='" + oldDishName + "'");
            
            result += db.executeUpdateStatement("UPDATE dhh_dish " +
            "SET ITEMitemName='" + currentDish.getName() + "', preparation='" + currentDish.getPreparationTime() + "'" +
            "WHERE ITEMitemName='" + oldDishName + "'");
        }
        if(result == 2){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean insertDish(manageDish currentDish){
        int result = 0;
        
        if(db.openConnection()){ 
            result += db.executeInsertStatement("INSERT INTO dhh_item " +
            "(itemName, price, description, COURSEcourseName, ITEMCATEGORYcategoryName)" +
            "VALUES ('" + currentDish.getName() + "', '" + currentDish.getPrice() + "', '" + currentDish.getDescription() + "', '" + currentDish.getCourse() + "', '" + currentDish.getCategory() + "')");
        
            result += db.executeInsertStatement("INSERT INTO dhh_dish " +
            "(ITEMitemName, preparation)" +
            "VALUES ('" + currentDish.getName() + "', '" + currentDish.getPreparationTime() + "')");
        }
        if(result == 2){
            return true;
        } else {
            return false;
        }
    }
}
