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
public class Delete_Patient {
    
    public static boolean deleteDetailsOfPatient(String nic) {

        boolean message = false;

        DB_Operation data = new DB_Operation(); //get the connection
        Connection con = data.getConnection();

        String delete_query = "DELETE FROM patient WHERE nicno ='" + nic + "'";

        PreparedStatement stttt;
        try {
            stttt = con.prepareStatement(delete_query);
            stttt.execute();
            stttt.close();
            con.close();
            message = true;
        } catch (Exception ex) {
            Logger.getLogger(Delete_Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
}
