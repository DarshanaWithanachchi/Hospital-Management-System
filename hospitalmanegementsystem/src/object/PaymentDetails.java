/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author User
 */
public class PaymentDetails {

    private int idpayment;
    private String patientname;
    private int idpatient;
    private int doctorfee;
    private int testfee;
    private int totalfee;
    private int treatmentfee;
    private int hospitalfee;
    private int date;

    public int getIdpayment() {
        return idpayment;
    }

    public void setIdpayment(int idpayment) {
        this.idpayment = idpayment;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public int getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(int idpatient) {
        this.idpatient = idpatient;
    }

    public int getDoctorfee() {
        return doctorfee;
    }

    public void setDoctorfee(int doctorfee) {
        this.doctorfee = doctorfee;
    }

    public int getTestfee() {
        return testfee;
    }

    public void setTestfee(int testfee) {
        this.testfee = testfee;
    }

    public int getTotalfee() {
        return totalfee;
    }

    public void setTotalfee(int totalfee) {
        this.totalfee = totalfee;
    }

    public int getTreatmentfee() {
        return treatmentfee;
    }

    public void setTreatmentfee(int treatmentfee) {
        this.treatmentfee = treatmentfee;
    }

    public int getHospitalfee() {
        return hospitalfee;
    }

    public void setHospitalfee(int hospitalfee) {
        this.hospitalfee = hospitalfee;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
