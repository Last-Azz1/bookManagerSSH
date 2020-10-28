<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>读者管理</title>
    <!-- ================= Favicon ================== -->
    <!-- Standard -->
    <link rel="shortcut icon" href="http://placehold.it/64.png/000/fff">
    <!-- Retina iPad Touch Icon-->
    <link rel="apple-touch-icon" sizes="144x144" href="http://placehold.it/144.png/000/fff">
    <!-- Retina iPhone Touch Icon-->
    <link rel="apple-touch-icon" sizes="114x114" href="http://placehold.it/114.png/000/fff">
    <!-- Standard iPad Touch Icon-->
    <link rel="apple-touch-icon" sizes="72x72" href="http://placehold.it/72.png/000/fff">
    <!-- Standard iPhone Touch Icon-->
    <link rel="apple-touch-icon" sizes="57x57" href="http://placehold.it/57.png/000/fff">
    <!-- Styles -->
    <link href="assets/css/lib/calendar2/pignose.calendar.min.css" rel="stylesheet">
    <link href="assets/css/lib/chartist/chartist.min.css" rel="stylesheet">
    <link href="assets/css/lib/font-awesome.min.css" rel="stylesheet">
    <link href="assets/css/lib/themify-icons.css" rel="stylesheet">
    <link href="assets/css/lib/owl.carousel.min.css" rel="stylesheet" />
    <link href="assets/css/lib/owl.theme.default.min.css" rel="stylesheet" />
    <link href="assets/css/lib/weather-icons.css" rel="stylesheet" />
    <link href="assets/css/lib/menubar/sidebar.css" rel="stylesheet">
    <link href="assets/css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/lib/helper.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
    <style>
        table{
            text-align: center;
        }
        th,tr,td{
            text-align: center;
        }
    </style>
</head>
<body>
<div class="sidebar sidebar-hide-to-small sidebar-shrink sidebar-gestures">
    <div class="nano">
        <div class="nano-content">
            <ul>
                <div class="logo"><a href="index.jsp"><!-- <img src="assets/images/logo.png" alt="" /> --><span>图书</span></a></div>
                <li class="label">管理</li>
                <li><a class="sidebar-sub-toggle"><i class="ti-layout-grid4-alt"></i> 管理中心 <span class="sidebar-collapse-icon ti-angle-down"></span></a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/book_queryAllbook.action">图书管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/reader_queryAllReader.action">读者管理</a></li>
                    </ul>
                </li>
                <li class="label">用户</li>
                <li><a class="sidebar-sub-toggle"><i class="ti-target"></i> 用户中心 <span class="sidebar-collapse-icon ti-angle-down"></span></a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/user_logout.action">切换用户</a></li>
                        <li><a href="page-reset-password.jsp">忘记密码</a></li>
                    </ul>
                </li>
                <li><a href="${pageContext.request.contextPath}/user_logout.action"><i class="ti-close"></i> 退出</a></li>
            </ul>
        </div>
    </div>
</div>



<!-- /# sidebar -->
<div class="header">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <div class="float-left">
                    <div class="hamburger sidebar-toggle">
                        <span class="line"></span>
                        <span class="line"></span>
                        <span class="line"></span>
                    </div>
                </div>
                <div class="float-right">
                    <div class="dropdown dib">
                        <div class="header-icon" data-toggle="dropdown">
                                <span class="user-avatar">${loginUser.username}
                                    <i class="ti-angle-down f-s-10"></i>
                                </span>
                            <div class="drop-down dropdown-profile dropdown-menu dropdown-menu-right">
                                <div class="dropdown-content-body">
                                    <ul>
                                        <li>
                                            <a href="#">
                                                <i class="ti-settings"></i>
                                                <span>Setting</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <i class="ti-power-off"></i>
                                                <span>Logout</span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div style="width:800px;margin: 50px auto 0px auto">
    <form class="form-inline" action="" name="curdForm">
        <div class="form-group"style="margin: 0px 0px 0px 6px">
            <input type="text" class="form-control" placeholder="读者姓名" name="readername" value="${readername}">
        </div>
        <div class="form-group" style="margin: 0px 0px 0px 13px">
            <input type="text" class="form-control" placeholder="读者类型" name="readertype" value="${readertype}">
        </div>
        <div class="form-group" style="margin: 0px 0px 0px 13px">
            <input type="text" class="form-control" placeholder="性别" name="sex" value="${sex}">
        </div>
        <button type="submit" class="btn btn-default" style="margin: 0px 0px 0px 13px" onclick="queryReader()">查询</button>
        <button type="submit" class="btn btn-default" style="margin: 0px 0px 0px 13px" onclick="replaceReader()">修改</button>
        <div class="form-group"style="margin: 20px 0px 0px 6px">
            <input type="text" class="form-control" placeholder="手机" name="tel" value="${tel}">
        </div>
        <div class="form-group" style="margin: 20px 0px 0px 13px">
            <input type="number" class="form-control" placeholder="可借数量" name="max_num" value="${max_num}">
        </div>
        <div class="form-group" style="margin: 20px 0px 0px 13px">
            <input type="number" class="form-control" placeholder="可借天数" name="days_num" value="${days_num}">
        </div>
        <button type="submit" class="btn btn-default" style="margin: 20px 0px 0px 13px" onclick="addReader()">添加</button>
        <button type="reset" class="btn btn-default" style="margin: 20px 0px 0px 13px">重置</button>
    </form>
</div>
<div style="width:800px;margin: 30px auto 0px auto">
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>id</th>
            <th>读者姓名</th>
            <th>读者类型</th>
            <th>性别</th>
            <th>手机</th>
            <th>可借数量</th>
            <th>可借天数</th>
            <th>编辑</th>
            <th style="text-align: center">删除</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="#request.allReader">
            <tr>
                <th disabled="true"><s:property value="id"></s:property></th>
                <th><s:property value="readername"></s:property></th>
                <th><s:property value="readertype"></s:property></th>
                <th><s:property value="sex"></s:property></th>
                <th><s:property value="tel"></s:property></th>
                <th><s:property value="max_num"></s:property></th>
                <th><s:property value="days_num"></s:property></th>
                <th><a class="btn btn-default" href="${pageContext.request.contextPath}/reader_updateReader.action?id=<s:property value="id"></s:property>&readername=<s:property value="readername"></s:property>&readertype=<s:property value="readertype"></s:property>&sex=<s:property value="sex"></s:property>&tel=<s:property value="tel"></s:property>&max_num=<s:property value="max_num"></s:property>&days_num=<s:property value="days_num"></s:property>" role="button">编辑</a></th>
                <th><a class="btn btn-default" href="${pageContext.request.contextPath}/reader_deleteReader.action?deleteID=<s:property value="id"></s:property>" role="button">删除</a></th>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</div>


<!-- jquery vendor -->
<script src="assets/js/lib/jquery.min.js"></script>
<script src="assets/js/lib/jquery.nanoscroller.min.js"></script>
<!-- nano scroller -->
<script src="assets/js/lib/menubar/sidebar.js"></script>
<script src="assets/js/lib/preloader/pace.min.js"></script>
<!-- sidebar -->

<script src="assets/js/lib/bootstrap.min.js"></script><script src="assets/js/scripts.js"></script>
<!-- bootstrap -->

<script src="assets/js/lib/calendar-2/moment.latest.min.js"></script>
<script src="assets/js/lib/calendar-2/pignose.calendar.min.js"></script>
<script src="assets/js/lib/calendar-2/pignose.init.js"></script>


<script src="assets/js/lib/weather/jquery.simpleWeather.min.js"></script>
<script src="assets/js/lib/weather/weather-init.js"></script>
<script src="assets/js/lib/circle-progress/circle-progress.min.js"></script>
<script src="assets/js/lib/circle-progress/circle-progress-init.js"></script>
<script src="assets/js/lib/chartist/chartist.min.js"></script>
<script src="assets/js/lib/sparklinechart/jquery.sparkline.min.js"></script>
<script src="assets/js/lib/sparklinechart/sparkline.init.js"></script>
<script src="assets/js/lib/owl-carousel/owl.carousel.min.js"></script>
<script src="assets/js/lib/owl-carousel/owl.carousel-init.js"></script>
<!-- scripit init-->
<script src="assets/js/dashboard2.js"></script>
<script>
    function queryReader(){
        document.curdForm.action="${pageContext.request.contextPath}/reader_qbcReader.action";
        document.curdForm.submit();
    }
    function addReader() {
        document.curdForm.action = "${pageContext.request.contextPath}/reader_addReader.action";
        document.curdForm.submit();
    }
    function replaceReader() {
        document.curdForm.action = "${pageContext.request.contextPath}/reader_replaceReader.action";
        document.curdForm.submit();
    }

</script>
</body>

</html>
