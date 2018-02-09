 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DB_Operation {

    public Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/hdb";
        String username = "root";
        String password = "";
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");                                 //Db connection
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            Logger.getLogger(DB_Operation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;


    }
}
