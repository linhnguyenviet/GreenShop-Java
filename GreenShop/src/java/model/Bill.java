package model;

/**
 *
 * @author Admin
 */
public class Bill {

    private int billID;
    private int userID;
    private float total;
    private String payment;
    private String address;
    private String date;
    private String bank;

    public Bill() {
    }

    public Bill(int billID, int userID, float total, String payment, String address, String date, String bank) {
        this.billID = billID;
        this.userID = userID;
        this.total = total;
        this.payment = payment;
        this.address = address;
        this.date = date;
        this.bank = bank;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }


    public int getBillID() {
        return billID;
    }

    public int getUserID() {
        return userID;
    }

    public float getTotal() {
        return total;
    }

    public String getPayment() {
        return payment;
    }

    public String getAddress() {
        return address;
    }

    public String getDate() {
        return date;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDate(String date) {
        this.date = date;
    }

    

}
