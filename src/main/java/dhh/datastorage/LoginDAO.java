
package dhh.datastorage;

import java.sql.*;

public class LoginDAO {
    public ResultSet Login(String email) {
        ResultSet cdLogin = null;
        
        Database db = new Database();
        db.openConnection();
        if(db.openConnection()){            
            cdLogin = db.executeSelectionStatement("SELECT dhh_employee.email " +
            "FROM dhh_employee " +
            "JOIN dhh_employeefunction ON dhh_employee.EMPLOYEEFUNCTIONfunctionName = dhh_employeefunction.functionName " +
            "WHERE dhh_employeefunction.functionName = 'Chef-kok' " +
            "AND dhh_employee.email = '" + email + "'");
        }
        return cdLogin;
    }
}
