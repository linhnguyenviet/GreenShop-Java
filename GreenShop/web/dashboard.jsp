<%-- 
    Document   : dashboard.jsp
    Created on : Jul 10, 2019, 10:11:29 AM
    Author     : hp
--%>

<%@page import="dao.CategoryDAO"%>
<%@page import="dao.CustomerDAO"%>
<%@page import="dao.BillDAO"%>
<%@page import="dao.Bill_DetailDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Value"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="dao.FlowerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!--
=========================================================
 Paper Dashboard 2 - v2.0.0
=========================================================

 Product Page: https://www.creative-tim.com/product/paper-dashboard-2
 Copyright 2019 Creative Tim (https://www.creative-tim.com)
 Licensed under MIT (https://github.com/creativetimofficial/paper-dashboard/blob/master/LICENSE)

 Coded by Creative Tim

=========================================================

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software. -->



<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
        <link rel="icon" type="image/png" href="../assets/img/favicon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>
            Paper Dashboard 2 by Creative Tim
        </title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <!-- CSS Files -->
        <link href="./paper-dashboard-master/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="./paper-dashboard-master/assets/css/paper-dashboard.css?v=2.0.0" rel="stylesheet" />
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link href="./paper-dashboard-master/assets/demo/demo.css" rel="stylesheet" />
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <% CategoryDAO cat = new CategoryDAO();
            ArrayList<Value> list = new ArrayList<Value>();
            list = cat.getValueCategory();
            request.setAttribute("list", list);
        %>
        <script type="text/javascript">
            google.load('visualization', '1', {'packages': ['columnchart']});
            google.setOnLoadCallback(drawChart);
            console.log("tets???")
            function drawChart() {
                var array = [['Category', 'Number of Flower']]
                array.push(['Sinh nhật', 20]);
                array.push(['Struts', 35]);
                array.push(['tiệc cưới', 21]);
                console.log(${list} )
                var data1 = google.visualization.arrayToDataTable([
                    ['Category', 'Number of Flower']
                    
            <c:forEach items="${list}" var="item">
                    , ['${item.name}',${item.num}]
            </c:forEach>
                ]);
                var option1 = {
                    is3D: true,
                    pieSliceText: 'label',
                    tooltip: {showColorCode: true},
                    'width': 600,
                    'height': 400
                };
                var chart = new google.visualization.PieChart(document.getElementById('Chart2'));
                chart.draw(data1, option1);
            }
        </script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <% Bill_DetailDAO b = new Bill_DetailDAO();
            ArrayList<Value> bill = new ArrayList<Value>();
            bill = b.getAllBillDetail();
            request.setAttribute("bill", bill);
        %>
        <script type="text/javascript">
            google.charts.load("current", {packages: ['corechart']});
            google.charts.setOnLoadCallback(drawChart2);
            function drawChart2() {
                var data = google.visualization.arrayToDataTable([
                ["Element", "Density", { role: "style" } ]
            <c:forEach items="${bill}" var="bills">
                , ['${bills.name}',${bills.num}, "#3fb871"]
            </c:forEach>
                ]);

                var view = new google.visualization.DataView(data);
                view.setColumns([0, 1,
                    {calc: "stringify",
                        sourceColumn: 1,
                        type: "string",
                        role: "annotation"},
                    2]);

                var option2 = {
                    title: "Stats of this month's sale",
                    width: 1050,
                    height: 400,
                    bar: {groupWidth: "92.5%"},
                    legend: {position: "none"},
                };
                var chart2 = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
                chart2.draw(view, option2);
            }
        </script>
    </head>

    <body class="">
        <div class="wrapper ">
            <div class="sidebar" data-color="white" data-active-color="danger">
                <!--
                  Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red | yellow"
                -->
                <div class="logo">
                    <a href="http://www.creative-tim.com" class="simple-text logo-mini">
                        <div class="logo-image-small">
                            <img src="./paper-dashboard-master/assets/img/logo-small.png">
                        </div>
                    </a>
                    <a href="http://www.creative-tim.com" class="simple-text logo-normal">
                        Creative Tim
                        <!-- <div class="logo-image-big">
                          <img src="../assets/img/logo-big.png">
                        </div> -->
                    </a>
                </div>
                <div class="sidebar-wrapper">
                    <ul class="nav">
                        <li class="active ">
                            <a href="dashboard.jsp">
                                <i class="nc-icon nc-bank"></i>
                                <p>Dashboard</p>
                            </a>
                        </li>
                        <li>
                            <a href="billAdmin">
                                <i class="nc-icon nc-bell-55"></i>
                                <p>Order</p>
                            </a>
                        </li>
                        <li>
                            <a href="userAdmin">
                                <i class="nc-icon nc-single-02"></i>
                                <p>User Profile</p>
                            </a>
                        </li>
                        <li>
                            <a href="flowerAdmin">
                                <i class="nc-icon nc-tile-56"></i>
                                <p>Flower Management</p>
                            </a>
                        </li>
                        <li>
                            <a href="categoryAdmin">
                                <i class="nc-icon nc-tile-56"></i>
                                <p>Category Management</p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="main-panel">
                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg navbar-absolute fixed-top navbar-transparent">
                    <div class="container-fluid">
                        <div class="navbar-wrapper">
                            <div class="navbar-toggle">
                                <button type="button" class="navbar-toggler">
                                    <span class="navbar-toggler-bar bar1"></span>
                                    <span class="navbar-toggler-bar bar2"></span>
                                    <span class="navbar-toggler-bar bar3"></span>
                                </button>
                            </div>
                            <a class="navbar-brand" href="#pablo">Paper Dashboard 2</a>
                        </div>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-end" id="navigation">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link btn-magnify" href="#pablo">
                                        <i class="nc-icon nc-layout-11"></i>
                                        <p>
                                            <span class="d-lg-none d-md-block">Stats</span>
                                        </p>
                                    </a>
                                </li>
                                <li class="nav-item btn-rotate dropdown">
                                    <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="nc-icon nc-settings-gear-65"></i>
                                        <p>
                                            <span class="d-lg-none d-md-block">Some Actions</span>
                                        </p>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                                        <a class="dropdown-item" href="LogoutServlet">Sign out</a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <!-- End Navbar -->
                <!-- <div class="panel-header panel-header-lg">
          
            <canvas id="bigDashboardChart"></canvas>
          
          
          </div> -->
                <div class="content">
                    <div class="row">
                        <div class="col-lg-3 col-md-6 col-sm-6">
                            <div class="card card-stats">
                                <div class="card-body ">
                                    <div class="row">
                                        <div class="col-5 col-md-4">
                                            <div class="icon-big text-center icon-warning">
                                                <i class="nc-icon nc-globe text-warning"></i>
                                            </div>
                                        </div>
                                        <div class="col-7 col-md-8">
                                            <div class="numbers">
                                                <p class="card-category">Capacity</p>
                                                <p class="card-title">150GB
                                                <p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-footer ">
                                    <hr>
                                    <div class="stats">
                                        <i class="fa fa-refresh"></i> Update Now
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6 col-sm-6">
                            <div class="card card-stats">
                                <div class="card-body ">
                                    <div class="row">
                                        <div class="col-5 col-md-2">
                                            <div class="icon-big text-center icon-warning">
                                                <i class="nc-icon nc-money-coins text-success"></i>
                                            </div>
                                        </div>
                                        <div class="col-7 col-md-10">
                                            <div class="numbers">
                                                <p class="card-category">Revenue</p>
                                                <% BillDAO bd = new BillDAO();
                                                    int re = bd.revenue();
                                                %>
                                                <p class="card-title" style="font-size:0.85em;padding-top:2px;">$<%=re%>
                                                <p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-footer ">
                                    <hr>
                                    <div class="stats">
                                        <i class="fa fa-calendar-o"></i> Last day
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6 col-sm-6">
                            <div class="card card-stats">
                                <div class="card-body ">
                                    <div class="row">
                                        <div class="col-5 col-md-4">
                                            <div class="icon-big text-center icon-warning">
                                                <i class="nc-icon nc-vector text-danger"></i>
                                            </div>
                                        </div>
                                        <div class="col-7 col-md-8">
                                            <div class="numbers">
                                                <p class="card-category">Product Sold</p>
                                                <p class="card-title"><%=b.countNumberSold()%>
                                                <p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-footer ">
                                    <hr>
                                    <div class="stats">
                                        <i class="fa fa-clock-o"></i> In the last hour
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6 col-sm-6">
                            <div class="card card-stats">
                                <div class="card-body ">
                                    <div class="row">
                                        <div class="col-5 col-md-4">
                                            <div class="icon-big text-center icon-warning">
                                                <i class="nc-icon nc-favourite-28 text-primary"></i>
                                            </div>
                                        </div>
                                        <div class="col-7 col-md-8">
                                            <div class="numbers">
                                                <p class="card-category">Users</p>
                                                <% CustomerDAO cd = new CustomerDAO();
                                                    int numberUser = cd.sizeOfCustomer();
                                                %>
                                                <p class="card-title"><%=numberUser%>
                                                <p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-footer ">
                                    <hr>
                                    <div class="stats">
                                        <i class="fa fa-refresh"></i> Update now
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card ">
                                <div class="card-header ">
                                    <h5 class="card-title">Sold Product</h5>
                                </div>
                                <div class="card-body ">
                                    <div id="columnchart_values"  style="margin:0 auto;"></div>
                                </div>
                                <div class="card-footer ">
                                    <hr>
                                    <div class="stats">
                                        <i class="fa fa-history"></i> Updated 3 minutes ago
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                </div>
                <footer class="footer footer-black  footer-white ">
                    <div class="container-fluid">
                        <div class="row">
                            <nav class="footer-nav">
                                <ul>
                                    <li>
                                        <a href="https://www.creative-tim.com" target="_blank">Creative Tim</a>
                                    </li>
                                    <li>
                                        <a href="http://blog.creative-tim.com/" target="_blank">Blog</a>
                                    </li>
                                    <li>
                                        <a href="https://www.creative-tim.com/license" target="_blank">Licenses</a>
                                    </li>
                                </ul>
                            </nav>
                            <div class="credits ml-auto">
                                <span class="copyright">
                                    ©
                                    <script>
                                        document.write(new Date().getFullYear())
                                    </script>, made with <i class="fa fa-heart heart"></i> by Creative Tim
                                </span>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <!--   Core JS Files   -->
        <script src="./paper-dashboard-master/assets/js/core/jquery.min.js"></script>
        <script src="./paper-dashboard-master/assets/js/core/popper.min.js"></script>
        <script src="./paper-dashboard-master/assets/js/core/bootstrap.min.js"></script>
        <script src="./paper-dashboard-master/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
        <!--  Google Maps Plugin    -->
        <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
        <!-- Chart JS -->
        <script src="./paper-dashboard-master/assets/js/plugins/chartjs.min.js"></script>
        <!--  Notifications Plugin    -->
        <script src="./paper-dashboard-master/assets/js/plugins/bootstrap-notify.js"></script>
        <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
        <script src="./paper-dashboard-master/assets/js/paper-dashboard.min.js?v=2.0.0" type="text/javascript"></script>
        <!-- Paper Dashboard DEMO methods, don't include it in your project! -->
        <script src="./paper-dashboard-master/assets/demo/demo.js"></script>
        <script>
                                        $(document).ready(function () {
                                            // Javascript method's body can be found in assets/assets-for-demo/js/demo.js
                                            demo.initChartsPages();
                                        });
        </script>
    </body>

</html>

