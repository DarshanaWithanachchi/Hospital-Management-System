/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import db.DB_Operation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import object.DoctorDetails;
import object.WardDetails;

/**
 *
 * @author User
 */
public class Search_doctors {
    
    public static DoctorDetails sechdDoctorDetails(String nic) {


        DB_Operation data2 = new DB_Operation(); //get the connection
        java.sql.Connection con2 = data2.getConnection();

        String search_query = "SELECT firstname,lastname,nicno,address,sex,age,category,contactno FROM doctor WHERE nicno= '" + nic + "' ";
        DoctorDetails dd = new DoctorDetails();
        PreparedStatement stt;
        try {
            stt = data2.getConnection().prepareStatement(search_query);


            ResultSet rs = stt.executeQuery(search_query);

            if (rs.next()) {
                dd.setFirstname(rs.getString(1));
                dd.setLastname(rs.getString(2));
                dd.setNicno(rs.getString(3));
                dd.setAddress(rs.getString(4));
                dd.setSex(rs.getString(5));
                dd.setAge(rs.getInt(6));
                dd.setCategory(rs.getString(7));
                dd.setContactno(rs.getShort(8));


                stt.executeQuery();
                stt.close();
                con2.close();



            }

        } catch (Exception e) {
        }


        return dd;

    }
    
}
