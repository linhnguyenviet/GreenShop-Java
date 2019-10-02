package model;

/**
 *
 * @author Admin
 */
public class Bill_Detail {
    private int billDetailID;
    private int billID;
    private int fID;
    private float price;
    private int quantity;
    private String status;

    public Bill_Detail() {
    }

    public Bill_Detail(int billDetailID, int billID, int fID, float price, int quantity, String status) {
        this.billDetailID = billDetailID;
        this.billID = billID;
        this.fID = fID;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public int getBillDetailID() {
        return billDetailID;
    }

    public int getBillID() {
        return billID;
    }

    public int getfID() {
        return fID;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setBillDetailID(int billDetailID) {
        this.billDetailID = billDetailID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public void setfID(int fID) {
        this.fID = fID;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
}
