package dhh.businesslogic;

import dhh.datastorage.LoginDAO;
import java.sql.ResultSet;

public class LoginManager {
    
    public String checkLogin(String email){
        
        String cLogin = "";
        LoginDAO login = new LoginDAO();
        ResultSet queryLogin = login.Login(email);
        try{
            while(queryLogin.next()) { //Loop through all rows in the query result
                cLogin = queryLogin.getString(1);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return cLogin;
        
    }
}
