/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author User
 */
public class ViewPayment {
    private int idpayment;
    private String patientname;
    private int idpatient;
    private int doctorfee;
    private int testfee;
    private int treatmentfee;
    private int hospitalfee;
    private int totalfee;
    private int date;

    /**
     * @return the idpayment
     */
    public int getIdpayment() {
        return idpayment;
    }

    /**
     * @param idpayment the idpayment to set
     */
    public void setIdpayment(int idpayment) {
        this.idpayment = idpayment;
    }

    /**
     * @return the patientname
     */
    public String getPatientname() {
        return patientname;
    }

    /**
     * @param patientname the patientname to set
     */
    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    /**
     * @return the idpatient
     */
    public int getIdpatient() {
        return idpatient;
    }

    /**
     * @param idpatient the idpatient to set
     */
    public void setIdpatient(int idpatient) {
        this.idpatient = idpatient;
    }

    /**
     * @return the doctorfee
     */
    public int getDoctorfee() {
        return doctorfee;
    }

    /**
     * @param doctorfee the doctorfee to set
     */
    public void setDoctorfee(int doctorfee) {
        this.doctorfee = doctorfee;
    }

    /**
     * @return the testfee
     */
    public int getTestfee() {
        return testfee;
    }

    /**
     * @param testfee the testfee to set
     */
    public void setTestfee(int testfee) {
        this.testfee = testfee;
    }

    /**
     * @return the treatmentfee
     */
    public int getTreatmentfee() {
        return treatmentfee;
    }

    /**
     * @param treatmentfee the treatmentfee to set
     */
    public void setTreatmentfee(int treatmentfee) {
        this.treatmentfee = treatmentfee;
    }

    /**
     * @return the hospitalfee
     */
    public int getHospitalfee() {
        return hospitalfee;
    }

    /**
     * @param hospitalfee the hospitalfee to set
     */
    public void setHospitalfee(int hospitalfee) {
        this.hospitalfee = hospitalfee;
    }

    /**
     * @return the totalfee
     */
    public int getTotalfee() {
        return totalfee;
    }

    /**
     * @param totalfee the totalfee to set
     */
    public void setTotalfee(int totalfee) {
        this.totalfee = totalfee;
    }

    /**
     * @return the date
     */
    public int getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(int date) {
        this.date = date;
    }
    
}
