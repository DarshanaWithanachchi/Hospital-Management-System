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
import object.PaymentDetails;
import object.WardDetails;

/**
 *
 * @author User
 */
public class Update_Ward {
    
    public boolean updateWardDetails(WardDetails upMaint, int id) {
        boolean success = false;

        DB_Operation data = new DB_Operation(); //get the connection
        Connection con = data.getConnection();

        String update_query = "update ward set headname=(?),doctorname=(?),iddoctor=(?),nonurse=(?),nototalbed=(?),nofreebed=(?) WHERE idward='" + id + "' ";

        PreparedStatement stup;
        try {
            stup = con.prepareStatement(update_query);

            stup.setString(1, upMaint.getHeadname());
            stup.setString(2, upMaint.getDoctorname());
            stup.setString(3, upMaint.getIddoctor() + "");
            stup.setString(4, upMaint.getNonurse() + "");
            stup.setString(5, upMaint.getNototalbed() + "");
            stup.setString(6, upMaint.getNofreebed() + "");

            stup.executeUpdate();
            success = true;
            stup.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Update_Ward.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
    
}
