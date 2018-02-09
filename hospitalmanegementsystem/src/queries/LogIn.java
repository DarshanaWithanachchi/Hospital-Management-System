/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import db.DB_Operation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class LogIn {

    public static boolean checkPassword(String usrNme, String pwd) {

        boolean check = false;
        DB_Operation data2 = new DB_Operation(); //get the connection
        Connection con2 = data2.getConnection();

        String search_query = "SELECT password from newuser where username='" + usrNme + "' ";

        String paswrd = null;
        PreparedStatement stt;

        try {
            stt = data2.getConnection().prepareStatement(search_query);

            ResultSet rs = stt.executeQuery(search_query);

            if (rs.next()) {
                paswrd = rs.getString(1);
                stt.executeQuery();
                stt.close();
                con2.close();
            }

            if (pwd.equals(paswrd)) {
                check = true;
            } else {
                check = false;
            }


        } catch (Exception ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;

    }
}
