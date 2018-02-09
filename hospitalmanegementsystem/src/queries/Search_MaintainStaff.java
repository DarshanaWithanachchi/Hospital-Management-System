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
import object.MaintainStaffDetails;
import object.NurseDetails;

/**
 *
 * @author User
 */
public class Search_MaintainStaff {

    public static MaintainStaffDetails sechMaintainStaffDetails(String nic) {


        DB_Operation data2 = new DB_Operation(); //get the connection
        Connection con2 = data2.getConnection();

        String search_query = "SELECT firstname,lastname,address,sex,age,contactno FROM maintainstaff WHERE nicno = '" + nic + "' ";

        MaintainStaffDetails md = new MaintainStaffDetails();
        PreparedStatement stt;

        try {
            stt = data2.getConnection().prepareStatement(search_query);

            ResultSet rs = stt.executeQuery(search_query);

            if (rs.next()) {
                md.setFirstname(rs.getString(1));
                md.setLastname(rs.getString(2));
                md.setAddress(rs.getString(3));
                md.setSex(rs.getString(4));
                md.setAge(rs.getInt(5));
                md.setContactno(rs.getInt(6));


                stt.executeQuery();
                stt.close();
                con2.close();


            }




        } catch (Exception ex) {
            Logger.getLogger(Search_MaintainStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return md;
    }
}
