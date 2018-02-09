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
import object.DoctorDetails;

public class DBOperaionDoctor {

    String url = "jdbc:mysql://localhost:3306/hdb";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    JFrame frame = new JFrame();

    boolean addDoctor(DoctorDetails doc) {

        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String sql = "INSERT INTO doctor(firstname,lastname,nicno,address,sex,age,category,contactno)VALUES('" + doc.getFirstname() + "','" + doc.getLastname() + "','" + doc.getNicno() + "','" + doc.getAddress() + "','" + doc.getSex() + "','" + doc.getAge() + "','" + doc.getCategory() + "','" + doc.getContactno() + "')";
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.execute();

            return true;


        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, e);
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }


    }
}
