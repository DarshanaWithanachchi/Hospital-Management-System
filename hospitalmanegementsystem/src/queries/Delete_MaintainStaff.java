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

/**
 *
 * @author User
 */
public class Delete_MaintainStaff {
     public static boolean deleteDetailsOfMaintainStaff(String nic) {

        boolean message = false;

        DB_Operation data = new DB_Operation(); //get the connection
        Connection con = data.getConnection();

        String delete_query = "DELETE FROM maintainstaff WHERE nicno ='" + nic + "'";

        PreparedStatement stttt;
        try {
            stttt = con.prepareStatement(delete_query);
            stttt.execute();
            stttt.close();
            con.close();
            message = true;
        } catch (Exception ex) {
            Logger.getLogger(Delete_MaintainStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
    
}
