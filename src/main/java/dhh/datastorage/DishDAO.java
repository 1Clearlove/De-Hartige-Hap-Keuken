package dhh.datastorage;

import java.sql.*;

public class DishDAO {
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
        
        Database db = new Database();
        
        if(db.openConnection()){ 
            dishData = db.executeSelectionStatement("SELECT dhh_dish.ITEMitemName, dhh_dish.Preparation " +
            "FROM dhh_dish " +
            "ORDER BY dhh_dish.ITEMitemName ASC");
        }
        
        return dishData;
    }
    
    public void readyDish(){
    
        Database db = new Database();
        db.openConnection();
        if(db.openConnection()){
            //readyDishorder = db.executeUpdateStatement(null);
        
        }
        
    
    }
    
}
