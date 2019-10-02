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
    <style type="text/css">
        .ProductRow td:first-child div {
            width:150px;
            margin:auto;
            padding: 10px 0px;
        }

        .ProductRow img {
            height:150px;
        }
        .ProductRow td  {
            vertical-align: middle;
            text-align: center;

        }
        .ProductRow td:nth-child(2) {
            color:#3FB871;
        }
        .ProductRow td:nth-child(3) {
            color:#5e5c5c;

        }
        .ProductRow td:nth-child(5) {
            color:#5e5c5c;
        }

        .ProductRow td:nth-child(4) .cartNumber{
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        /* .ProductRow td:nth-child(4) .cartNumber div {
            width:42px;
            height:42px;
            border:1px solid rgb(180, 180, 180);
            display:flex;
            justify-content: center;
            align-items: center;
            margin:auto;
        } */
        .ProductRow i {
            font-size: 1em;
            color:white;
            cursor: pointer;

        }
        .ProductRow .sub, .ProductRow .add, .ProductRow .dele {
            border-radius:2px;
            color:white;
            padding:6px 8px;
        }
        .ProductRow .sub {
            border :1px solid rgb(38, 84, 160);
            background:rgb(38, 84, 160);
            margin-left:20px;
        }
        .ProductRow .add {
            border :1px solid rgb(172, 68, 68);
            background:rgb(172, 68, 68);
            margin-right:20px;
        }
        .ProductRow .dele {
            border :1px solid rgb(197, 187, 99);
            background:rgb(197, 187, 99);

        }
        @media only screen and (max-width: 960px)  {
            .ProductRow .sub {
                margin-left:25%;
            }
            .ProductRow .add {
                margin-right:25%;
            }
            .ProductRow {
                border:1px solid rgb(235, 235, 235);
                margin : 40px 0;
            }
            .ProductRow td {
                padding: 20px 0;
                padding-left:20%;

            }
        }
        @media only screen and (max-width: 768px)  {
            .Cart h1 {
                margin: 242px 0 63px 0;
                font-size:23px;
            }
        }
        @media only screen and (max-width: 480px){
            .ProductRow td {
                padding-left:0;
            }
        }


        .Cart {
            width:80%;
            margin: 0 auto;
        }
        .Cart h1 {
            color:#3FB871;
            font-weight:bold;
            font-size: 18px;
            margin: 70px 0 63px 0;
        }
        .Cart table {
            width:100%;
            border:1px solid black;
            border-collapse: collapse;
        }

        .Cart table td, .Cart table th {
            border: 1px solid #ddd;
            white-space: nowrap;
        }
        .Cart tbody tr:first-child th {
            background:#3fb871;
            padding : 20px 60.5px;
            text-align: center;
            font-size: 14px;
            color:white;
        }







        @media only screen and (max-width: 1280px)  {
            .Cart tbody tr:first-child th {
                padding: 20px 30px;
            }
            .ProductRow .sub, .ProductRow .add, .ProductRow .dele {
                padding: 2px 6px;
            }
            .ProductRow td {
                font-size: 1em;
            }
            .ProductRow i {
                font-size: 0.6em;
            }
        }
        @media only screen and (max-width: 960px)  {
            table, thead, tbody, th, td, tr {
                display: block;
                text-align: center;
            }

            .Cart table {
                border:none;
            }
            .Cart th { 
                display:none;
            }
            .Cart tr {
                margin: 0 0 1rem 0;
            }
            .Cart tr:nth-child(odd) {
                background: #f0f0f0;
            }
            .Cart  td {
                border: none;
                border-bottom: 1px solid #eee;
                position: relative;    
            }
            .Cart td:before {
                position: absolute;
                top: 30%;
                left: -3%;
                width: 45%;
                padding-right: 10px;
                white-space: nowrap;
            }

            .totalTable td:nth-of-type(1):before { content: "Bill ID"; }
            .totalTable td:nth-of-type(2):before { content: "Flower Name"; }
            .totalTable td:nth-of-type(3):before { content: "Quantity"; }
            .totalTable td:nth-of-type(4):before { content: "Price"; }
            .totalTable td:nth-of-type(5):before { content: "Date"; }
            .totalTable td:nth-of-type(6):before { content: "Status"; }


        }
        @media only screen and (max-width: 768px)  {
            .Cart h1 {
                margin: 242px 0 63px 0;
                font-size:23px;
            }

        }
        @media only screen and (max-width: 480px){
            .totalTable td:before { 
                display:none;
            }


        }
    </style>
    <body>
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
        %>
       <jsp:include page="/Structure/header.jsp" >
            <jsp:param name="count" value = "<%=cart.countItems()%>" />
            <jsp:param name="prePage" value = "userInfo.jsp" />
        </jsp:include>


        <div align="center">
            <h2 align="center"> Thông tin khách khàng </h1>
                <form action="changePassword" method="POST">
                    <table align="center" width="670">

                        <tr height="50">

                            <td width="155">Tên</td>
                            <td width="500"><input type="text" value="<%=session.getAttribute("sessuser")%>" style="width: 500px;"> </td>
                        </tr>

                        <tr height="50">

                            <td width="155">Số điện thoại</td>
                            <td width="500"><input type="text" value="<%=session.getAttribute("sessUserPhone")%>"  style="width: 500px;"></td>
                        </tr>

                        <tr height="50">

                            <td width="155">Email</td>
                            <td width="500"><input type="text" value="<%=session.getAttribute("sessUserEmail")%>" name="email" style="width: 500px;"></td>
                        </tr>

                        <tr height="50">

                            <td width="155">Địa chỉ</td>
                            <td width="500"><input type="text" value="<%=session.getAttribute("sessUserAdd")%>" style="width: 500px;"></td>
                        </tr>

                        <tr height="50" >
                            <td width="155">Mật khẩu cũ</td>
                            <td width="500"><input type="password" placeholder="Vui lòng nhập mật khẩu cũ" style="width: 500px;" name="oldPassword"></td>
                        </tr>

                        <tr height="50">
                            <td width="155">Mật khẩu mới</td>
                            <td width="500"><input type="password" placeholder="Vui lòng nhập mật khẩu mới" style="width: 500px;" name="newPassword"></td>
                        </tr>

                        <tr height="50">

                            <td width="155">Xác nhận mật khẩu</td>
                            <td width="500"><input type="password" placeholder="Vui lòng xác nhận mật khẩu" style="width: 500px;" name="confirmNewPassword"></td>
                        </tr>

                        <tr height="50"><td><input type="submit" value="Thay đổi" name="update"></td><td></td></tr>


                        <tr>
                            <td width="155"></td>
                            <td width="500" style="color:red;">${MESS2}</td></tr>

                    </table>
                </form>




                <div class="Cart">
                    <h1>Lịch sử mua hàng</h1>
                    <form action="billHistory.jsp" method="POST">
                    <table class="totalTable" >
                        <tbody>
                            <tr>

                                <th>Bill ID</td>
                                <th>Flower Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Date</th>
                                <th>Status</th>
                            </tr>
                            <%                            CustomerDAO b = new CustomerDAO();
                                String cID = session.getAttribute("sessUserID").toString();
                                ArrayList<BillHistory> bList = b.getBillHistory(cID);

                                for (int i = 0; i < bList.size(); i++) {

                                    out.print(" <tr class=\"ProductRow\">");
                                    out.print(" <td name=\"billID\">");
                                    out.print(bList.get(i).getBillID());
                                    out.print(" </td>");
                                    out.print(" <td name=\"fName\">");
                                    out.print(bList.get(i).getfName());
                                    out.print(" </td>");
                                    out.print(" <td name=\"Price\">");
                                    out.print(bList.get(i).getPrice());
                                    out.print(" </td>");
                                    out.print(" <td name=\"Quantity\">");
                                    out.print(bList.get(i).getQuantity());
                                    out.print(" </td>");
                                    out.print(" <td name=\"Date\">");
                                    out.print(bList.get(i).getDate());
                                    out.print(" </td>");
                                    out.print(" <td name=\"Status\">");

                                    if(bList.get(i).getStatus().equals("Đã giao")){
                                            out.print(bList.get(i).getStatus());
                                        }
                                  else if(bList.get(i).getStatus().equals("Chưa giao")){
                                    out.print(bList.get(i).getStatus()+"<button type=\"submit\">Chỉnh sửa</button>");
                                    }
                                  
                                      
                                   // out.print();

                                    out.print(" </td>");
                                    out.print(" </tr>");
                                }
                            %>



                        </tbody>
                    </table>

                    </form>
                </div>



        </div>

        <%@ include file="/Structure/footer.jsp" %>

    </body>
</html>
