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
 * @author hp
 */
public class productDetail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet productDetail</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet productDetail at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        ArrayList<Flower> list = new ArrayList<Flower>();
        ArrayList<Flower> list2 = new ArrayList<Flower>();

        Flower flower = new Flower();
        FlowerDAO f = new FlowerDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        String id = request.getParameter("id");
        int idd = Integer.parseInt(id);
        String sort = "";
        String filter = "";
        String searchValue = "";
        if ((request.getParameter("sort")) != null) {
            sort = (String) request.getParameter("sort");
            if (sort.equals("From Lowest Price")) {
                try {
                    list = f.getSortPriceASC(0, 100);
                } catch (SQLException ex) {
                    Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                }
                flower = list.get(idd - 1);
            }
            if (sort.equals("By Name")) {
                try {
                    list = f.getSortName(0, 100);
                } catch (SQLException ex) {
                    Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                }
                flower = list.get(idd - 1);
            }
            if (sort.equals("From Highest Price")) {
                try {
                    list = f.getSortPriceDes(0, 100);
                } catch (SQLException ex) {
                    Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                }
                flower = list.get(idd - 1);
            }
        }
        if ((request.getParameter("filter")) != null) {

            filter = request.getParameter("filter");

            int cateId = 0;
            try {
                cateId = categoryDAO.getCategoryID(filter);
            } catch (SQLException ex) {
                Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                for (int i = 0; i < categoryDAO.getListCategory().size(); i++) {
                    if (filter.equals("All")) {
                        list = f.getListCategory();
                    }
                    if (filter.equals(categoryDAO.getListCategory().get(i).getName())) {
                        list = f.getListFlowerPagesCategory(0, 100, categoryDAO.getListCategory().get(i).getCateId());
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (filter.equals("100.000đ-200.000đ")) {
            try {
                list = f.getFilterPrice(0, 100, 100000, 200000);
            } catch (SQLException ex) {
                Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (filter.equals("200.000đ-300.000đ")) {
            try {
                list = f.getFilterPrice(0, 100, 200000, 300000);
            } catch (SQLException ex) {
                Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (filter.equals("300.000đ-400.000đ")) {
            try {
                list = f.getFilterPrice(0, 100, 300000, 400000);
            } catch (SQLException ex) {
                Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (filter.equals("400.000đ-500.000đ")) {
            try {
                list = f.getFilterPrice(0, 100, 400000, 500000);
            } catch (SQLException ex) {
                Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        } 

        if ((request.getParameter("searchValue")) != null) {
            searchValue = request.getParameter("searchValue");
            try {
                list = f.searchByName2(0, 100, searchValue);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ((request.getParameter("pageName")) != null) {
            try {
                list = f.getListCategory();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        request.setAttribute("id", id);
        flower = list.get(idd - 1);

        request.setAttribute("flower", flower);
        request.setAttribute("list", list);

        request.getRequestDispatcher("productDetail.jsp").forward(request, response);

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
