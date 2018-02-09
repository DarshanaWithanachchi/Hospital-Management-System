/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import com.sun.jndi.ldap.Connection;
import db.DB_Operation;
import object.WardDetails;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author User
 */
public class Search_Ward {

    public static WardDetails sechWardDetails(int id) {


        DB_Operation data2 = new DB_Operation(); //get the connection
        java.sql.Connection con2 = data2.getConnection();

        String search_query = "SELECT idward,headname,doctorname,iddoctor,nonurse,nopatient,nototalbed,nofreebed FROM ward WHERE idward= '" + id + "' ";
        WardDetails wd = new WardDetails();
        PreparedStatement stt;
        try {
            stt = data2.getConnection().prepareStatement(search_query);


            ResultSet rs = stt.executeQuery(search_query);

            if (rs.next()) {
                wd.setIdward(rs.getInt(1));
                wd.setHeadname(rs.getString(2));
                wd.setDoctorname(rs.getString(3));
                wd.setIddoctor(rs.getInt(4));
                wd.setNonurse(rs.getInt(5));
                wd.setNopatient(rs.getInt(6));
                wd.setNototalbed(rs.getInt(7));
                wd.setNofreebed(rs.getInt(8));


                stt.executeQuery();
                stt.close();
                con2.close();



            }

        } catch (Exception e) {
        }


        return wd;

    }
}
