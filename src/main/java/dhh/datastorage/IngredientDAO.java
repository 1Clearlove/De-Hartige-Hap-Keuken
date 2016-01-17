package dhh.datastorage;

import java.sql.ResultSet;

public class IngredientDAO {
    Database db;
    
    public IngredientDAO(){
        db = new Database();
    }
    
    public ResultSet getAllIngredients(){
        ResultSet ingredientData = null;
        
        if(db.openConnection()){ 
            ingredientData = db.executeSelectionStatement("SELECT ingredientName, measurement FROM dhh_ingredient");
        }
        
        return ingredientData;
    }
}
