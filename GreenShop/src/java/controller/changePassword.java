package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.CustomerDAO;
import model.*;

/**
 *
 * @author jakes
 */
public class changePassword extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet changePassword</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet changePassword at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String email = request.getParameter("email");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");
        CustomerDAO cus = new CustomerDAO();

        String old = (cus.getOldpassword(email));

        if (!old.equals(oldPassword)) {
            String mess = "Old password is wrong!!";
            request.setAttribute("MESS2", mess);
            request.getRequestDispatcher("userInfo.jsp").forward(request, response);
        }
        if (oldPassword.equals(newPassword)) {
            String mess = "New Password must be change";
            request.setAttribute("MESS2", mess);
            request.getRequestDispatcher("userInfo.jsp").forward(request, response);
        }
        if (!newPassword.equals(confirmNewPassword)) {
            String mess = "New password and confirm new password must be same!";
            request.setAttribute("MESS2", mess);
            request.getRequestDispatcher("userInfo.jsp").forward(request, response);
        }
        if (newPassword.length() < 7) {
            String mess = "Password must greater 6 characters";
            request.setAttribute("MESS2", mess);
            request.getRequestDispatcher("userInfo.jsp").forward(request, response);
        }
        if (old.equals(oldPassword) && newPassword.length() > 5) {
            if (newPassword.equals(confirmNewPassword)) {

                cus.change(newPassword, email);

                String mess = "Change password success!";
                request.setAttribute("MESS2", mess);
                request.getRequestDispatcher("userInfo.jsp").forward(request, response);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
