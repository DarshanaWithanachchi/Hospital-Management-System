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

/**
 *
 * @author User
 */
public class Update_Payment {

    public boolean updatePayDetails(PaymentDetails upMaint, int id) {
        boolean success = false;

        DB_Operation data = new DB_Operation(); //get the connection
        Connection con = data.getConnection();

        String update_query = "update payment set doctorfee=(?),testfee=(?),treatmentfee=(?),hospitalfee=(?),totalfee=(?) WHERE idpatient='" + id + "' ";

        PreparedStatement stup;
        try {
            stup = con.prepareStatement(update_query);

            stup.setString(1, upMaint.getDoctorfee() + "");
            stup.setString(2, upMaint.getTestfee() + "");
            stup.setString(3, upMaint.getTreatmentfee() + "");
            stup.setString(4, upMaint.getHospitalfee() + "");
            stup.setString(5, upMaint.getTotalfee() + "");

            stup.executeUpdate();
            success = true;
            stup.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Update_Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
}
