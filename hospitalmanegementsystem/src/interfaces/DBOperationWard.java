/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import object.WardDetails;

/**
 *
 * @author User
 */
public class DBOperationWard {

    String url = "jdbc:mysql://localhost:3306/hdb";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    private Component frame = new JFrame();

    boolean addWard(WardDetails wd) {
        try {
            con = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO ward(headname,doctorname,iddoctor,nonurse,nopatient,nototalbed,nofreebed)VALUES('" +wd.getHeadname() + "','" +wd.getDoctorname() + "','" + wd.getIddoctor() + "','" + wd.getNonurse() + "','" + wd.getNopatient() + "','" + wd.getNototalbed() + "','" + wd.getNofreebed() + "')";
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.execute();

            return  true;
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
