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
    private String quantity;
    private int sale;
    private float vote;
   

    public Flower(int fID, String fName, float price, int cateID, String img, String quantity, int sale, float vote) {
        this.fID = fID;
        this.fName = fName;
        this.price = price;
        this.cateID = cateID;
        this.img = img;
        this.quantity = quantity;
        this.sale = sale;
        this.vote = vote;
    }
  

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
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

    public Flower(String fName, float price, int cateID, String quantity, int sale, float vote) {
        this.fName = fName;
        this.price = price;
        this.cateID = cateID;
        this.quantity = quantity;
        this.sale = sale;
        this.vote = vote;
    }
    
    
}
