package model;

/**
 *
 * @author Tiny
 */
public class Customer {
    private int cID;
    private String cName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private int role;

    public Customer() {
    }

    public Customer(int cID, String cName, String email, String password, String phone, String address, int role) {
        this.cID = cID;
        this.cName = cName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Customer(String cName, String email, String password, String phone, String address, int role) {
        this.cName = cName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }    
    
}
