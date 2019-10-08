package model;

/**
 *
 * @author Tiny
 */
public class Flower {
    
    private int fID;
    private String fName;
    private float price;
    private int cateID;
    private String img ;
    private int quantity;
    private int sale;
    private float vote;
   

    public Flower(int fID, String fName, float price, int cateID, String img, int quantity, int sale, float vote) {
        this.fID = fID;
        this.fName = fName;
        this.price = price;
        this.cateID = cateID;
        this.img = img;
        this.quantity = quantity;
        this.sale = sale;
        this.vote = vote;
    }
  

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Flower() {
    }

   
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public int getfID() {
        return fID;
    }

    public void setfID(int fID) {
        this.fID = fID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCateID() {
        return  cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public Flower(String fName, float price, int cateID, int quantity, int sale, float vote) {
        this.fName = fName;
        this.price = price;
        this.cateID = cateID;
        this.quantity = quantity;
        this.sale = sale;
        this.vote = vote;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public float getVote() {
        return vote;
    }

    public void setVote(float vote) {
        this.vote = vote;
    }
    
    
}
