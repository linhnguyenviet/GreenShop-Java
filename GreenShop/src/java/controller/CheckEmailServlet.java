package controller;

import dao.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TUNGDUONG
 */
public class CheckEmailServlet extends HttpServlet {

    CustomerDAO customerDAO = new CustomerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (customerDAO.checkEmail(request.getParameter("email"))) {
            response.getWriter().write("<img src=\"Images/not-available.png\" />");
        } else {
            response.getWriter().write("<img src=\"Images/available.png\" />");
        }
    }

}
