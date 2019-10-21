<%-- 
    Document   : productPage
    Created on : Jun 15, 2019, 11:25:49 AM
    Author     : HP
--%>

<%@page import="model.Category"%>
<%@page import="dao.CategoryDAO"%>
<%@page import="model.Cart"%>
<%@page import="model.Flower"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            .grid {
                display: grid;
                grid-template-columns: 26% 26% 26%;
                grid-auto-rows: 370px;
                grid-gap: 70px 33px;
                width: 82.5%;
                margin-left: auto;
                margin-right: 0;
                padding-top: 100px;
                justify-content: center;
                background: #f7f7f7;
            }
            .product {
                border: 1px solid rgb(177, 177, 177);
                border-radius:4px;
                background: #f7f7f7;
                cursor: pointer;

            }
            .product:hover {
                transform: scale(1.05);
                background: white;
            }
            .product > div {
                text-align: center;
            }
            .product img {
                width:100%;
                height:180px;
            }
            .product__name p {
                font-size:1.2em;
                font-weight:500;
            }
            .product__category p {
                color:rgb(24, 95, 153);
                font-size:0.9em;
            }
            .product__price p {
                color:red;
            }
            .pageBar li{
                display:inline-block;
                border-right: 1px solid black;
                text-decoration: none;
                padding:10px;
            }  
            .pageBar li:last-child {
                border-right: none;
            }
            .pageBar li a {
                text-decoration: none;
                font-size:1.1em;
                color:black;
            }
            .pageBar {
                display:inline-block;
                padding: 0;
                list-style-type: none;
                border: 1px solid black;


            }
            .pages {
                text-align: right;
                padding-right:15%;
                background: #f7f7f7;
            }
            .addToCart {
                border : 1px solid #3FB871;
                background: #3FB871;
                color : white;
                padding:10px;
                cursor:pointer;
                border-radius: 3px;
            }
            .active {
                color:red!important;
                font-weight:bold;
                font-size:1.5em;
            }
            .category {
                display: inline-block;
            }
            .category ul li {
                list-style-type: none;
                background: #f2f2f2;
            }
            .category li {
                border: 1px solid gray;
                padding: 5px 15px;
                width: 120px;
                border-bottom: none;
                border-top: none;
                cursor: pointer;
                text-align: center;
                padding: 15px 25px;
                font-size: 0.9em;
            }
            .category li:hover {
                background:#01C19C;
                color:white;
            }
            .category li:last-child {
                border-bottom:1px solid gray;
            }
            .category li:first-child {
                border-top:1px solid gray;
                border-bottom:1px solid gray;
                font-weight:600;
                padding: 22px 25px;
                color:#01C19C;
            }
            .category li:first-child:hover {
                background:none;
                color:#01C19C;
            }
            .filter {
                width:23.5%;
                padding-top: 85px;
                background: #f7f7f7;
                text-align: right;
            }
            .container {
                display:flex;
            }
            .cartBtn  {
                border:none;
                background:none;
            }
        </style>

    </head>
    <body>
        <%
            ArrayList<Flower> list = new ArrayList<Flower>();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            String sort = (String) request.getParameter("sort");
            if (sort == null) {
                out.write("Alo");
            }
            String index = "1";
            if (request.getAttribute("index") != null) {
                index = (String) request.getAttribute("index");
            }
            int indexx = Integer.parseInt(index);
            list = (ArrayList<Flower>) request.getAttribute("list");
            int id = 0 + (indexx - 1) * 9;
        %>
        <jsp:include page="/Structure/header.jsp" >
            <jsp:param name="count" value = "<%=cart.countItems()%>" />
            <jsp:param name="prePage" value = "productPage" />
        </jsp:include>
        <div class ="container">
            <div class="filter">
                <div class="category">
                    <form action="Filter" method="get">
                        <ul>
                            <li>CATEGORY</li>
                            <li><input class="cartBtn"  type="submit" name="filter" value="All" /></li>
                                <% ArrayList<Category> cat = new ArrayList<Category>();
                                    CategoryDAO categoryDAO = new CategoryDAO();
                                    cat = categoryDAO.getListCategory();
                                    for (int i = 0; i < cat.size(); i++) {
                                %>
                            <li><input class="cartBtn"  type="submit" name="filter" value="<%=cat.get(i).getName()%>" /></li>
                                <% } %>
                            <li>PRICE</li>

                            <li><input class="cartBtn"  type="submit" name="filter" value="100.000đ-200.000đ" /></li>
                            <li><input class="cartBtn"  type="submit" name="filter" value="200.000đ-300.000đ" /></li>
                            <li><input class="cartBtn"  type="submit" name="filter" value="300.000đ-400.000đ" /></li>
                            <li><input class="cartBtn"  type="submit" name="filter" value="400.000đ-500.000đ" /></li>
                        </ul>
                    </form>
                </div>


                <div class="category">
                    <form action="Sort" method="get">
                        <ul>
                            <li>SORT</li>
                            <form action="Sort" method="get">
                                <li><input class="cartBtn" type="submit" name="sort" value="By Name" /></li>
                            </form>
                            <form action="Sort" method="get">
                                <li><input class="cartBtn" type="submit" name="sort" value="From Lowest Price" /></li>
                            </form>
                            <li><input class="cartBtn" type="submit" name="sort" value="From Highest Price" /></li>
                        </ul>

                </div>
            </div>
            <div class="grid">
                <%
                    cat = categoryDAO.getListCategory();
                    for (Flower b : list) {
                        id++;
                %>
                <div class="product">  
                    <div class="product__img">
                        <img src ="<%=b.getImg()%>" alt="" </p>
                    </div>
                    <div class="product__name">
                        <p> <a href="productDetail?id=<%=id%>&sort=<%=sort%>"><%=b.getfName()%></a>  </p>
                    </div>
                    <div class="product__category">
                        <p>  <%=categoryDAO.getCategoryName(b.getCateID())%> </p>
                    </div>
                    <div class="product__price">
                        <p>  <%=Float.toString(b.getPrice())%> </p>
                    </div>
                    <% if (b.getQuantity() <= 0) {
                    %>
                    <div >
                        <p style="color:gray;">  Sold Out </p>
                    </div>
                    <%
                    } else {
                    %>

                    <div>
                        <form action ="HandleCartInPage" method="get">
                            <input type="hidden" name="event" value="add">
                            <input type="hidden" name="id" value="<%=id%>">
                            <input type="hidden" name="prev" value="Sort?index=<%=index%>">
                            <input type="hidden" name="sort" value="<%=sort%>">
                            <input class="addToCart front" type="submit" value="Add To Cart">
                        </form>
                    </div>
                    <%
                        }
                    %>
                </div>
                <% } %>
            </div>

        </div>
        <div class="pages">
            <ul class="pageBar">
                <%

                    int pages = (Integer) request.getAttribute("page");
                    int count = 0;
                    for (int i = 0; i <= pages / 9; i++) {
                        count++;
                        if (count == indexx) {
                %>
                <li ><a class="active" href="Sort?index=<%=count%>&sort=<%=sort%>"> <%out.write(Integer.toString(count));%></a></li>
                    <% } else {
                    %>            
                <li><a href="Sort?index=<%=count%>&sort=<%=sort%>"> <%out.write(Integer.toString(count));%></a></li>
                    <% }
                    %>
                    <% }
                    %>

            </ul>
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