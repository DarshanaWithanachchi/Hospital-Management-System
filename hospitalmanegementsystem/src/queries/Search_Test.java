/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import db.DB_Operation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import object.TestDetails;

/**
 *
 * @author User
 */
public class Search_Test {
    public static TestDetails sechDetails(String nic){
        
        
        DB_Operation data2 = new DB_Operation(); //get the connection
        Connection con2 = data2.getConnection();

        String search_query = "SELECT name,testno,testdate,result,docname,decision FROM test WHERE nicno= '" + nic + "' ";

        TestDetails td = new TestDetails();
        PreparedStatement stt;
        
        try {
             stt = data2.getConnection().prepareStatement(search_query);


            ResultSet rs = stt.executeQuery(search_query);

            if(rs.next()) {
                td.setName(rs.getString(1));
                td.setTestno(rs.getInt(2));
                td.setTestdate(rs.getInt(3));
                td.setResult(rs.getString(4));
                td.setDocname(rs.getString(5));
                td.setDecision(rs.getString(6));

             }
        } catch (Exception e) {
        }
        return td;
    }
}
