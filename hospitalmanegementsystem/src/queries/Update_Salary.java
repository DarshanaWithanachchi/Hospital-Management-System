/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import db.DB_Operation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.SalaryDetails;

/**
 *
 * @author User
 */
public class Update_Salary {

    public boolean UpdateSalaryDetails(SalaryDetails upMaint, int id) {
        boolean success = false;
        DB_Operation data = new DB_Operation(); //get the connection
        Connection con = data.getConnection();

        String update_query = "update salary set basicsalary=(?),ot=(?),idattendents=(?),totalsalary=(?) WHERE idemployee='" + id + "' ";

        PreparedStatement stup;
        try {
            stup = con.prepareStatement(update_query);

            stup.setString(1, upMaint.getBasicsalary()+"");
            stup.setString(2, upMaint.getOt()+"");
            stup.setString(3, upMaint.getIdattendents() + "");
            stup.setString(4, upMaint.getTotalsalary() + "");
        

            stup.executeUpdate();
            success = true;
            stup.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Update_Salary.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }

}
