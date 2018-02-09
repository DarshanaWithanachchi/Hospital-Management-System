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
import object.NurseDetails;

/**
 *
 * @author User
 */
public class DBOperationNurse {

    String url = "jdbc:mysql://localhost:3306/hdb";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    JFrame frame = new JFrame();

    boolean addNurse(NurseDetails nud) {
        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String sql = "INSERT INTO nurse(idward,firstname,lastname,nicno,address,sex,age,contactno)VALUES('" + nud.getIdward() + "','" + nud.getFirstname() + "','" + nud.getLastname() + "','"+nud.getNicno()+"','" + nud.getAddress() + "','" + nud.getSex() + "','" + nud.getAge() + "','" + nud.getContactno() + "')";
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
