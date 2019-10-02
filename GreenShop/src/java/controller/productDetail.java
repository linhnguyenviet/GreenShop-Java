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
            Flower flower = new Flower();
            FlowerDAO f = new FlowerDAO();
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
                if (filter.equals("All")) {
                    try {
                        list = f.getListFlowerByPages(00, 100);
                    } catch (SQLException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    flower = list.get(idd - 1);

                } else if (filter.equals("Tiệc cưới")) {
                    try {
                        list = f.getListFlowerPagesCategory(0, 100, filter);
                    } catch (SQLException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    flower = list.get(idd - 1);

                } else if (filter.equals("Tiệc cưới")) {
                    try {
                        list = f.getListFlowerPagesCategory(0, 100, filter);
                    } catch (SQLException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    flower = list.get(idd - 1);

                } else if (filter.equals("Trang trí")) {
                    try {
                        list = f.getListFlowerPagesCategory(0, 100, filter);
                    } catch (SQLException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    flower = list.get(idd - 1);

                } else if (filter.equals("Sinh nhật")) {
                    try {
                        list = f.getListFlowerPagesCategory(0, 100, filter);
                    } catch (SQLException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    flower = list.get(idd - 1);

                } else if (filter.equals("100.000đ-500.000đ")) {
                    try {
                        list = f.getFilterPrice(0, 100, 100000, 500000);
                    } catch (SQLException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    flower = list.get(idd - 1);

                } else if (filter.equals("500.000đ-1.000.000đ")) {
                    try {
                        list = f.getFilterPrice(0, 100, 500000, 1000000);
                    } catch (SQLException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    flower = list.get(idd - 1);

                } else if (filter.equals("1.000.000đ-1.500.000đ")) {
                    try {
                        list = f.getFilterPrice(0, 100, 1000000, 1500000);
                    } catch (SQLException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    flower = list.get(idd - 1);

                } else if (filter.equals("1.500.000đ-2.000.000đ")) {
                    try {
                        list = f.getFilterPrice(0, 100, 1500000, 2000000);
                    } catch (SQLException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    flower = list.get(idd - 1);

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
                    flower = list.get(idd - 1);
            }
            if ((request.getParameter("pageName")) != null) {
            try {
                list = f.getListCategory();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
            }
                flower = list.get(idd - 1);
            }

        request.setAttribute("flower", flower);
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
