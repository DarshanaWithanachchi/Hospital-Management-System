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
import object.NurseDetails;
import object.PatientDetails;

/**
 *
 * @author User
 */
public class Update_Nurse {

    public boolean updateNurseDetails(NurseDetails upMaint, String nic) {
        boolean success = false;

        DB_Operation data = new DB_Operation(); //get the connection
        Connection con = data.getConnection();

        String update_query = "update nurse set idward=(?),address=(?),contactno=(?) WHERE nicno='" + nic + "' ";

        PreparedStatement stup;
        try {
            stup = con.prepareStatement(update_query);

            stup.setString(1, upMaint.getIdward()+"");
            stup.setString(2, upMaint.getAddress());
            stup.setString(3, upMaint.getContactno() + "");
            
            stup.executeUpdate();
            success = true;
            stup.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Update_Nurse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
}
