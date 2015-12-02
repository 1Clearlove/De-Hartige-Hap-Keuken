package dhh.BusinessLogic;

import dhh.DataStorage.Login;
import java.sql.*;
import java.util.*;

public class LoginManager {
    
    public String checkLogin(String email){
        
        String cLogin = "";
        Login login = new Login();
        ResultSet queryLogin = login.Login(email);
        try{
            while(queryLogin.next()) { //Loop through all rows in the query result
                cLogin = queryLogin.getString(1);
            }

        }catch(Exception e){
        
        
        }
        
        return cLogin;
        
    }
}
