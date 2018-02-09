/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import db.DB_Operation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.DoctorDetails;

/**
 *
 * @author User
 */
public class Search_Doctor {

    public static DoctorDetails sechDoctorDetails(String name) {

        DB_Operation data2 = new DB_Operation(); //get the connection
        //Connection con2 = data2.getConnection();

        String search_query = "SELECT iddoctor,firstname,lastname,address,sex,age,category,contactno FROM doctor WHERE firstname= '" + name + "' ";
        DoctorDetails doc = new DoctorDetails();
        PreparedStatement view;
        try {

            view = data2.getConnection().prepareStatement(search_query);


            ResultSet rs = view.executeQuery(search_query);

            if (rs.next()) {
                doc.setIddoctor(rs.getInt(1));
                doc.setFirstname(rs.getString(2));
                doc.setLastname(rs.getString(3));
                doc.setAddress(rs.getString(4));
                doc.setSex(rs.getString(5));
                doc.setAge(rs.getInt(6));
                doc.setCategory(rs.getString(7));
                doc.setContactno(rs.getInt(8));



            }
            view.executeQuery();
            view.close();
            //con2.close();


        } catch (Exception ex) {
            Logger.getLogger(Search_Payment.class.getName()).log(Level.SEVERE, null, ex);
        }




        return doc;

    }
}
