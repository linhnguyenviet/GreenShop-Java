<%-- 
    Document   : index
    Created on : Jun 13, 2019, 12:49:11 PM
    Author     : HP
--%>

<%@page import="model.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="manifest" href="%PUBLIC_URL%/manifest.json" />
        <link rel="stylesheet" href="%PUBLIC_URL%/reset.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <link href="./Style/NavBar.css" type="text/css" rel="stylesheet" /><!--
        -->     <link href="./Style/HeaderImg.css" type="text/css" rel="stylesheet" /><!--
        -->     <link href="./Style/TopHeader.css" type="text/css" rel="stylesheet" /><!--
        -->     <link href="./Style/App.css" type="text/css" rel="stylesheet" /><!--
        -->     <link href="./Style/BottomFooter.css" type="text/css" rel="stylesheet" /><!--<!--
        -->     <link href="./Style/TopFooter.css" type="text/css" rel="stylesheet" /><!--
                                                                                 
        -->
        <style>
            .validate{
                color : red;
            }
            .cartBtn  {
                width:80px;
                height:40px;
                border-radius:3px;
                border:1px solid #3fb871;
                background: #01C19C;
                color:white;
                font-size:13px;
                cursor: pointer;
                margin-top: 18px;
            }
            .input{
                width: 85%;
                height: 28px;
                font-size: 12px;
                background:#F7F7F7;
                border:1px solid #cccccc;
                text-indent: 5px;
            }
            .loginWrap {
                width: 80%;
                margin: auto;
                border: 1px solid gray;
                display:flex;
                margin-top:60px;
                margin-bottom:40px;
                position:relative;
            }
            .loginImg {
                width: 50%;
            }
            .loginImg img {
                width:100%;
                height:100%;
            }
            body {
                background:#F8F8F8;
            }
            .loginContent {
                background:white;
                width: 50%;
                padding-top:5px;
            }
            .loginForm {
                width: 50%;
            }
            .loginContent__inner {
                width: 50%;
                margin : 0 auto;
            }
            .lightGreen {
                color: #01C19C;
                background: white;
                margin-left:5px;
            }
            .btn--back {
                position: absolute;
                right: 20px;
                top: 10px;
            }
            p {
                color:black;
                font-size:0.95em;
            }
            .error {
                font-size:0.8em;
                margin-top:5px;
                color:red;
            }
        </style>
    </head>

    <body>
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
        %>
        <div class="loginWrap" >
            <div class="btn--back" onclick="history.back()"><i class="fas fa-arrow-left"></i></div>
            <div class="loginImg"><img src="./Images/login.jpg"></div>
            <div class="loginContent" >
                <div class="loginContent__inner">
                    <%=request.getAttribute("msg") != null ? request.getAttribute("msg") : ""%>
                    <div>
                        <h2>Chào mừng đến GreenShop</h2>
                    </div>
                    <form action="register" method="post" >
                        <div style="with: 50%;margin: auto" >

                            <p>Tên</p>
                            <input class="input" type="text" name="name" value="${name}" />
                            <% if (request.getAttribute("NOTINAME") != null) {%> 
                            <p class="error">${NOTINAME}</p>
                            <% } %>
                            <p>Email</p>
                            <input class="input" type="email" name="email" value="${email}" />
                            <% if (request.getAttribute("NOTIMAIL") != null) {%> 
                            <p class="error">${NOTIMAIL}</p>
                            <% } %>
                            <p>Mật khẩu</p>
                            <input class="input" type="password" name="password" value="${password}" />
                            <% if (request.getAttribute("NOTIPW") != null) {%> 
                            <p class="error">${NOTIPW}</p>
                            <% } %>
                            <p>Địa chỉ</p>
                            <input class="input" type="text" name="address" value="${address}"/>
                            <% if (request.getAttribute("NOTIAD") != null) {%> 
                            <p class="error">${NOTIAD}</p>
                            <% } %>
                            <p>Số điện thoại</p>
                            <input class="input" type="text" name="contact" value="${contact}" />
                            <% if (request.getAttribute("NOTIPHONE") != null) {%> 
                            <p class="error">${NOTIPHONE}</p>
                            <% }%>
                            <input class="cartBtn " type="submit" formaction="register" value="Đăng ký">
                            <input type="hidden" name="prePage" value="<%=request.getParameter("prePage")%>">
                            <input class="cartBtn lightGreen "  type="submit" formaction="login.jsp?prePage=<%=request.getParameter("prePage")%>" name="login" value="Đăng nhập" /> 
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>