<%-- 
    Document   : productPage
    Created on : Jun 15, 2019, 11:25:49 AM
    Author     : HP
--%>

<%@page import="model.Cart"%>
<%@page import="model.Flower"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./Style/product.css" type="text/css" rel="stylesheet" />
        <title>JSP Page</title>
        <style type="text/css">
            .grid {
                display:grid;
                margin : 0 auto;
                grid-template-columns: 26% 26% 26%;
                grid-auto-rows: 370px;
                grid-gap:70px 33px;
                width:80%;
                margin-top:150px;
                justify-content: center;
            }
            .product {
                border: 1px solid rgb(177, 177, 177);
                border-radius:4px;
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
                margin-right:15%;
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
            
        </style>

    </head>
    <body>
        <% 
            ArrayList<Flower> list = new ArrayList<Flower>();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart",cart);
            }
            String index = "1";
            if(request.getAttribute("index")!=null)
            index = (String) request.getAttribute("index");
            int indexx = Integer.parseInt(index);
            list = (ArrayList<Flower>) request.getAttribute("list");
            int id = 0+(indexx-1)*9;
        %>
        <jsp:include page="/Structure/header.jsp" >
            <jsp:param name="count" value = "<%=cart.countItems()%>" />
            <jsp:param name="prePage" value = "productPage" />
        </jsp:include>
        <div class="grid">
        <% 
            String searchValue = request.getParameter("searchValue");
            for( Flower b : list) {
                id++;
        %>
        <div class="product">  
            <div class="product__img">
                <img src ="<%=b.getImg()%>" alt="" </p>
            </div>
            <div class="product__name">
                <p> <a href="productDetail?id=<%=id%>&searchValue=<%=searchValue%>"><%=b.getfName()%></a>  </p>
            </div>
            <div class="product__category">
                <p>  <%=b.getCategory()%> </p>
            </div>
            <div class="product__price">
                <p>  <%=Float.toString(b.getPrice())%> </p>
            </div>
            <div>
                <form action ="HandleCartInPage" method="get">
                    <input type="hidden" name="event" value="add">
                    <input type="hidden" name="id" value="<%=id%>">
                    <input type="hidden" name="searchValue" value="<%=searchValue%>">
                    <input type="hidden" name="prev" value="search?index=<%=index%>&searchValue=<%=searchValue%>">

                    <input class="addToCart front" type="submit" value="Add To Cart">
                </form>
            </div>
        </div>
            <% } %>
        </div>
        <div class="pages">
            <ul class="pageBar">
                <%  
                    int pages = (Integer) request.getAttribute("page");
                    int count = 0;
                    for(int i=0;i<=pages/9;i++) {
                        count++;
                        if(count == indexx){
                %>
                <li ><a class="active" href="search?index=<%=count%>&searchValue=<%=searchValue%>"> <%out.write(Integer.toString(count));%></a></li>
                 <% } else {
                %>            
                <li><a href="search?index=<%=count%>&searchValue=<%=searchValue%>"> <%out.write(Integer.toString(count));%></a></li>
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
            alert('Out Of Stock ');
        }
    }
    window.onload = checkMess();
</script>
