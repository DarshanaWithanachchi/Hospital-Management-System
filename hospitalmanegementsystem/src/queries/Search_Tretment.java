/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import db.DB_Operation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import object.PaymentDetails;
import object.TretmentDetails;

/**
 *
 * @author User
 */
public class Search_Tretment {

    public static TretmentDetails sechTretmentDetails(int id) {

        DB_Operation data2 = new DB_Operation(); //get the connection
        Connection con2 = data2.getConnection();

        String search_query = "SELECT patientname,idtest,idpatient,doctor,tretment FROM tretment WHERE idpatient= '" + id + "' ";

        TretmentDetails td = new TretmentDetails();
        PreparedStatement stt;

        try {
            stt = data2.getConnection().prepareStatement(search_query);


            ResultSet rs = stt.executeQuery(search_query);

            if (rs.next()) {
                td.setPaientname(rs.getString(1));
                td.setIdtest(rs.getInt(2));
                td.setIdpatient(rs.getInt(3));
                td.setDoctor(rs.getString(4));
                td.setTretment(rs.getString(5));


            }
        } catch (Exception e) {
        }
        return td;
    }
}
