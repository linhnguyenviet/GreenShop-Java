<%-- 
    Document   : emptyCart
    Created on : Jul 9, 2019, 1:20:03 PM
    Author     : hp
--%>

<%@page import="model.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style type="text/css">
        .emptyCart{
            text-align: center;
            background-color: #f2f4f5;
        }
        .emptyCart_img{
            margin-top:40px;
            width: 20%;
            display: inline-block;
        }
        .emptyCart_btn{
            display: inline-block;
            padding: 15px 30px;
            background-color: #59b586;
            color: #fff;
            border: none;
            outline: none;
            border-radius: 2px;
            cursor: pointer;
            margin: 30px 0;
        }
        .emptyCart_title{
            font-size: 20px;
        }
    </style>
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
            <jsp:param name="prePage" value = "emptyCart.jsp" />
        </jsp:include>
         <div class="emptyCart">
                <div class="emptyCart_img">
                    <img style="width:100%" src="http://www.sclance.com/pngs/sorry-png/sorry_png_1277920.jpg" alt="sdsf" />
                </div>
                <h1 class="emptyCart_title">Không tìm thấy sản phảm như yêu cầu</h1>
                <form action="productPage" method ="get">
                    <button type="submit" class="emptyCart_btn"> Tiếp tục mua sắm</button>
                </form>
                
            </div>
        <%@ include file="/Structure/footer.jsp" %>

    </body>
</html>
