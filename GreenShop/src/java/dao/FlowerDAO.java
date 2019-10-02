package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Flower;
import dao.DBConnect;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Flower;
import model.Value;


/**
 *
 * @author HP
 */
public class FlowerDAO {
    
public ArrayList<Flower> getListCategory() throws ClassNotFoundException, SQLException {
       
        ArrayList<Flower> list = new ArrayList<>();
        try {
            Connection con = new DBConnect().getConnection();
            String sql = "SELECT * FROM Flower";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Flower flower = new Flower(rs.getInt(1),rs.getString(2),rs.getFloat(4),rs.getInt(5),
            rs.getString(6),rs.getString(3));
                list.add(flower);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


public ArrayList<Flower> getListFlowerByPages (int firstResult, int maxResult) throws SQLException, ClassNotFoundException {
        Connection con = new DBConnect().getConnection();
//        String sql = "SELECT * FROM Flower WHERE fID BETWEEN ? AND ?;";
        String sql = "SELECT * FROM Flower ";
        PreparedStatement ps = (PreparedStatement) con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Flower> list = new ArrayList<>();
        int count = 0;

        while (rs.next()) {
            count++;
            if(count>= firstResult && count <= maxResult) {
            Flower flower = new Flower(rs.getInt(1),rs.getString(2),rs.getFloat(4),rs.getInt(5),
            rs.getString(6),rs.getString(3));
            list.add(flower);
            } 
        }
        con.close();

        return list;
}

public int countPages() throws SQLException, ClassNotFoundException {
        Connection con = new DBConnect().getConnection();
        String sql = "SELECT * FROM Flower";
        PreparedStatement ps = (PreparedStatement) con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        int count =0; 
        while (rs.next()) {
            count++;
        }
         con.close();
        return count;
}

public int countPagesSearch(String searchValue) throws SQLException, ClassNotFoundException {
        Connection con = new DBConnect().getConnection();
        String sql = "SELECT * FROM Flower WHERE fName LIKE N'%"+searchValue+"%'"; 
        PreparedStatement ps = (PreparedStatement) con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        int count =0; 
        while (rs.next()) {
            count++;
        }
         con.close();
        return count;
}

public Flower getFlowerDetail(String id) throws ClassNotFoundException, SQLException {
       
        try {
            Connection con = new DBConnect().getConnection();
            String sql = "SELECT * FROM Flower WHERE fID="+id;
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Flower flower = new Flower(rs.getInt(1),rs.getString(2),rs.getFloat(4),rs.getInt(5),
            rs.getString(6),rs.getString(3));
                return flower;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Flower> getSortPriceASC (int firstResult, int maxResult) throws SQLException, ClassNotFoundException {
        Connection con = new DBConnect().getConnection();
//        String sql = "SELECT * FROM Flower WHERE fID BETWEEN ? AND ?;";
        String sql = "SELECT * FROM Flower ORDER BY Price ASC";
        PreparedStatement ps = (PreparedStatement) con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Flower> list = new ArrayList<>();
        int count = 0;

        while (rs.next()) {
            count++;
            if(count>= firstResult && count <= maxResult) {
            Flower flower = new Flower(rs.getInt(1),rs.getString(2),rs.getFloat(4),rs.getInt(5),
            rs.getString(6),rs.getString(3));
            list.add(flower);
            } 
        }
        con.close();

        return list;
}
    
    public ArrayList<Flower> getSortPriceDes (int firstResult, int maxResult) throws SQLException, ClassNotFoundException {
        Connection con = new DBConnect().getConnection();
//        String sql = "SELECT * FROM Flower WHERE fID BETWEEN ? AND ?;";
        String sql = "SELECT * FROM Flower ORDER BY Price DESC , fName ASC";
        PreparedStatement ps = (PreparedStatement) con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Flower> list = new ArrayList<>();
        int count = 0;

        while (rs.next()) {
            count++;
            if(count>= firstResult && count <= maxResult) {
            Flower flower = new Flower(rs.getInt(1),rs.getString(2),rs.getFloat(4),rs.getInt(5),
            rs.getString(6),rs.getString(3));
            list.add(flower);
            } 
        }
        con.close();

        return list;
}

public ArrayList<Flower> getSortName (int firstResult, int maxResult) throws SQLException, ClassNotFoundException {
        Connection con = new DBConnect().getConnection();
//        String sql = "SELECT * FROM Flower WHERE fID BETWEEN ? AND ?;";
        String sql = "SELECT * FROM Flower ORDER BY fName ASC , Category ASC";
        PreparedStatement ps = (PreparedStatement) con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Flower> list = new ArrayList<>();
        int count = 0;

        while (rs.next()) {
            count++;
            if(count>= firstResult && count <= maxResult) {
            Flower flower = new Flower(rs.getInt(1),rs.getString(2),rs.getFloat(4),rs.getInt(5),
            rs.getString(6),rs.getString(3));
            list.add(flower);
            } 
        }
        con.close();

        return list;
}
   
    
 public ArrayList<Flower> searchByName2(int firstResult, int maxResult,String searchValue) throws ClassNotFoundException, SQLException {
               int count = 0;

        ArrayList<Flower> list = new ArrayList<>();
        try {
            Connection con = new DBConnect().getConnection();
            String sql = "SELECT * FROM Flower WHERE fName LIKE N'%"+searchValue+"%' OR Category LIKE N'%"+searchValue+"%'"; 
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                            count++;

                Flower flower = new Flower(rs.getInt(1),rs.getString(2),rs.getFloat(4),rs.getInt(5),
            rs.getString(6),rs.getString(3));
                 if(count>= firstResult && count <= maxResult)
                list.add(flower);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
       
    }

    public void updateFlower(int fId,String name, String img, int category, String price,String quantity){
        Connection connection = DBConnect.getConnection();
        String sql = 
        "Update Flower set fID = ? , fName = ? , Quantity = ?, Price = ?, cateID =?, Img=?  WHERE fID=?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, fId);
            ps.setString(2, name); 
            ps.setString(3,quantity);
            ps.setFloat(4, Float.parseFloat(price));
            ps.setInt(5, category);
            ps.setString(6, img);
            ps.setInt(7, fId);

            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void insertFlower(int fId,String name, String quantity, String img, int category, float price){
        Connection connection = DBConnect.getConnection();
        String sql = 
        "INSERT INTO Flower VALUES(?,?,?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, fId);
            ps.setString(2, name); 
            ps.setString(3,quantity);
            ps.setFloat(4, price);
            ps.setInt(5, category);
            ps.setString(6, img);
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void deleteFlower(int fId){
        Connection connection = DBConnect.getConnection();
        String sql = 
        "DELETE FROM FLOWER  WHERE fID=?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, fId);
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public int sizeOfFlower(){
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM Flower";
        int count = 0;
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()){
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
    public ArrayList<Flower> getFilterPrice (int firstResult, int maxResult, int minPrice, int maxPrice) throws SQLException, ClassNotFoundException {
        Connection con = new DBConnect().getConnection();
        String sql = "SELECT * FROM Flower WHERE price BETWEEN "+minPrice+" AND "+maxPrice+" ORDER BY Price ASC;";
        //String sql = "SELECT * FROM Flower ORDER BY fName ASC , Category ASC";
        PreparedStatement ps = (PreparedStatement) con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Flower> list = new ArrayList<>();
        int count = 0;

        while (rs.next()) {
            count++;
            if(count>= firstResult && count <= maxResult) {
            Flower flower = new Flower(rs.getInt(1),rs.getString(2),rs.getFloat(4),rs.getInt(5),
            rs.getString(6),rs.getString(3));
            list.add(flower);
            } 
        }
        con.close();

        return list;
}
    
    public ArrayList<Flower> getListFlowerPagesCategory (int firstResult, int maxResult, String category) throws SQLException, ClassNotFoundException {
        Connection con = new DBConnect().getConnection();
//        String sql = "SELECT * FROM Flower WHERE fID BETWEEN ? AND ?;";
        String sql = "SELECT * FROM Flower Where Category LIKE N'%"+category+"%'"; ;
        PreparedStatement ps = (PreparedStatement) con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Flower> list = new ArrayList<>();
        int count = 0;

        while (rs.next()) {
            count++;
            if(count>= firstResult && count <= maxResult) {
            Flower flower = new Flower(rs.getInt(1),rs.getString(2),rs.getFloat(4),rs.getInt(5),
            rs.getString(6),rs.getString(3));
            list.add(flower);
            } 
        }
        con.close();

        return list;
}
    public ArrayList<String> getListFlowerImages() throws ClassNotFoundException, SQLException {
       
        ArrayList<String> list = new ArrayList<>();
        try {
            Connection con = new DBConnect().getConnection();
            String sql = "SELECT * FROM Flower";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(6));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
public Set<String> getAllCategory() throws ClassNotFoundException, SQLException {
       
        Set<String> set = new HashSet<String>();

        try {
            Connection con = new DBConnect().getConnection();
            String sql = "SELECT * FROM Flower";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               set.add(rs.getString(5));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }
public int countByCategory(String category) throws ClassNotFoundException, SQLException {
       
        ArrayList<String> set = new ArrayList<String>();
        int count = 0;

        try {
            Connection con = new DBConnect().getConnection();
            String sql = "SELECT * FROM Flower Where Category LIKE N'%"+category+"%'"; ;
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               count++;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
public ArrayList<Value> getValueCategory() throws ClassNotFoundException, SQLException {
       
        ArrayList<Value> list = new ArrayList<Value>();
        Set<String> set = new HashSet<String>();
        FlowerDAO f = new FlowerDAO();
        set = f.getAllCategory();
        for (String category : set)
        try {
            int count = 0;
            Connection con = new DBConnect().getConnection();
            String sql = "SELECT * FROM Flower Where Category LIKE N'%"+category+"%'"; ;
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               count++;
            }
            list.add(new Value(category,count));
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateFlowerQuantity(int newQuantity, int fID){
        Connection con = DBConnect.getConnection();
        String sql = "UPDATE Flower SET Quantity = ? WHERE fID = ?";
        
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, newQuantity);
            ps.setInt(2, fID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FlowerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getFlowerNameById(String fId) throws ClassNotFoundException, SQLException {
       
        ArrayList<String> set = new ArrayList<String>();
        String res = "";

        try {
            Connection con = new DBConnect().getConnection();
            String sql = "SELECT * FROM Flower Where fID LIKE N'"+fId+"'"; ;
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               res =  rs.getString(2);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        FlowerDAO f1 = new FlowerDAO();
        ArrayList<Flower> list = new ArrayList<Flower>();

        list =f1.getFilterPrice(0, 100, 100000, 500000);
        for ( Flower b : list) {
            System.out.println(b.getfName() + "     " + b.getQuantity());
        }
        
    
}
}