<%@page import="java.util.ArrayList"%>
<%@page import="model.Cart"%>
<%@page import="dao.FlowerDAO"%>
<%@page import="model.Flower"%>
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
        <link href="./Style/NavBar.css" type="text/css" rel="stylesheet" />
        <link href="./Style/HeaderImg.css" type="text/css" rel="stylesheet" />
        <link href="./Style/TopHeader.css" type="text/css" rel="stylesheet" />
        <link href="./Style/App.css" type="text/css" rel="stylesheet" />
        <link href="./Style/BottomFooter.css" type="text/css" rel="stylesheet" />
        <link href="./Style/TopFooter.css" type="text/css" rel="stylesheet" />
        <link href="./Style/productDetail.css" type="text/css" rel="stylesheet" />                                                         
        <style type="text/css">
            .productDetail  {
                display:grid;
                grid-template-columns: repeat(2,50%);
                grid-gap: 30px;
                width:80%;
                margin: 0 auto; 
                margin-top:100px;
                margin-bottom:100px;
            } 
            .productDetail img {
                width: 78%;
                cursor: zoom-in;
                margin: auto;
            }
            .productDetail img:hover {
                transform: scale(1.15);
            }
            .productDetail .detailImg {
                width: 100%;
            }
            .productDetail .name {
                margin-top: 70px;   
            }
            .productDetail .name p {
                font-size: 2.2em;
                font-weight: bold;
            }
            .productDetail .price p {
                font-size: 1.55em;
                color: red;
                font-weight: bold;
            }
            .productDetail .category p {
                font-size: 1.4em;
                font-weight:bold;
                color:rgb(29, 78, 168);
            }
            .productDetail .btngroup1 input {
                padding:7px 5px 2px 5px;
                margin-bottom:5px;
                margin-right:7px;
                width:50px;
            }
            .productDetail .btngroup1 button {
                background:rgb(230, 230, 230);
                color:black;
                border:1px solid rgb(192, 192, 192);
                border-radius: 1px;
                font-size:1.2em;
                padding:2px 9px;
                margin: 0 10px 20px 0;
                cursor:pointer;
            }
            .addCart {
                background:rgb(57, 158, 116);
                color:white;
                border:1px solid rgb(57, 158, 116);
                border-radius: 1px;
                padding:12px;
                margin-right:10px;
                cursor:pointer;
                margin-left: 10px;

            }
            #number {
                width: 47px;               
                text-align: center;
                padding: 11px;
            }
            .right {
                border-left: 2px solid #eeeeee;
                padding-left: 30px; 
            }
            .left {
                padding-top:35px;
            }
            .sideImg {
                width: 80%;
                margin: auto;
                display: flex;
                margin-top: 20px;
            }
            .detailImg {
                width:80%;
                text-align: center;

            }
            .sideImg img {
                width: 22.3%;
                border: 1px solid white;
                border-radius: 2px;
                padding: 0;
                margin: 0 5px;
            }
        </style> 
        <script>
            $ = (e) => {
                return document.getElementById(e);
            }
            inc = () => {
                $("number").value = parseInt($("number").value) + 1;
            }
            dec = () => {
                $("number").value = parseInt($("number").value) - 1;
            }
        </script>
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
            <jsp:param name="prePage" value = "productPage" />
        </jsp:include>

        <%
            Flower flower = new Flower();
            if(request.getAttribute("flower") != null) 
            flower = (Flower)request.getAttribute("flower");
            
        %>
        <div class="productDetail">
            <div class="left">
                <div class="detailImg">
                    <img src="<%=flower.getImg()%>">
                </div>
                <div class="sideImg">
                    <img src="<%=flower.getImg()%>">
                    <img src="<%=flower.getImg()%>">
                    <img src="<%=flower.getImg()%>">
                    <img src="<%=flower.getImg()%>">
                </div>
            </div>
            <div class="right">
                <div class="name" >
                    <p><%=flower.getfName()%> </p>
                </div>
                <div class="price">
                    <p><%=flower.getPrice()%> đ</p>
                </div>
                <div class="category">
                    <p><%=flower.getCategory()%></p>
                </div>
                <div>
                    <p style="font-size: 1.1em;">
                    Cây cảnh được bài trí có khi nhằm thể hiện một ý tưởng của người trồng qua cách xếp đặt mà vẫn giữ được vẻ tự nhiên của lá. Thân cây được uốn theo một hình dáng nào đó, còn gọi là thế, kết hợp với chậu, đất hay nước là môi trường dinh dưỡng cho thực vật ấy. </p>
                </div>
                <% if (Integer.parseInt(flower.getQuantity()) <= 0) {
                %>
                <div >
                    <p style="color:blue;margin-top:40px;">  Not Available </p>
                </div>
                <%
                } else {
                %>

                <div class="btngroup1">
                    <div><p style="font-size: 1.2em;">Số lượng</p></div>
                    <div>
                        <button onclick="dec()">-</button>                           
                        <button onclick="inc()">+</button>
                    </div>
                </div>
                <div class="btngroup2">
                    <form action ="HandleCart" method="get">
                        <input id="number" name = "number" type="text" value="1">
                        <input type="hidden" name="event" value="subWithNumber">
                        <input type="hidden" name="id" value="<%=flower.getfID()%>">
                        <input type="hidden" name="prev" value="productPage">

                        <input  type="submit" class="addCart" value="Thêm">  </input>
                    </form>
                </div>
                <%
                    }
                %>
            </div>       
        </div>
        <%@ include file="/Structure/footer.jsp" %>

    </body>
</html>