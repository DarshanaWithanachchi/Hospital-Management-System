/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import object.NewUserDetails;

/**
 *
 * @author User
 */
public class DBoperationNewUser {

    String url = "jdbc:mysql://localhost:3306/hdb";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    boolean addNew(NewUserDetails nud) {
        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String query = "INSERT INTO newuser VALUES (?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setInt(1, nud.getIdnewuser());//add value to the sql query
            pst.setString(2, nud.getFirstname());//add value to the sql query
            pst.setString(3, nud.getLaStname());//add value to the sql query
            pst.setInt(4, nud.getAge());//add value to the sql query
            pst.setString(5, nud.getAddress());//add value to the sql query
            pst.setString(6, nud.getEmail());//add value to the sql query
            pst.setInt(7, nud.getContactnumber());//add value to the sql query
            pst.setString(8, nud.getUsername());//add value to the sql query
            pst.setString(9, nud.getPassword());//add value to the sql query

            pst.executeUpdate();//execute the sql query and insert the value to the table

            return true;

        } catch (Exception e) {
            System.out.print(e);
            return false;

        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }
    }
}
