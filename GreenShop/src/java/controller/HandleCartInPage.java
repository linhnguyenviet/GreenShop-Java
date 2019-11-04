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
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Flower;
import model.Item;

/**
 *
 * @author hp
 */
public class HandleCartInPage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HandleCart</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HandleCart at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        String event = request.getParameter("event");
        String fId = request.getParameter("id");
        String number = request.getParameter("number");
        String prev = request.getParameter("prev");
        ArrayList<Flower> list = new ArrayList<Flower>();

        Cart cart = (Cart) session.getAttribute("cart");
        CategoryDAO cateDAO = new CategoryDAO();
        PrintWriter out = response.getWriter();
        out.println(fId + event);
        boolean check = true;
        int databaseQuant = 0;
        int sessionQuant = 0;
        try {
            Flower flower = new Flower();
            int idd = Integer.parseInt(fId);
            String sort = "";
            String filter = "";
            int cateID = cateDAO.getCategoryID(filter);
            String searchValue = "";
            String pageName = "";
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
                request.setAttribute("sort", sort);

            } 
            
            else if ((request.getParameter("filter")) != null) {
                filter = (String)request.getParameter("filter");
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
                        list = f.getListFlowerPagesCategory(0, 100, cateID);
                    } catch (SQLException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    flower = list.get(idd - 1);

                } else if (filter.equals("Trang trí")) {
                    try {
                        list = f.getListFlowerPagesCategory(0, 100, cateID);
                    } catch (SQLException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    flower = list.get(idd - 1);

                } else if (filter.equals("Sinh nhật")) {
                    try {
                        list = f.getListFlowerPagesCategory(0, 100, cateID);
                    } catch (SQLException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    flower = list.get(idd - 1);

                } else if (filter.equals("100.000đ-200.000đ")) {
                    try {
                        list = f.getFilterPrice(0, 100, 100000, 200000);
                    } catch (SQLException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    flower = list.get(idd - 1);

                } else if (filter.equals("200.000đ-300.000đ")) {
                    try {
                        list = f.getFilterPrice(0, 100, 200000, 300000);
                    } catch (SQLException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    flower = list.get(idd - 1);

                } else if (filter.equals("300.000đ-400.000đ")) {
                    try {
                        list = f.getFilterPrice(0, 100, 300000, 400000);
                    } catch (SQLException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    flower = list.get(idd - 1);

                } else if (filter.equals("400.000đ-500.000đ")) {
                    try {
                        list = f.getFilterPrice(0, 100, 400000, 500000);
                    } catch (SQLException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    flower = list.get(idd - 1);
                }
//                else  { 
//                list = f.getListFlowerByPages(00, 100);
//                flower = list.get(idd - 1);
//            }

                request.setAttribute("filter", filter);

            } else if ((request.getParameter("searchValue")) != null) {
                searchValue = request.getParameter("searchValue");
                try {
                    list = f.searchByName2(0, 100, searchValue);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                }
                flower = list.get(idd - 1);
                request.setAttribute("searchValue", searchValue);

            } else if ((request.getParameter("pageName")) != null) {
                pageName = request.getParameter("pageName");

                try {
                    list = f.getListCategory();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                }
                flower = list.get(idd - 1);
                request.setAttribute("pageName", pageName);

            } else {
                try {
                    list = f.getListCategory();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(productDetail.class.getName()).log(Level.SEVERE, null, ex);
                }
                flower = list.get(idd - 1);

            }

            ArrayList<Flower> listAll = new ArrayList<Flower>();
            listAll = f.getListCategory();
            int idFlower = flower.getfID();

            try {
                databaseQuant = flower.getQuantity();
                if (cart != null) {
                    sessionQuant = cart.getCartItems().get(idFlower).getQuantity();
                }

            } catch (Exception e) {
            }

            switch (event) {
                case "add": {
                    if (sessionQuant >= databaseQuant) {
                        check = false;
                        request.setAttribute("MSG", "OutOfStock");
                        session.setAttribute("cart", cart);
                        request.setAttribute("test1",sessionQuant);
                        request.setAttribute("test2",filter.compareTo("500.000d-1000.000d"));
                        request.getRequestDispatcher(prev).forward(request, response);
                    }
                    if (check) {
                        if (cart.getCartItems().containsKey(idFlower)) {
                            cart.insertToCart(idFlower, new Item(flower,
                                    cart.getCartItems().get(idFlower).getQuantity()
                            ));
                        } else {
                            cart.insertToCart(idFlower, new Item(flower, 1));
                        }
                    }
                }
                break;
                case "remove": {
                    if (cart.getCartItems().containsKey(idFlower)) {
                        cart.removeFromCart(idFlower);
                    }

                }
                break;
                case "sub": {
                    if (cart.getCartItems().containsKey(idFlower)) {
                        cart.subFromCart(idFlower, new Item(flower,
                                cart.getCartItems().get(idFlower).getQuantity()
                        ));
                    }
                }
                break;
                case "subWithNumber": {
                    if (Integer.parseInt(number) >= databaseQuant) {
                        check = false;
                        request.setAttribute("MSG", "OutOfStock");
                        session.setAttribute("cart", cart);
                        request.getRequestDispatcher(prev).forward(request, response);
                    }
                    if (check) {
                        if (cart.getCartItems().containsKey(idFlower)) {
                            cart.insertToCart(idFlower, new Item(flower,
                                    cart.getCartItems().get(idFlower).getQuantity()
                            ), Integer.parseInt(number));
                        } else {
                            cart.insertToCart(idFlower, new Item(flower, Integer.parseInt(number)));
                        }
                    }
                }
                break;
                case "delete": {
                    cart.getCartItems().entrySet().removeIf(e -> true);
                }
                break;
                default:
                    break;
            }

        } catch (Exception e)//        response.sendRedirect(prev);
        {
            e.printStackTrace();

        }
        session.setAttribute("cart", cart);
        request.getRequestDispatcher(prev).forward(request, response);
//        String referer = request.getHeader("Referer");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
