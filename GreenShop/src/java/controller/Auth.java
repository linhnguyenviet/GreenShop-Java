package controller;

import dao.CustomerDAO;
import model.Customer;

/**
 *
 * @author Admin
 */
public class Auth {
    public static boolean authenticate(String email, String password) {

        CustomerDAO cu = new CustomerDAO();
        Customer cus;
        cus = cu.login(email, password);

            try {
                if (cus.getEmail().equalsIgnoreCase(email)&& cus.getPassword().equals(password)) {
                    return true;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        return false;
    }
}
