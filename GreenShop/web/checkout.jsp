<%-- 
    Document   : index
    Created on : Jun 13, 2019, 12:49:11 PM
    Author     : HP
--%>

<%@page import="dao.CustomerDAO"%>
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
        .align{
            width: 80%;
            margin: 20px auto;
        }
        .green{
            width: 80%;
            margin: 20px auto;
            color:#3FB871;
        }
        .buttonGroup2  {
            text-align: right;
            margin-bottom: 30px;
        }
        table{
            border: 1px solid grey;
        }
        #myDIV{
            display: none;
        }
        #myDIV2{
            display: none;
        }
       .total {
            margin-bottom:30px;
        }
         .total td {
            text-align: right;
            padding:20px;
        }
         .buttonGroup2  {
            text-align: right;
            margin-bottom: 30px;
        }
         .total table {
            margin-left:auto;
        }
        @media only screen and (max-width: 768px)  {
             h1 {
                margin: 242px 0 63px 0;
                font-size:23px;
            }
            .total td {
                text-align: center;
                padding:30px;
            }
            .total table {
                width:100%;
            }
        }
        .cartBtn  {
            width:150px;
            height:45px;
            border-radius:20px;
            border:1px solid #3fb871;
            background: #3fb871;
            color:white;
            font-size:13px;
            margin: 0px 0px 100px 20px;
            cursor: pointer;
            }
    </style>
    <script>
        function myFunction(){
            var x = document.getElementById("myDIV");
            if (x.style.display === "block") {
              x.style.display = "none";
            } else {
              x.style.display = "block";
            }
        }
    
        function myFunction2() {
            var x2 = document.getElementById("myDIV2");
                x2.style.display = "block";
        }
        
        function myFunction3() {
            var x2 = document.getElementById("myDIV2");
            if (x2.style.display === "block") {
                x2.style.display = "none";
            }
        }
        
        function required(){
            var x2 = document.getElementById("myDIV2");
            var empt = document.form1.bank2.value;
            if (empt === "" && x2.style.display === "block"){
                alert("Vui lòng nhập mã số thẻ");
                return false;
            }
            if (isNaN(empt)) 
            {
              alert("Vui lòng chỉ nhập số");
              return false;
            }
            if ((String(empt).length > 19 || String(empt).length < 8) && x2.style.display === "block") { 
                alert("Vui lòng nhập mã số thẻ 8-19 chữ số");
                return false;
            }
        }
      
    </script>
    <body>
        <% 
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart",cart);
            }
            CustomerDAO cus = new CustomerDAO();
        %>
         <jsp:include page="/Structure/header.jsp" >
            <jsp:param name="count" value = "<%=cart.countItems()%>" />
            <jsp:param name="prePage" value = "checkout.jsp" />
        </jsp:include>
        
        <h1 class="green">THANH TOÁN</h1>
        <hr>

        <h3 class="green">Địa Chỉ Nhận Hàng: <%=session.getAttribute("sessUserAdd")%>
            <button onclick="myFunction()">Sửa</button></h3> 
            <div class="align" id="myDIV">
                <form action="ChangeAddress" method="get">
                    <input type="text" name="address">
                    <a href="ChangeAddress"><button>Thay đổi</button></a>
                </form>
            </div>
        <p class="align">Tên người nhận: <%=session.getAttribute("sessuser")%></p>
        <p class="align">Số điện thoại: <%=session.getAttribute("sessUserPhone")%></p>
        <hr>

        <form action="checkout" method="post" class="align" name="form1" onsubmit="return required()">
            <p>Phương thức thanh toán 
            <select name="payment">
                <option value="Thanh toán khi nhận hàng" onclick="myFunction3()">Thanh toán khi nhận hàng</option>
                <option value="Thẻ tín dụng" onclick="myFunction2()">Thẻ tín dụng</option>
            </select>
            </p>
            <div id="myDIV2">
                Mã số thẻ <input type="text" name="bank2">
            </div>
            <div class="total">
                <table>
                    <tbody>
                        <tr>
                            <td>Tổng tiền hàng</td>
                            <td><%=Math.floor(cart.total() * 1.1)%> đ</td>
                        </tr>
                        <tr>
                            <td>Phí vận chuyển</td>
                            <td>20000.0 đ</td>
                        </tr>
                        <tr>
                            <td>Tổng thanh toán</td>
                            <td><%=Math.floor(cart.total() * 1.1 +20000.0)%> đ</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="buttonGroup2">
                <input class="cartBtn hvr-fade" style="text-align: center"   type="submit" value="THANH TOÁN"">
            </div>
        </form>
        <%@ include file="/Structure/footer.jsp" %>

    </body>
</html>