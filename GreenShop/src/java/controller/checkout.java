package controller;

import dao.BillDAO;
import dao.Bill_DetailDAO;
import dao.CustomerDAO;
import dao.FlowerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Bill;
import model.Bill_Detail;
import model.Cart;
import model.Flower;
import model.Item;

/**
 *
 * @author Admin
 */
public class checkout extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet checkout</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet checkout at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        int uid = (int)session.getAttribute("sessUserID");
        String addr = (String)session.getAttribute("sessUserAdd");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart",cart);
        }
        String pttt = request.getParameter("payment");
        String bank2 = request.getParameter("bank2");
        String bank;
        
        
        if(pttt.equals("Thẻ tín dụng") && bank2.isEmpty()){
            request.setAttribute("MSG", "Please input bank");
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
        }
        
        if(pttt.equals("Thẻ tín dụng")){
            bank = bank2;
        }
        else{
            bank = null;
        }
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
        LocalDateTime  localDate = LocalDateTime.now();
        int total = (int)Math.floor(cart.total() * 1.1 +20000.0);
        
        CustomerDAO c = new CustomerDAO();
        BillDAO billDAO = new BillDAO();
        int Bill_ID = billDAO.sizeOfBill()+1;
        Bill bill = new Bill(uid, total, pttt, addr, dtf.format(localDate), bank);
        
        billDAO.insertBill(bill);
        
        Bill_DetailDAO bd = new Bill_DetailDAO();
        String status = "Chưa giao";
        
        FlowerDAO fd = new FlowerDAO();
        
        for (HashMap.Entry<Integer, Item> list : cart.getCartItems().entrySet()) {
            try {
                bd.insertBillDetail(new Bill_Detail(Bill_ID,
                        list.getValue().getFlower().getfID(),
                        list.getValue().getFlower().getPrice(),
                        list.getValue().getQuantity(),status));
                Flower f = fd.getFlowerDetail(Integer.toString(list.getValue().getFlower().getfID()));
                int newQuant = f.getQuantity() - list.getValue().getQuantity();
                fd.updateFlowerQuantity(newQuant, list.getValue().getFlower().getfID());
                
            } catch (SQLException | ClassNotFoundException | NumberFormatException ex) {
                Logger.getLogger(checkout.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        session.setAttribute("cart", cart);
        cart.getCartItems().clear();
        request.getRequestDispatcher("Payment.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
