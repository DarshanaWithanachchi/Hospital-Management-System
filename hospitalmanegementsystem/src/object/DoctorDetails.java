/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author User
 */
public class DoctorDetails {
    private int iddoctor;
    private String firstname;
    private String lastname;
    private String address;
    private String sex;
    private int age;
    private String category;
    private int Contactno;
    private String nicno;

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the Contactno
     */
    public int getContactno() {
        return Contactno;
    }

    /**
     * @param Contactno the Contactno to set
     */
    public void setContactno(int Contactno) {
        this.Contactno = Contactno;
    }

    /**
     * @return the iddoctor
     */
    public int getIddoctor() {
        return iddoctor;
    }

    /**
     * @param iddoctor the iddoctor to set
     */
    public void setIddoctor(int iddoctor) {
        this.iddoctor = iddoctor;
    }

    public void executeQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the nicno
     */
    public String getNicno() {
        return nicno;
    }

    /**
     * @param nicno the nicno to set
     */
    public void setNicno(String nicno) {
        this.nicno = nicno;
    }
    
}
