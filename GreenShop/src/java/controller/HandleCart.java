package controller;

import dao.FlowerDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
public class HandleCart extends HttpServlet {

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

        Cart cart = (Cart) session.getAttribute("cart");
        PrintWriter out = response.getWriter();
        out.println(fId + event);
        boolean check = true;
        int databaseQuant = 0;
        int sessionQuant = 0;
        try {
            int idFlower = Integer.parseInt(fId);
            Flower flower = f.getFlowerDetail(fId);
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
                    if (Integer.parseInt(number)+sessionQuant > databaseQuant) {
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
