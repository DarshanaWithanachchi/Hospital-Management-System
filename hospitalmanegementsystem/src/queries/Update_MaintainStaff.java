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

/**
 *
 * @author User
 */
public class Update_MaintainStaff {

    public boolean updateMaintainStaffDetails(NurseDetails upMaint, String nic) {
        boolean success = false;

        DB_Operation data = new DB_Operation(); //get the connection
        Connection con = data.getConnection();

        String update_query = "update maintainstaff set address=(?),contactno=(?) WHERE nicno='" + nic + "' ";

        PreparedStatement stup;
        try {
            stup = con.prepareStatement(update_query);

            stup.setString(1, upMaint.getAddress());
            stup.setString(2, upMaint.getContactno() + "");

            stup.executeUpdate();
            success = true;
            stup.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Update_MaintainStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
}
