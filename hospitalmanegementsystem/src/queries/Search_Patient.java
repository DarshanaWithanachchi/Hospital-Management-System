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
import object.PatientDetails;

/**
 *
 * @author User
 */
public class Search_Patient {

    public static PatientDetails sechPatientDetails(String nicno) {


        DB_Operation data2 = new DB_Operation(); //get the connection
        Connection con2 = data2.getConnection();

        String search_query = "SELECT nicno,idpatient,firstname,lastname,address,age,sex,contactno,admitdate,recomanddoctor,confirmdoctor FROM patient WHERE nicno = '" + nicno + "' ";

        PatientDetails pp = new PatientDetails();
        PreparedStatement stt;

        try {
            stt = data2.getConnection().prepareStatement(search_query);

            ResultSet rs = stt.executeQuery(search_query);

            if (rs.next()) {
                pp.setNicno(rs.getString(1));
                pp.setIdpatient(rs.getInt(2));
                pp.setFirstname(rs.getString(3));
                pp.setLastname(rs.getString(4));
                pp.setAddress(rs.getString(5));
                pp.setAge(rs.getInt(6));
                pp.setSex(rs.getString(7));
                pp.setContactno(rs.getInt(8));
                pp.setAdmitdate(rs.getInt(9));
                pp.setRecomanddoctor(rs.getString(10));
                pp.setConfirmdoctor(rs.getString(11));
               

                stt.executeQuery();
                stt.close();
                con2.close();


            }




        } catch (Exception ex) {
            Logger.getLogger(Search_Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pp;
    }
   
}
