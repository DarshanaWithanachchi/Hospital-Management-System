/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import db.DB_Operation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.NurseDetails;

/**
 *
 * @author User
 */
public class Search_Nurse {

    public static NurseDetails sechNurseDetails(String nic) {


        DB_Operation data2 = new DB_Operation(); //get the connection
        Connection con2 = data2.getConnection();

        String search_query = "SELECT idward,firstname,lastname,address,sex,age,contactno FROM nurse WHERE nicno = '" + nic + "' ";

        NurseDetails nd = new NurseDetails();
        PreparedStatement stt;

        try {
            stt = data2.getConnection().prepareStatement(search_query);

            ResultSet rs = stt.executeQuery(search_query);

            if (rs.next()) {
                nd.setIdward(rs.getInt(1));
                nd.setFirstname(rs.getString(2));
                nd.setLastname(rs.getString(3));
                nd.setAddress(rs.getString(4));
                nd.setSex(rs.getString(5));
                nd.setAge(rs.getInt(6));
                nd.setContactno(rs.getInt(7));


                stt.executeQuery();
                stt.close();
                con2.close();


            }




        } catch (Exception ex) {
            Logger.getLogger(Search_Nurse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nd;
    }
}
