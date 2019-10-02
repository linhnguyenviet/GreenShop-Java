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
    
    </head>
    <style>
        .cartBtn  {
            width:80px;
            height:40px;
            border-radius:3px;
            border:1px solid #3fb871;
            background: #01C19C;
            color:white;
            font-size:13px;
            cursor: pointer;
            margin-top: 13px;
            }
        .input{
            width: 100%;
            height: 35px;
            font-size: 15px;
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
            padding-top:50px;
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
            cursor:pointer;
        }
    </style>
    <body>
       

        <%
            Cookie[] cookies=request.getCookies();
            String email = "", password = "",rememberVal="";
            if (cookies != null) {
                 for (Cookie cookie : cookies) {
                   if(cookie.getName().equals("cEmail")) {
                     email = cookie.getValue();
                   }
                   if(cookie.getName().equals("cPass")){
                     password = cookie.getValue();
                   }
                   if(cookie.getName().equals("cRemember")){
                     rememberVal = cookie.getValue();
                   }
                }
            }
        %>
         
        <div class="loginWrap" >
            <div class="btn--back" onclick="history.back()"><i class="fas fa-arrow-left"></i></div>
            <div class="loginImg"><img src="./Images/login.jpg"></div>
            <div class="loginContent" >
                <div class="loginContent__inner">
                    
                    <div>
                        <h2>Chào mừng đến GreenShop</h2>
                        <p style="color:gray;">Bắt đầu hành trình khám phá của hàng cây cảnh tốt nhất trong nước.</p>
                    </div>
                    <form name="loginForm" method="post" action="<%=request.getContextPath()%>/LoginServlet">
                        <p><%=request.getAttribute("msg1") != null ? request.getAttribute("msg1") : ""%></p>
                        <p >Email</p>
                        <input class="input" type="text" name="email" autocomplete="off" value="<%=email%>" placeholder="<%=request.getAttribute("msg") != null ? request.getAttribute("msg") : ""%>" />
                        <p>Mật khẩu </p>
                        <input class="input" type="password" name="password" autocomplete="off" value="<%=password%>" placeholder="<%=request.getAttribute("msg") != null ? request.getAttribute("msg") : ""%>"/>
                        <p>Remember me <input type="checkbox" name="remember"/></p>
                        <input class="cartBtn " type="submit" name="login" value="Đăng nhập" /> 
                        <input type="hidden" name="prePage" value="<%=request.getParameter("prePage")%>">
                        <input class="cartBtn lightGreen" type="submit" formaction="register.jsp?prePage=<%=request.getParameter("prePage")%>" value="Đăng ký">
                    </form>
                </div>
            </div>
    </div>
    </body>
</html>