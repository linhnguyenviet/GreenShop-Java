package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hp
 */
public class Cart {
    private HashMap<Integer, Item> cartItems;
    
    public Cart() {
        cartItems = new HashMap<>();
    }

    public Cart(HashMap<Integer, Item> cartItems) {
        this.cartItems = cartItems;
    }

    public HashMap<Integer, Item> getCartItems() {
        return cartItems;
    }

    public void setCartItems(HashMap<Integer, Item> cartItems) {
        this.cartItems = cartItems;
    }

    public void insertToCart(Integer key, Item item) {
        boolean bln = cartItems.containsKey(key);
        if (bln) {
             int oldQuantity = item.getQuantity();
             item.setQuantity(oldQuantity + 1);
             cartItems.put(item.getFlower().getfID(), item);
        } else {
             cartItems.put(item.getFlower().getfID(), item);
        }
    }
    
     public void insertToCart(Integer key, Item item, int number) {
        boolean bln = cartItems.containsKey(key);
        if (bln) {
             int oldQuantity = item.getQuantity();
             item.setQuantity(oldQuantity + number);
             cartItems.put(item.getFlower().getfID(), item);
        } else {
             cartItems.put(item.getFlower().getfID(), item);
        }
    }
    
    public void subFromCart(Integer key, Item item) {
        boolean bln = cartItems.containsKey(key);
        if (bln) {
             int oldQuantity = item.getQuantity();
             item.setQuantity(oldQuantity - 1);
             cartItems.put(item.getFlower().getfID(), item);
        } else {
             cartItems.put(item.getFlower().getfID(), item);
        }
    }
    
    public void removeFromCart (Integer key){
        boolean check = cartItems.containsKey(key);
        if (check) {
            cartItems.remove(key);
        }
    }
    
    public int countItems() {
        int count = 0;
        for (Item item : cartItems.values()) { 
              count +=  item.getQuantity();
            }
        return count; 
    }
    
    public double total() {
            int count = 0;
            for (Map.Entry<Integer, Item> list : cartItems.entrySet()) {
                count += list.getValue().getFlower().getPrice() * list.getValue().getQuantity();
            }
            return count;
    }
    
}
