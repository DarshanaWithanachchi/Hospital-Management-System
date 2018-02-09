/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import object.MaintainStaffDetails;

/**
 *
 * @author User
 */
public class DBOperationMaintainStaff {

    String url = "jdbc:mysql://localhost:3306/hdb";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    JFrame frame = new JFrame();

    boolean addMaintainStaff(MaintainStaffDetails ms) {
        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String sql = "INSERT INTO maintainstaff(firstname,lastname,nicno,address,sex,age,contactno)VALUES('" + ms.getFirstname() + "','" + ms.getLastname() + "','"+ms.getNicno()+"','" + ms.getAddress() + "','" + ms.getSex() + "','" + ms.getAge() + "','" + ms.getContactno() + "')";
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.execute();

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, e);
            return false;
        }finally{
            try {
                 if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
                
        }
      
    }
}
