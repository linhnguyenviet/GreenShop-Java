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
        <link href="./Style/App.css" type="text/css" rel="stylesheet" />    
       


<style type="text/css">
            .slideWrap{
                width:90%;
                height:600px;
                margin: 0 auto;
                overflow: hidden;
                border : 2px solid #cccccc;
                margin-top : 30px;
                margin-bottom : 30px;
                position:relative;
            }
            .slideWrap img {
                width:100%;
                position:absolute;
                z-index:1;
                opacity:0.8;
            }
            .toTop_btn{
                position: fixed;
                right: 2.5vw;
                bottom: 10vh;
                padding: 1.5vw 1.5vw;
                background-color: #59b586;
                color: #fff;
                border: none;
                outline: none;
                border-radius: 2px;
                cursor: pointer;
                z-index:5000;
            }
            .shoppingBtn {
                position:absolute;
                z-index : 22000;
                background:red;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                background:#59b586;
                color:white;
                border:none;
                padding:15px;
                font-size:1.2em;
                cursor:pointer;
            }
            .slideChooser {
                position:absolute;
                z-index:1000;
                top: 90%;
                left: 43%;
                transform: translate(-1s0%, -50%);            
            }
            .slideChooser ul li{
                display:inline-block;
                cursor:pointer;
                margin : 0 5px;
            }
            .fa-circle {
                color:white;
            }
            @media only screen and (max-width: 768px)  {
              .main{
                  margin-top: 155px;
              }
            }

        </style>
        <script>
            var image = [];            
            var count = 0 ;
            var timer ;
            image[0] = "./Images/slide4.jpeg" ;
            image[1] = "./Images/slide5.jpg" ;
            image[2] = "./Images/slide6..jpg" ;
            function chooseImg(id) {
                switch(id) {
                    case "zero" : count = 0 ; break; 
                    case "one" : count = 1 ; break;  
                    case "two" : count = 2 ; break;              
                }
                 clearTimeout(timer);
            }
           
           function slideShow(id){
               chooseImg(id);
                document.getElementById("slideImg").src = image[count];
                document.getElementById("zeroCircle").style.color = "white";
                document.getElementById("oneCircle").style.color = "white";
                document.getElementById("twoCircle").style.color = "white";
                switch(count) {
                    case 0 :document.getElementById("zeroCircle").style.color = "#3FB871";
                        break; 
                    case 1 :document.getElementById("oneCircle").style.color = "#3FB871";  
                        break;  
                    case 2 :document.getElementById("twoCircle").style.color = "#3FB871"; 
                        break;              
                }
                if(count < image.length-1)
                    count++;
                else count = 0;
                  timer = setTimeout("slideShow()",3000)
            }
             
            window.onload = slideShow
             
        </script>
    </head>
    <body>
        <div class="App">
        <% 
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();  
                session.setAttribute("cart",cart);
            }
        %>
         <jsp:include page="/Structure/header.jsp" >
            <jsp:param name="count" value = "<%=cart.countItems()%>" />
            <jsp:param name="prePage" value = "index.jsp" />
        </jsp:include>
            <div class="slideWrap">
                    <div class ="slideChooser">
                        <ul>
                            <li id="zero" onClick="slideShow(this.id)"><i id="zeroCircle" class="fas fa-circle"></i></li>
                            <li id="one" onClick="slideShow(this.id)"><i  id="oneCircle" class="fas fa-circle"></i></li>
                            <li id="two" onClick="slideShow(this.id)"><i  id="twoCircle" class="fas fa-circle"></i></li>
                        </ul>
                    </div>
                    <img id="slideImg">
                    <div>
                        <form action="productPage" method ="get">
                        <button type="submit" class="shoppingBtn"> Mua sắm </button>
                        </form>
                    </div>
                    
                </div>
            <%@ include file="/Structure/footer.jsp" %>
        </div>
        
    </body>
</html>
