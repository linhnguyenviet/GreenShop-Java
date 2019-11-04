/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jakes
 */
public class Comment {
    private int commentID;
    private int cID;
    private int fID;
    private String commentary;

    public Comment(){
        
    }
    public Comment(int commentID, int cID, int fID, String commentary) {
        this.commentID = commentID;
        this.cID = cID;
        this.fID = fID;
        this.commentary = commentary;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public int getfID() {
        return fID;
    }

    public void setfID(int fID) {
        this.fID = fID;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }
    
    
}
