package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class LogoutServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LogoutServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LogoutServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String prePage = request.getParameter("prePage");
            Cookie cEmail = new Cookie("cookemail", null);
            Cookie cPassword = new Cookie("cookpass", null);
            Cookie cRemember = new Cookie("cookrem", null);
            cEmail.setMaxAge(0);
            cPassword.setMaxAge(0);
            cRemember.setMaxAge(0);
            response.addCookie(cEmail);
            response.addCookie(cPassword);
            response.addCookie(cRemember);
            HttpSession httpSession = request.getSession();
            httpSession.invalidate();
            request.setAttribute("msg", "You have successfully logged out.");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(prePage);
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
        }
            Cookie cEmail = new Cookie("cookemail", null);
            Cookie cPassword = new Cookie("cookpass", null);
            Cookie cRemember = new Cookie("cookrem", null);
            cEmail.setMaxAge(0);
            cPassword.setMaxAge(0);
            cRemember.setMaxAge(0);
            response.addCookie(cEmail);
            response.addCookie(cPassword);
            response.addCookie(cRemember);
            HttpSession httpSession = request.getSession();
            httpSession.invalidate();
            request.setAttribute("msg", "You have successfully logged out.");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
    
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