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
}
