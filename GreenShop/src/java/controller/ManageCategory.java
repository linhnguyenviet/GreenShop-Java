package controller;

import dao.CategoryDAO;
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
public class ManageCategory extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManageCategory</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageCategory at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String cateId = request.getParameter("cateId");
        String update = request.getParameter("Update");
        String delete = request.getParameter("Delete");
        String submit = request.getParameter("Submit");
        String name = request.getParameter("name");
        String action = "Be careful";
        int categoryID = 1;
        CategoryDAO f = new CategoryDAO();
        int length = 0;
        try {
            length = f.getListCategory().size();
        } catch (SQLException ex) {
            Logger.getLogger(ManageCategory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (update != null) {
            f.updateCategory(Integer.parseInt(cateId), name);
            action = "Update Successed"; 
        
        } else if (delete != null) {
            f.deleteCategory(Integer.parseInt(cateId));
            action = "Delete Successed";
        }
         else if (submit != null) {
            f.insertCategory(name);
            action = "Add Successed";
        }

        request.setAttribute("action", action);
        request.getRequestDispatcher("categoryAdmin").forward(request, response);
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
