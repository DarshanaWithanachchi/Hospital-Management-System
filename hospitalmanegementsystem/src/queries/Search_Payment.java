  /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import db.DB_Operation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.PaymentDetails;

/**
 *
 * @author User
 */
public class Search_Payment {

    public static PaymentDetails sechPayment(int id) {



        DB_Operation data2 = new DB_Operation(); //get the connection
        Connection con2 = data2.getConnection();

        String search_query = "SELECT idpayment,patientname,idpatient,doctorfee,testfee,treatmentfee,hospitalfee,totalfee,date FROM payment WHERE idpatient= '" + id + "' ";

        PaymentDetails pay = new PaymentDetails();
        PreparedStatement stt;
        try {

            stt = data2.getConnection().prepareStatement(search_query);


            ResultSet rs = stt.executeQuery(search_query);

            if (rs.next()) {
                pay.setIdpayment(rs.getInt(1));
                pay.setPatientname(rs.getString(2));
                pay.setIdpatient(rs.getInt(3));
                pay.setDoctorfee(rs.getInt(4));
                pay.setTestfee(rs.getInt(5));
                pay.setTreatmentfee(rs.getInt(6));
                pay.setHospitalfee(rs.getInt(7));
                pay.setTotalfee(rs.getInt(8));
                pay.setDate(rs.getInt(9));


            }
            stt.executeQuery();
            stt.close();
            con2.close();


        } catch (Exception ex) {
            Logger.getLogger(Search_Payment.class.getName()).log(Level.SEVERE, null, ex);
        }




        return pay;

    }
}
