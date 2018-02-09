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
import object.PatientDetails;
import object.PaymentDetails;

/**
 *
 * @author User
 */
public class Update_Patient {

    public boolean updatePayDetails(PatientDetails upMaint, String nic) {
        boolean success = false;

        DB_Operation data = new DB_Operation(); //get the connection
        Connection con = data.getConnection();

        String update_query = "update patient set address=(?),age=(?),contactno=(?),admitdate=(?),recomanddoctor=(?),confirmdoctor=(?) WHERE nicno='" + nic + "' ";

        PreparedStatement stup;
        try {
            stup = con.prepareStatement(update_query);

            stup.setString(1, upMaint.getAddress());
            stup.setString(2, upMaint.getAge() + "");
            stup.setString(3, upMaint.getContactno() + "");
            stup.setString(4, upMaint.getAdmitdate() + "");
            stup.setString(5, upMaint.getRecomanddoctor() );
            stup.setString(6, upMaint.getConfirmdoctor());

            stup.executeUpdate();
            success = true;
            stup.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Update_Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
}
