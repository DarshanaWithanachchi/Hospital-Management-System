/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import object.TretmentDetails;

/**
 *
 * @author User
 */
public class DBOperationTretment {

    String url = "jdbc:mysql://localhost:3306/hdb";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    private Component frame = new JFrame();

    boolean addTretment(TretmentDetails td) {
        try {
            con = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO tretment(idtest,patientname,idpatient,doctor,tretment)VALUES('" + td.getIdtest() + "','" + td.getPaientname() + "','" +td.getIdpatient() + "','" + td.getDoctor() + "','"+ td.getTretment()+"')";
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.execute();
            
            
            return true;
            
        } catch (Exception e) {
              JOptionPane.showMessageDialog(frame, e);
              return false;
        }finally{
            try {
                 if(con != null){
                    con.close();
                }
            } catch (Exception e) {
            }
        }

    }
}
