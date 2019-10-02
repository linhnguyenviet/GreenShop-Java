package controller;

import dao.FlowerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Flower;

/**
 *
 * @author hp
 */
public class flowerAdmin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet flowerAdmin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet flowerAdmin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
                request.setCharacterEncoding("UTF-8");
                FlowerDAO f = new FlowerDAO();
                ArrayList<Flower> list = new ArrayList<Flower>();
                int pages = 0;
                try {
                    pages = f.countPages();
                    } catch (SQLException ex) {
                        Logger.getLogger(productPage.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(productPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    request.setAttribute("page", pages);

                try {
                    list = f.getListCategory();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(productPage.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(productPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                request.setAttribute("list", list);

         request.getRequestDispatcher("flowerAdmin.jsp").forward(request, response);
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
