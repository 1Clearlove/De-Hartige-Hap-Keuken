package dhh.BusinessLogic;

import dhh.DataStorage.DishDAO;
import dhh.Domain.Dish;
import dhh.Domain.Order;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderManager {
    public ArrayList generateDishOrderList() {
        ArrayList<Order> orderList = new ArrayList<>();
        
        DishDAO dishDAO = new DishDAO();
        ResultSet queryResult = dishDAO.getDishOrders();
        
        
        try {
            queryResult.first(); //Go to the first row in the query result
            Order currentOrder = new Order(queryResult.getInt(1), queryResult.getInt(2)); //Create an order for the first row in the query result
            
            queryResult.beforeFirst(); //Set the query result back to before the first row
            while(queryResult.next()) { //Loop through all rows in the query result
                if(currentOrder.getOrderNumber() != queryResult.getInt(1)) { //If the current order number differs from the order number in the current row in the query result
                    orderList.add(currentOrder);
                    currentOrder = new Order(queryResult.getInt(1), queryResult.getInt(2));
                }
                
                Dish currentDish = new Dish(queryResult.getString(4), queryResult.getInt(5), queryResult.getString(6)); //Add the dish with it's attributes
                
                currentOrder.addDish(currentDish);
            }
            orderList.add(currentOrder);
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        return orderList;
    }
}
