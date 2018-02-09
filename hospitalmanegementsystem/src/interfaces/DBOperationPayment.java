/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import object.PaymentDetails;

/**
 *
 * @author User
 */
public class DBOperationPayment {

    static Statement getStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String url = "jdbc:mysql://localhost:3306/hdb";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    JFrame frame = new JFrame();

    boolean addPayment(PaymentDetails pd) {
        try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String sql = "INSERT INTO payment(patientname,idpatient,doctorfee,testfee,treatmentfee,hospitalfee,totalfee,date)VALUES('" + pd.getPatientname() + "','" + pd.getIdpatient() + "','" + pd.getDoctorfee() + "','" + pd.getTestfee() + "','" + pd.getTreatmentfee() + "','" + pd.getHospitalfee() + "','" + pd.getTotalfee() + "','" + pd.getDate() + "')";
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.execute();
            
           return  true;
            
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
    
   /*public boolean updatePayment(Payment p){
       try {
            con = DriverManager.getConnection(url, username, password);//get the connection
            String sql = "INSERT INTO payment(patientname,idpatient,doctorfee,testfee,treatmentfee,hospitalfee,totalfee,date)VALUES('" + pd.getPatientname() + "','" + pd.getIdpatient() + "','" + pd.getDoctorfee() + "','" + pd.getTestfee() + "','" + pd.getTreatmentfee() + "','" + pd.getHospitalfee() + "','" + pd.getTotalfee() + "','" + pd.getDate() + "')";
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.execute();
            
           return  true;
            
           
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
   } */
    
    
}
