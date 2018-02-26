<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--ctxPath 例如:http://localhost:8080/MyApp/ --%>
<c:set var="ctxPath" value="${pageContext.request.contextPath}" />
<%--项目路径 --%>
<c:set var="path" value="${ctxPath}" />
<%--静态文件目录 --%>
<c:set var="staticPath" value="${ctxPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>书阁</title>
    <!-- Bootstrap Core CSS -->
    <link href="${staticPath }/css/bootstrap.min.css" rel="stylesheet">
    <!-- DataTables CSS -->
    <link href="${staticPath }/css/dataTables.bootstrap.css" rel="stylesheet">
    <!-- self-define CSS -->
    <link href="${staticPath }/css/self.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">注册</h3>
                </div>
                <div class="panel-body">
                    <form id="registerform"  method="post">
                        <div class="form-group">
                            <input class="form-control" placeholder="用户名" name="username" id="username" autofocus>
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="密码" name="password" id="password" type="password">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="再次输入密码" name="repeatpassword" id="repeatpassword" type="password">
                        </div>
                        <input id="register" type="button" value="注册" class="btn btn-primary form-control">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${staticPath }/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${staticPath }/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${staticPath}/js/login.js?v=2018.1.15"></script>
</body>
</html>

