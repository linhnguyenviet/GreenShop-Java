/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jakes
 */
public class BillHistory {

    private int bDetailID;
    private int billID;
    private String fName;
    private int quantity;
    private int price;
    private String date;
    private String status;

    public BillHistory() {
    }

    public BillHistory(int bDetailID, int billID, String fName, int quantity, int price, String date, String status) {
        this.bDetailID = bDetailID;
        this.billID = billID;
        this.fName = fName;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.status = status;

    }

    public int getbDetailID() {
        return bDetailID;
    }

    public void setbDetailID(int bDetailID) {
        this.bDetailID = bDetailID;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
