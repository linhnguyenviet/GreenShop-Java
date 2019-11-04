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
import model.BillHistory;
import model.Bill_Detail;
import model.Comment;
import model.Customer;
import model.Flower;

/**
 *
 * @author jakes
 */
public class CommentDAO {
    
    public ArrayList<Comment> getComment(int fID) {
        try {
            Connection con = DBConnect.getConnection();
            //Bill id, flowername, quantity , price , date, status
            String sql = "SELECT * FROM Comment WHERE fID=" + fID + "";

            //String sql = "SELECT * FROM BillDetail WHERE bID = "+bID+" ";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<Comment> commentList = new ArrayList<Comment>();
            while (rs.next()) {
                //billID, fName,quantity, price, date, status
                commentList.add(new Comment(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4)));
            }
            stmt.close();
            con.close();
            return commentList;
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    
    public static void insertComment(String cID, String fID, String Comment) {
        try {
            Connection con = DBConnect.getConnection();

            Statement stmt = con.createStatement();

            String sql = "Insert into Comment(cID,fID,Commentary) VALUES(N'" + cID + "','" + fID + "',N'" + Comment + "')";
            ResultSet rs = stmt.executeQuery(sql);
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    
    
    
}
