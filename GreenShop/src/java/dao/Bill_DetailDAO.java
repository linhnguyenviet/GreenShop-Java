package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bill_Detail;
import model.Value;

/**
 *
 * @author Admin
 */
public class Bill_DetailDAO {

    public boolean insertBillDetail(Bill_Detail bd) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "INSERT INTO BillDetail VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(2, bd.getBillID());
            ps.setInt(3, bd.getfID());
            ps.setFloat(4, bd.getPrice());
            ps.setInt(5, bd.getQuantity());
            ps.setString(6, bd.getStatus());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            Logger.getLogger(Bill_DetailDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

//public int sizeOfBill_Detail() {
//        Connection connection = DBConnect.getConnection();
//        String sql = "SELECT MAX(bDetailID) FROM BillDetail";
//        int max = 0;
//        try {
//            Statement s = connection.createStatement();
//            ResultSet rs = s.executeQuery(sql);
//
//            while (rs.next()) {
//                max = rs.getInt(1);
//            }
//            rs.close();
//            s.close();
//            return max;
//        } catch (SQLException e) {
//            Logger.getLogger(Bill_DetailDAO.class.getName()).log(Level.SEVERE, null, e);
//        }
//        return max;
//    }

    public ArrayList<Value> getAllBillDetail() {
        FlowerDAO f = new FlowerDAO();
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT * FROM BillDetail";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Value> cList = new ArrayList<Value>();
            while (rs.next()) {
                Value v = new Value(rs.getString(3), Integer.parseInt(rs.getString(5)));
                int check = 0;
                for (int i = 0; i < cList.size(); i++) {
                    if (cList.get(i).getName().equals(v.getName())) {
                        cList.get(i).setNum(cList.get(i).getNum() + v.getNum());
                        check++;
                    }
                }
                if (check == 0) {
                    cList.add(v);
                }

            }
            for (Value val : cList) {
                val.setName(f.getFlowerNameById(val.getName()));
            }
            stmt.close();
            con.close();
            return cList;
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(Bill_Detail.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public ArrayList<Bill_Detail> getAllBillDetails() {
        Bill_DetailDAO f = new Bill_DetailDAO();
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT * FROM BillDetail";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Bill_Detail> cList = new ArrayList<Bill_Detail>();
            while (rs.next()) {
                cList.add(new Bill_Detail(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4), rs.getInt(5), rs.getString(6)));
            }
            stmt.close();
            con.close();
            return cList;
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(Bill_Detail.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public int countNumberSold() {
        int count = 0;
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT * FROM BillDetail";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                count += rs.getInt(5);
            }
            stmt.close();
            con.close();
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(Bill_Detail.class.getName()).log(Level.SEVERE, null, e);
        }
        return count;
    }
    public void updateBillDetail(int billdetailid,String status){
        Connection connection = DBConnect.getConnection();
        String sql = 
        "Update BillDetail set Status=?  WHERE bDetailId=?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, status);
            ps.setInt(2, billdetailid);
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Bill_DetailDAO f1 = new Bill_DetailDAO();
        ArrayList<Value> list = new ArrayList<Value>();
        list = f1.getAllBillDetail();
        String a ="123blocked";
       

    }

}
