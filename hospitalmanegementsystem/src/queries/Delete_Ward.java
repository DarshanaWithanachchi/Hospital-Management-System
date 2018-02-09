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
public class Delete_Ward {
    
    public static boolean deleteDetailsOfWard(int id) {

        boolean message = false;

        DB_Operation data = new DB_Operation(); //get the connection
        Connection con = data.getConnection();

        String delete_query = "DELETE FROM ward WHERE idward ='" + id + "'";

        PreparedStatement stttt;
        try {
            stttt = con.prepareStatement(delete_query);
            stttt.execute();
            stttt.close();
            con.close();
            message = true;
        } catch (Exception ex) {
            Logger.getLogger(Delete_Ward.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
    
}
