<%-- 
    Document   : CartView
    Created on : Jul 4, 2019, 10:36:32 PM
    Author     : hp
--%>

<%@page import="model.Flower"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.Item"%>
<%@page import="model.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            .cartNumber button{
                display: inline-block;
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

            .Cart .cartBtn  {
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

            .Cart .light {
                background: white;
                color:#3fb871;
            }
            .Cart .buttonGroup {
                text-align: right;
                margin: 40px 0 10px 0px;
            }

            .Cart .total {
                margin-bottom:30px;
            }
            .Cart .total tr:first-child td {
                background: white;
                color:#3fb871;
                font-weight: bold;
            }
            .Cart .total td {
                text-align: center;
                padding:50px 100px 30px 100px;
            }
            .Cart .total tr:last-child td {
                background: #3fb871;
                color:white;
                font-weight: bold;
            }
            .Cart .buttonGroup2  {
                text-align: right;
                margin-bottom: 30px;
            }
            .Cart .total table {
                margin-left:auto;
                width:70%;
            }
            .buttonGroup form {
                display: inline-block;
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


                .totalTable td:nth-of-type(2):before { content: "Tên sản phẩm"; }
                .totalTable td:nth-of-type(3):before { content: "Đơn giá"; }
                .totalTable td:nth-of-type(4):before { content: "Số lượng"; }
                .totalTable td:nth-of-type(5):before { content: "Thành tiền"; }
                .totalTable td:nth-of-type(6):before { content: "Xóa"; }


            }
            @media only screen and (max-width: 768px)  {
                .Cart h1 {
                    margin: 242px 0 63px 0;
                    font-size:23px;
                }
                .Cart .total td {
                    text-align: center;
                    padding:30px;
                }
                .Cart .total table {
                    width:100%;
                }
            }
            @media only screen and (max-width: 480px){
                .totalTable td:before { 
                    display:none;
                }
                .Cart .cartBtn {
                    width: 105px;
                    font-size:11px;
                    margin-left:0;
                    margin-right:10px;
                }
                .Cart .buttonGroup , .Cart .buttonGroup2 {
                    text-align: center;
                }
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
        <jsp:include page="/Structure/header.jsp" >
            <jsp:param name="count" value = "<%=cart.countItems()%>" />
            <jsp:param name="prePage" value = "CartView" />
        </jsp:include>
        <%
//            HashMap<Integer, Item> cartItems = cart.getCartItems();
//            for (HashMap.Entry<Integer, Item> list : cartItems.entrySet()) {
//                out.write(Integer.toString(list.getValue().getQuantity()));
//            }
        %>
        <div class="Cart">
            <h1>GIỎ HÀNG</h1>
            <table class="totalTable" >
                <tbody>
                    <tr>
                        <th>HÌNH ẢNH</th>
                        <th>TÊN SẢN PHẨM</th>
                        <th>ĐƠN GIÁ</th>
                        <th>SỐ LƯỢNG</th>
                        <th>THÀNH TIỀN</th>
                        <th>XÓA</th>
                    </tr>
                    <%
                        HashMap<Integer, Item> cartItems = cart.getCartItems();
                        cart = (Cart) session.getAttribute("cart");

                        if (cart == null) {
                            cart = new Cart();
                            session.setAttribute("cart", cart);
                        }
                        for (HashMap.Entry<Integer, Item> item : cartItems.entrySet()) {
                            Flower f = item.getValue().getFlower();


                    %>
                    <tr class="ProductRow">
                        <td>
                            <div><img src="<%=f.getImg()%>" alt="dd"></img></div>
                        </td>
                        <td><%=f.getfName()%></td>
                        <td><%=f.getPrice()%> đ</td>
                        <td>
                            <div class="cartNumber">
                                <form action ="HandleCart" method="get">
                                    <input type="hidden" name="event" value="sub">
                                    <input type="hidden" name="id" value="<%=f.getfID()%>">
                                    <input type="hidden" name="prev" value="CartView">
                                    <input type="submit" class="sub hvr-pop" value="-">  </input>
                                </form>
                                <p><%=item.getValue().getQuantity()%></p>
                                <form action ="HandleCart" method="get">
                                    <input type="hidden" name="event" value="add">
                                    <input type="hidden" name="id" value="<%=f.getfID()%>">
                                    <input type="hidden" name="prev" value="CartView">
                                    <input type="submit" class="add hvr-pop" value="+">  </input>
                                </form>
                            </div>
                        </td>
                        <td><%=item.getValue().getQuantity() * f.getPrice()%> đ</td>
                        <td>
                            <form action ="HandleCart" method="get">
                                <input type="hidden" name="event" value="remove">
                                <input type="hidden" name="id" value="<%=f.getfID()%>">
                                <input type="hidden" name="prev" value="CartView">
                                <button type="submit" class="dele hvr-pop" > <i class="fas fa-trash-alt"></i> </button>
                            </form>
                        </td>
                    </tr>

                    <% }%>
                </tbody>
            </table>
            <div class="buttonGroup">
                <form action ="HandleCart" method="get">
                    <input type="hidden" name="event" value="delete">
                    <input type="hidden" name="id" value="1">
                    <input type="hidden" name="prev" value="CartView">
                    <button type="submit" class="cartBtn hvr-fade" > HỦY ĐƠN HÀNG </button>
                </form>
                <form action ="productPage" method="get">
                    <button class="cartBtn light hvr-fade" >TIẾP TỤC MUA</button> 
                </form>
            </div>
            <div class="total">
                <div>
                    <table>
                        <tbody>
                            <tr>
                                <td>TỔNG TIỀN (CHƯA THUẾ)</td>
                                <td><%=cart.total()%> đ</td>
                            </tr>
                            <tr>
                                <td>THUẾ VAT (10%)</td>
                                <td><%=cart.total() * 0.1%>  đ</td>
                            </tr>
                            <tr>
                                <td>TỔNG PHẢI THANH TOÁN</td>
                                <td><%=Math.floor(cart.total() * 1.1)%> đ</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="buttonGroup2">
                <%if (session.getAttribute("sessuser") == null) {%>
                <a href="login.jsp?prePage=CartView"><button class="cartBtn hvr-fade">THANH TOÁN</button></a>
                <%} else if (session.getAttribute("sessuser") != null && cart.countItems() != 0) {%>
                <a href="checkout.jsp"><button class="cartBtn hvr-fade">THANH TOÁN</button></a>
                <%} else {%>
                <a href="productPage"><button class="cartBtn hvr-fade">THANH TOÁN</button></a>
                <%}%>
            </div>
        </div>
        <%@ include file="/Structure/footer.jsp" %>

    </body>

</html>
<script>
    function checkMess() {
        if (typeof ${MSG} !== undefined) {
            alert('Out Of Stock');
        }
    }
    window.onload = checkMess();
</script>
