package dhh.datastorage;

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
            dishData = db.executeSelectionStatement("SELECT dhh_dish.ITEMitemName, dhh_dish.Preparation " +
            "FROM dhh_dish " +
            "ORDER BY dhh_dish.ITEMitemName ASC");
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
    
    public boolean updateDish(String name, Time preparationTime, String course){
        int result = 0;
        
        if(db.openConnection()){ 
            /*result = db.executeUpdateStatement("UPDATE dhh_dish " +
            "SET ITEMitemName='" + name + "', Preparation='" + preparationTime + "'" +
            "WHERE ITEMitemName='" + name + "'");*/
        }
        
        if(result > 0){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean insertDish(String name, Time preparationTime, String course){
        int result = 0;
        
        if(db.openConnection()){ 
            /*result = db.executeInsertStatement("INSERT INTO dhh_dish (ITEMitemName, Preparation)" +
            "VALUES ('" + name + "', '" + preparationTime + "')");*/
            
            System.out.println(result);
        }
        if(result > 0){
            return true;
        } else {
            return false;
        }
    }
}
