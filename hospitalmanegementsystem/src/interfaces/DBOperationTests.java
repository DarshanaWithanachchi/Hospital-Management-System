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
import object.TestDetails;

/**
 *
 * @author User
 */
public class DBOperationTests {

    String url = "jdbc:mysql://localhost:3306/hdb"; // Connect to the Database
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    JFrame frame = new JFrame();

    boolean addTest(TestDetails td) {
        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String sql = "INSERT INTO test(name,nicno,testno,testdate,result,docname,decision)VALUES('" + td.getName() + "','" + td.getNicno() + "','" + td.getTestno() + "','" + td.getTestdate() + "','" + td.getResult() + "','" + td.getDocname() + "','"+ td.getDecision()+"')";
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.execute();

            return true;
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, e);
            return false;
            
        }finally {
            try {
                if(con != null){
                    con.close();
                }
            } catch (Exception e) {
            }
        }

    }
}
