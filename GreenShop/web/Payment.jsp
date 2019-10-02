<%-- 
    Document   : Payment
    Created on : Jul 6, 2019, 10:05:59 PM
    Author     : Admin
--%>

<%@page import="dao.CustomerDAO"%>
<%@page import="model.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .green{
                width: 80%;
                margin: 0 auto;
                padding-bottom:40px;
                color:#3FB871;
            }
           
        </style>
    </head>
    
    <body>
        <% 
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();  
                session.setAttribute("cart",cart);
            }
        %>
        <jsp:include page="/Structure/header.jsp" >
            <jsp:param name="count" value = "<%=cart.countItems()%>" />
            <jsp:param name="prePage" value = "Payment.jsp" />
        </jsp:include>
        <div style="background:#F6F6F6;text-align:center;">
            <div style="width:30%;margin:0 auto;">
                <img style="width:100%" src="https://png.pngtree.com/element_origin_min_pic/16/11/30/cf87988b56125375b6f484e141bf6907.jpg">
            </div>
            <h1 class="green">Đơn Hàng Đang Được Giao Đến Bạn</h1>
         
        </div>
        
        <%@ include file="/Structure/footer.jsp" %>
    </body>
</html>
