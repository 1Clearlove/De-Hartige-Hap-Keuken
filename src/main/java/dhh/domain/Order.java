package dhh.domain;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private Date orderDate;
    private int tableNumber;
    private int orderNumber;
    
    private ArrayList<Dish> dishes;
    
    public Order(int tableNumber, int orderNumber) {
        this.orderNumber = orderNumber;
        this.tableNumber = tableNumber;
        dishes = new ArrayList<>();
        orderDate = new Date();
    }
    
    public void addDish(Dish currentDish) {
        dishes.add(currentDish);
    }
    
    public ArrayList<Dish> getDishes() {
        return dishes;
    }
    
    public int getTableNumber() {
        return tableNumber;
    }
    
    public int getOrderNumber() {
        return orderNumber;
    }
}
