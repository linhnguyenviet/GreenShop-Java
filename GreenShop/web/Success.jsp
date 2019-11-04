<%-- 
    Document   : index
    Created on : Jun 13, 2019, 12:49:11 PM
    Author     : HP
--%>

<%@page import="model.Cart"%>
<%@page import="model.BillHistory"%>
<%@page import="model.Bill_Detail"%>
<%@page import="model.Bill"%>
<%@page import="dao.CustomerDAO"%>
<%@page import="model.Customer"%>
<%@page import="java.util.ArrayList"%>
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
        #myDIV {
            display:none;
            text-align: left;

            width:670px;
        }

    </style>
    
    <body>
       <%@ include file="/Structure/header.jsp" %>
        <h4 style="text-align: center;">Cảm ơn bạn đã phản hồi</h4>
        <h4 style="text-align: center;">  <a href="index.jsp" >Quay lại trang chủ</a><h4>

        <%@ include file="/Structure/footer.jsp" %>

    </body>
</html>
