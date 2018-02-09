/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package queries;

import db.DB_Operation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import object.SalaryDetails;

/**
 *
 * @author User
 */
public class Search_Salary {

    public static SalaryDetails sechSalaryDetails(int id) {


        DB_Operation data2 = new DB_Operation(); //get the connection
        Connection con2 = data2.getConnection();

        String search_query = "SELECT employeename,idemployee,basicsalary,ot,idattendents,totalsalary FROM salary WHERE idemployee= '" + id + "' ";

        SalaryDetails sd = new SalaryDetails();
        PreparedStatement stt;

        try {
            stt = data2.getConnection().prepareStatement(search_query);


            ResultSet rs = stt.executeQuery(search_query);

            if (rs.next()) {
                sd.setEmployeename(rs.getString(1));
                sd.setIdemployee(rs.getInt(2));
                sd.setBasicsalary(rs.getInt(3));
                sd.setOt(rs.getInt(4));
                sd.setIdattendents(rs.getInt(5));
                sd.setTotalsalary(rs.getInt(6));



            }
            stt.executeQuery();
            stt.close();
            con2.close();

        } catch (Exception e) {
        }
        return sd;

    }
}
