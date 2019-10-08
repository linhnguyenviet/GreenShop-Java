/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDAO;
import dao.FlowerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class ManageFlower extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManageFlower</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageFlower at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String fId = request.getParameter("flowerId");
        String update = request.getParameter("Update");
        String delete = request.getParameter("Delete");
        String submit = request.getParameter("Submit");
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        String quantity = request.getParameter("quantity");
        String sale = request.getParameter("sale");
        String action = "Be careful";
        int categoryID = 1;
        FlowerDAO f = new FlowerDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        try {
            categoryID = categoryDAO.getCategoryID(category);
        } catch (SQLException ex) {
            Logger.getLogger(ManageFlower.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageFlower.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (update != null) {
            f.updateFlower(Integer.parseInt(fId),name, img, categoryID, price, quantity, sale);
            action = "Update Successed";
        } else if (delete != null) {
            f.deleteFlower(Integer.parseInt(fId));
            action = "Delete Successed";
        } else if (submit != null) {
            f.insertFlower(f.sizeOfFlower() + 1, name, quantity, img, categoryID, Float.parseFloat(price));
            action = "Add Successed";
        }

        request.setAttribute("action", action);
        request.getRequestDispatcher("flowerAdmin").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
