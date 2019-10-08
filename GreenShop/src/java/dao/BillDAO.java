package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bill;

/**
 *
 * @author Admin
 */
public class BillDAO {

    public boolean insertBill(Bill bill) {
        Connection connection = DBConnect.getConnection();
        String sql = "INSERT INTO Bill VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, bill.getUserID());
            ps.setFloat(2, bill.getTotal());
            ps.setString(3, bill.getPayment());
            ps.setString(4, bill.getBank());
            ps.setString(5, bill.getAddress());
            ps.setString(6, bill.getDate());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public ArrayList<Bill> getListBill() {
        try {
            Connection connection = DBConnect.getConnection();
            String sql = "SELECT * FROM Bill";
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Bill> list = new ArrayList<>();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setBillID(rs.getInt("BillID"));
                bill.setUserID(rs.getInt("cID"));
                bill.setTotal(rs.getFloat("Total"));
                bill.setPayment(rs.getString("Payment"));
                bill.setBank(rs.getString("Bank"));
                bill.setAddress(rs.getString("Address"));
                bill.setDate(rs.getString("Date"));
                list.add(bill);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int sizeOfBill() {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM Bill";
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
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return count;
    }

    public int revenue() {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM Bill";
        float count = 0;
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                count += rs.getInt(3);
            }
            rs.close();
            s.close();
            return (int) count;
        } catch (SQLException e) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return (int) count;
    }

    public String getDate(int billid) {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT Date FROM Bill WHERE bID = '" + billid + "'";
        PreparedStatement ps;
        String date = null;
        try {
            ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                date = rs.getString("Date");
                connection.close();
                return date;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }

    public int getCustomerID(int billid) {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT cID FROM Bill WHERE bID = '" + billid + "'";
        PreparedStatement ps;
        int cID = 0;
        try {
            ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cID = rs.getInt("cID");

            }
            connection.close();
            return cID;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cID;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        BillDAO f1 = new BillDAO();
        System.out.println((int) f1.revenue());
    }
}
