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
public class Sort extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Sort</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Sort at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String searchValue = request.getParameter("searchValue");
        String name = request.getParameter("name");
        String low = request.getParameter("low");
        String high = request.getParameter("high");
        String sort = (String)request.getParameter("sort");
        if(sort == null) sort = (String) request.getAttribute("sort");
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
//            if(sort != null ) {
//               
                            if ( sort.equals("From Lowest Price")) 
                            {
                                list = f.getSortPriceASC(9 * (indexx - 1) + 1, 9 * (indexx - 1) + 9);
                                request.setAttribute("sort", low);

                            }   
                            else if (sort.equals("By Name")) 
                            { 
                                list = f.getSortName(9 * (indexx - 1) + 1, 9 * (indexx - 1) + 9);
                                request.setAttribute("sort", name);

                            }
                            else  if (sort.equals("From Highest Price")) 
                            { 
                                list = f.getSortPriceDes(9 * (indexx - 1) + 1, 9 * (indexx - 1) + 9);
                                request.setAttribute("sort", high);

//                            } 
            }
                            
//            else {
//                 if (low != null ) 
//                            {
//                                list = f.getSortPriceASC(9 * (indexx - 1) + 1, 9 * (indexx - 1) + 9);
//                                request.setAttribute("low", low);
//
//                            }   
//                            else if (name != null ) 
//                            { 
//                                list = f.getSortName(9 * (indexx - 1) + 1, 9 * (indexx - 1) + 9);
//                                request.setAttribute("x", name);
//
//                            }
//                            else 
//                            { 
//                                list = f.getSortPriceDes(9 * (indexx - 1) + 1, 9 * (indexx - 1) + 9);
//                                request.setAttribute("sort", high);
//
//                            } 
//            }
//          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(productPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("index", index);
        request.setAttribute("list", list);
        request.getRequestDispatcher("sort.jsp").forward(request, response);    }

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
