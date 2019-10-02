package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

public class CustomerDAO {

    public ArrayList<Bill_Detail> getBill_Detail(String cID) {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT Bill.cID, BillDetail.bDetailID, BillDetail.bID, BillDetail.fID, BillDetail.Price,BillDetail.Quantity, BillDetail.Status\n"
                    + "FROM Bill\n"
                    + "INNER JOIN BillDetail\n"
                    + "ON Bill.bID=BillDetail.bID WHERE cID=" + cID + ";";
            //String sql = "SELECT * FROM BillDetail WHERE bID = "+bID+" ";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Bill_Detail> bList = new ArrayList<Bill_Detail>();
            while (rs.next()) {
                //billID, int userID, float total, String payment, String address, String date, String bank
                bList.add(new Bill_Detail(rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getInt(6), rs.getString(7)));
            }
            stmt.close();
            con.close();
            return bList;
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public boolean checkEmail(String email) {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM Customer WHERE Email = '" + email + "'";
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                connection.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean checkPhone(String phone) {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM Customer WHERE Phone = '" + phone + "'";
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                connection.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // phương thức thêm tài khoản
    public boolean insertUser(Customer u) {
        Connection connection = DBConnect.getConnection();
        String sql = "INSERT INTO Customer (cID, cName, Email, Password, Phone, Address) VALUES('" + u.getcID() + "',N'" + u.getcName() + "','" + u.getEmail() + "',N'" + u.getPassword() + "','" + u.getPhone() + "',N'" + u.getAddress() + "')";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int sizeOfCustomer() {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM Customer";
        int count = 0;
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                count++;
            }
            rs.close();
            s.close();
            return count;
        } catch (SQLException e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return count;
    }

    public Customer login(String email, String password) {
        Connection con = DBConnect.getConnection();
        String sql = "select * from Customer where Email = '" + email + "' and Password = '" + password + "'";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Customer u = new Customer();
                u.setcID(rs.getInt("cID"));
                u.setEmail(rs.getString("Email"));
                u.setPassword(rs.getString("Password"));
                u.setPhone(rs.getString("Phone"));
                u.setAddress(rs.getString("Address"));
                con.close();
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Customer> getAll() {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT * FROM Customer WHERE cID = 1 ";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ArrayList<Customer> cList = new ArrayList<Customer>();

            while (rs.next()) {
                cList.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }

            stmt.close();
            con.close();
            return cList;
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public ArrayList<Customer> getAll(String email) {
        try {
            Connection con = DBConnect.getConnection();

            String sql = "SELECT * FROM Customer WHERE Email = '" + email.trim() + "' ";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Customer> cList = new ArrayList<Customer>();
            while (rs.next()) {
                cList.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }

            stmt.close();
            con.close();
            return cList;
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public String getNameLogin(String email) {
        Connection con = DBConnect.getConnection();
        String sql = "select * from Customer where Email = '" + email + "'";
        PreparedStatement ps;
        String name = null;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                name = rs.getString("cName");
                con.close();
                return name;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getPhoneLogin(String email) {
        Connection con = DBConnect.getConnection();
        String sql = "select * from Customer where Email = '" + email + "'";
        PreparedStatement ps;
        String phone = null;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                phone = rs.getString("Phone");
                con.close();
                return phone;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getAddressLogin(String email) {
        Connection con = DBConnect.getConnection();
        String sql = "select * from Customer where Email = '" + email + "'";
        PreparedStatement ps;
        String add = null;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                add = rs.getString("Address");
                con.close();
                return add;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getEmailLogin(String email) {
        Connection con = DBConnect.getConnection();
        String sql = "select * from Customer where Email = '" + email + "'";
        PreparedStatement ps;
        String mail = null;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                mail = rs.getString("Email");
                con.close();
                return mail;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getIDLogin(String email) {
        Connection con = DBConnect.getConnection();
        String sql = "select * from Customer where Email = '" + email + "'";
        PreparedStatement ps;
        int id;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("cID");
                con.close();
                return id;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void change(String newPassword, String email) {

        try {
            Connection con = DBConnect.getConnection();

            Statement stmt = con.createStatement();

            String sqlChange = "UPDATE Customer SET Password = '" + newPassword + "' WHERE Email = '" + email + "' ";
            ResultSet rs = stmt.executeQuery(sqlChange);
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void changeAddress(String email, String address) {
        Connection con = DBConnect.getConnection();
        String sql = "UPDATE Customer SET Address = N'" + address + "' WHERE Email = '" + email + "'";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getOldpassword(String email) {
        Connection con = DBConnect.getConnection();
        String sql = "select * from Customer where Email = '" + email + "'";
        PreparedStatement ps;
        String old = "";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                old = rs.getString("Password");
                con.close();
                return old;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return old;
    }

    public ArrayList<Customer> getAllUser() {
        try {
            Connection con = DBConnect.getConnection();

            String sql = "SELECT * FROM Customer";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Customer> cList = new ArrayList<Customer>();
            while (rs.next()) {
                cList.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }

            stmt.close();
            con.close();
            return cList;
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public String getEmail(int cID) {
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT Email FROM Customer WHERE cID ='" + cID + "'";
        PreparedStatement ps;
        String email = null;
        try {
            ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                email = rs.getString("Email");
            }
            rs.close();
            conn.close();
            return email;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return email;
    }
//     public boolean deleteCustomerID(String cID) {
//        try {
//            Connection con = DBConnect.getConnection();
//
//            String sql = "DELETE FROM Customer WHERE cID ='" + cID + "'";
//            PreparedStatement ps = con.prepareCall(sql);
//            ps.executeUpdate();
//            ps.close();
//            return true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
//        }
//        return false;
//    }

    public static String block(String password, String email) {
        StringBuilder str = new StringBuilder(password);
        String blockPass = "";
        int count = password.length();
        if (password.contains("block")) {
            return password;
        } else {
            System.out.println("string = " + str);

            // insert character value at offset 8
            str.insert(count++, 'b');
            str.insert(count++, 'l');
            str.insert(count++, 'o');
            str.insert(count++, 'c');
            str.insert(count++, 'k');
            blockPass = str.toString();
            // prints StringBuilder after insertion
            System.out.print("After insertion = ");
            System.out.println(blockPass);
            try {

                Connection con = DBConnect.getConnection();

                String sqlChange = "UPDATE Customer SET Password = '" + blockPass + "' WHERE Email = '" + email + "' ";
                PreparedStatement ps = con.prepareCall(sqlChange);
                ps.executeUpdate();
                ps.close();
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
            }
            return blockPass;
        }

    }

    public static String unBlock(String password, String email) {
        StringBuilder str = new StringBuilder(password);
        String unblockPass = "";
        int count = password.length();
        System.out.println("string = " + str);
        if (password.contains("block")) {
            // insert character value at offset 8
            str.delete(count - 5, count);

            unblockPass = str.toString();
            // prints StringBuilder after insertion
            System.out.print("After insertion = ");
            System.out.println(unblockPass);
            try {

                Connection con = DBConnect.getConnection();

                String sqlChange = "UPDATE Customer SET Password = '" + unblockPass + "' WHERE Email = '" + email + "' ";
                PreparedStatement ps = con.prepareCall(sqlChange);
                ps.executeUpdate();
                ps.close();
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return unblockPass;
    }

    public static boolean isBlocked(String email) {
        boolean check = false;
        try {
            Connection con = DBConnect.getConnection();

            String sql = "SELECT Password FROM Customer WHERE Email = '" + email + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String pass = rs.getString("Password");
                if (pass.contains("block")) {
                    check = true;
                    break;
                }

            }

            stmt.close();
            con.close();

            return check;
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }
        return check;
    }

    public static void deleteOrder(String bDetailID) {
        try {
            Connection con = DBConnect.getConnection();

            Statement stmt = con.createStatement();

            String sql = "DELETE FROM BillDetail WHERE bDetailID = " + bDetailID + " ";
            ResultSet rs = stmt.executeQuery(sql);
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public static void changeQuantity(String bDetailID, String quantity) {

        try {
            Connection con = DBConnect.getConnection();

            Statement stmt = con.createStatement();

            String sql = "UPDATE BillDetail\n"
                    + "SET Quantity = " + quantity + "\n"
                    + "WHERE bDetailID=" + bDetailID + "";
            ResultSet rs = stmt.executeQuery(sql);
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public ArrayList<BillHistory> getBillHistory(String cID) {
        try {
            Connection con = DBConnect.getConnection();
            //Bill id, flowername, quantity , price , date, status
            String sql = "SELECT Bill.cID,BillDetail.bDetailID, BillDetail.bID, Flower.fName, BillDetail.Quantity, BillDetail.Price, Bill.Date, BillDetail.Status,BillDetail.fID\n"
                    + "FROM BillDetail\n"
                    + "JOIN Bill\n"
                    + "ON Bill.bID=BillDetail.bID\n"
                    + "JOIN Flower ON BillDetail.fID=Flower.fID\n"
                    + "WHERE cID=" + cID + "";

            //String sql = "SELECT * FROM BillDetail WHERE bID = "+bID+" ";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<BillHistory> billList = new ArrayList<BillHistory>();
            while (rs.next()) {
                //billID, fName,quantity, price, date, status
                billList.add(new BillHistory(rs.getInt(2),rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8)));
            }
            stmt.close();
            con.close();
            return billList;
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
