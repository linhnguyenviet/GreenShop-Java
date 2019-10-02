package model;

/**
 *
 * @author hp
 */
public class Item {
 
    private Flower flower;
    private int quantity;
 
    public Item() {
    }
 
    public Item(Flower flower, int quantity) {
        this.flower = flower;
        this.quantity = quantity;
    }
 
    public Flower getFlower() {
        return flower;
    }
 
    public void setFlower(Flower flower) {
        this.flower = flower;
    }
 
    public int getQuantity() {
        return quantity;
    }
 
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
 
}
