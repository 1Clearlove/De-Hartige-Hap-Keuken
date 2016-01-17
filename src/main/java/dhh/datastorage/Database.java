package dhh.datastorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database {
    Connection con = null;
    PreparedStatement currentStatement = null;
    ResultSet result = null;
   
    String url = "jdbc:mysql://145.48.6.147:3306/ivp4a";
    String user = "root";
    String password = "10ec4u";
    
    public Database(){
        result = null;
    }
    
    public boolean openConnection() {
        try {
            con = DriverManager.getConnection(url, user, password);
            if(con != null)
                return true;
            else
                return false; 
        } 
        
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public void closeConnection() {
        try {
            con.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public ResultSet executeSelectionStatement(String query) {
        try {
            currentStatement = con.prepareStatement(query);
            result = currentStatement.executeQuery();  
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return result;
    }
    
    public int executeInsertStatement(String query) {
        int result = 0;
        
        try {
            currentStatement = con.prepareStatement(query);
            result = currentStatement.executeUpdate();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return result;
    }
    
    public int executeUpdateStatement(String query) {
        int result = 0;
        
        try {
            currentStatement = con.prepareStatement(query);
            result = currentStatement.executeUpdate();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return result;
    }
    
    public ResultSet executeDeleteStatement(String query) {
        try {
            currentStatement = con.prepareStatement(query);
            result = currentStatement.executeQuery();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return result;
    }
}
