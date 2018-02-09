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
import object.PatientDetails;

/**
 *
 * @author User
 */
public class DBOperationPatient {

    String url = "jdbc:mysql://localhost:3306/hdb";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    JFrame frame = new JFrame();

    boolean addPatient(PatientDetails pd) {
        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String sql = "INSERT INTO patient(firstname,lastname,address,age,nicno,sex,contactno,admitdate,recomanddoctor,confirmdoctor) VALUES('" + pd.getFirstname() + "','" + pd.getLastname() + "','" + pd.getAddress() + "','" + pd.getAge() + "','" + pd.getNicno() + "','" + pd.getSex() + "','" + pd.getContactno() + "','" + pd.getAdmitdate() + "','" + pd.getRecomanddoctor() + "','" + pd.getConfirmdoctor() + "')";
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
