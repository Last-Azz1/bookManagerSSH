<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Focus Admin: Widget</title>

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
    <link href="assets/css/lib/font-awesome.min.css" rel="stylesheet">
    <link href="assets/css/lib/themify-icons.css" rel="stylesheet">
    <link href="assets/css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/lib/helper.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
</head>

<body class="bg-primary">

<div class="unix-login">
    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="col-lg-6">
                <div class="login-content">
                    <div class="login-logo">
                        <a href="index.jsp"><span>图书管理系统</span></a>
                    </div>
                    <div class="login-form">
                        <h4>登录</h4>
                        <form action="${pageContext.request.contextPath}/user_login.action" method="post">
                            <div class="form-group">
                                <input type="text" name="username" class="form-control" placeholder="ID">
                            </div>
                            <div class="form-group">
                                <input type="password" name="password" class="form-control" placeholder="Password">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> 记住密码
                                </label>
                                <label class="pull-right">
                                    <a href="#">忘记密码?</a>
                                </label>

                            </div>
                            <button type="submit" class="btn btn-primary btn-flat m-b-30 m-t-30">登录</button>
                            <div style="width: 200px;margin: 0px auto;font-size: 16px;font-weight: bold;color: #0c0c0c"><s:actionerror></s:actionerror></div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

</html>