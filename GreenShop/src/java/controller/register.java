package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import dao.*;

/**
 *
 * @author Admin
 */
public class register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet register</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet register at " + request.getContextPath() + "</h1>");
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
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");
       
        CustomerDAO c = new CustomerDAO();
        
        String nem = "";
        String mail = "";
        String pw = "";
        String addr = "";
        String phone = "";
        
        int check = 0;
        if(name.isEmpty()){
            nem = " Please input name";
            request.setAttribute("NOTINAME", nem);
            check++;
        }
        if(email.isEmpty()){
            mail = " Please input email";
            request.setAttribute("NOTIMAIL", mail);
            check++;
        }
        if(password.isEmpty()){
            pw = " Please input password";
            request.setAttribute("NOTIPW", pw);
            check++;
        }
        if(address.isEmpty()){
            addr = "Please input address";
            request.setAttribute("NOTIAD", addr);
            check++;
        }
        if(contact.isEmpty()){
            phone = " Please input phone number";
            request.setAttribute("NOTIPHONE", phone);
            check++;
        }
        if(c.checkEmail(email)){
            mail = " Email existed";
            request.setAttribute("NOTIMAIL", mail);
            check++;
        }
        if(c.checkPhone(contact)){
            phone = " Phone existed";
            request.setAttribute("NOTIPHONE", phone);
            check++;
        }
        if(contact.length() != 10){
            phone = " Phone number must be 10 digits";
            request.setAttribute("NOTIPHONE", phone);
            check++;
        }
        if (!contact.matches("[0-9]+") && contact.length() > 2) {
            phone = " Phone must be digit only";
            request.setAttribute("NOTIPHONE", phone);
            check++;
        }
        if(password.length() < 7){
            pw = " Password must greater 6 characters";
            request.setAttribute("NOTIPW", pw);
            check++;
        }
        if(check != 0){
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.setAttribute("password", password);
            request.setAttribute("address", address);
            request.setAttribute("contact", contact);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        else {
            request.setAttribute("prePage", request.getParameter("prePage"));
            request.getRequestDispatcher("login.jsp").forward(request, response);
            Customer cus = new Customer(c.sizeOfCustomer()+1,name,email,password,contact,address);
            c.insertUser(cus);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}