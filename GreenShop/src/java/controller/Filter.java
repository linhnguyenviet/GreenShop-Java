package controller;

import dao.CategoryDAO;
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
import model.Category;
import model.Flower;

/**
 *
 * @author Tiny
 */
public class Filter extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Filter</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Filter at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //String searchValue = request.getParameter("searchValue");
        String all = request.getParameter("All");
        String gia1 = request.getParameter("100.000đ-200.000đ");
        String gia2 = request.getParameter("200.000đ-300.000đ");
        String gia3 = request.getParameter("300.000đ-400.000đ");
        String gia4 = request.getParameter("400.000đ-500.000đ");
        ArrayList<Category> cat = new ArrayList<Category>();
        CategoryDAO categoryDAO = new CategoryDAO();
        try {
            cat = categoryDAO.getListCategory();
        } catch (SQLException ex) {
            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        }
        String filter = (String) request.getParameter("filter");
        if (filter == null) {
            filter = (String) request.getAttribute("filter");
        }
        String index = "1";
        if (request.getParameter("index") != null) {
            index = request.getParameter("index");
        }
        int indexx = Integer.parseInt(index);
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
            if (filter.equals("All")) {
                list = f.getListFlowerByPages(9 * (indexx - 1) + 1, 9 * (indexx - 1) + 9);
                request.setAttribute("filter", all);

            } else if (filter.equals("100.000đ-200.000đ")) {
                list = f.getFilterPrice(9 * (indexx - 1) + 1, 9 * (indexx - 1) + 9, 100000, 200000);
                request.setAttribute("filter", gia1);

            } else if (filter.equals("200.000đ-300.000đ")) {
                list = f.getFilterPrice(9 * (indexx - 1) + 1, 9 * (indexx - 1) + 9, 200000, 300000);
                request.setAttribute("filter", gia2);

            } else if (filter.equals("300.000đ-400.000đ")) {
                list = f.getFilterPrice(9 * (indexx - 1) + 1, 9 * (indexx - 1) + 9, 300000, 400000);
                request.setAttribute("filter", gia3);

            } else if (filter.equals("400.000đ-500.000đ")) {
                list = f.getFilterPrice(9 * (indexx - 1) + 1, 9 * (indexx - 1) + 9, 400000, 500000);
                request.setAttribute("filter", gia4);

            }
            for (int i = 0; i < cat.size(); i++) {
                if (filter.equals(cat.get(i).getName())) {
                    list = f.getListFlowerPagesCategory(9 * (indexx - 1) + 1, 9 * (indexx - 1) + 9, cat.get(i).getCateId());
                    request.setAttribute("filter", cat.get(i).getName());
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(productPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute(
                "index", index);
        request.setAttribute(
                "list", list);
        request.getRequestDispatcher(
                "filter.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
