/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Flower;

/**
 *
 * @author hp
 */
public class CategoryDAO {

    public static String getCategoryName(int id) {
        String name = "";
        try {
            Connection con = DBConnect.getConnection();
            String sql = "SELECT Name FROM Category WHERE cateID = " + id;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                name = rs.getString(1);
            }
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, e);
        }
        return name;

    }

    public static ArrayList<Category> getListCategory() throws SQLException, ClassNotFoundException {
        Connection con = new DBConnect().getConnection();
        String sql = "SELECT * FROM Category ";
        PreparedStatement ps = (PreparedStatement) con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Category> list = new ArrayList<>();
        while (rs.next()) {
            Category category = new Category(rs.getInt(1), rs.getString(2));
            list.add(category);
        }
        con.close();

        return list;
    }
    
     public static int getCategoryID (String name) throws SQLException, ClassNotFoundException {
        int cateID = 0 ;
        Connection con = new DBConnect().getConnection();
        String sql = "SELECT cateID FROM Category WHERE Name = N'"+name+"'";
        PreparedStatement ps = (PreparedStatement) con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            cateID = rs.getInt(1);
        }
        con.close();

        return cateID;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
            System.out.println(getCategoryID("Sinh nhật"));
    }
}