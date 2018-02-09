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
import object.SalaryDetails;

/**
 *
 * @author User
 */
public class DBOperatinSalary {

    String url = "jdbc:mysql://localhost:3306/hdb";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    JFrame frame = new JFrame();

    boolean addSalary(SalaryDetails sd) {
        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String sql = "INSERT INTO salary(employeename,idemployee,basicsalary,ot,idattendents,totalsalary)VALUES('" + sd.getEmployeename() + "','" + sd.getIdemployee() + "','" + sd.getBasicsalary() + "','" + sd.getOt() + "','" + sd.getIdattendents() + "','" + sd.getTotalsalary() + "')";
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
