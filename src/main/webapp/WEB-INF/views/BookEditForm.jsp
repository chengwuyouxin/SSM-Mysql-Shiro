<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/common/nav.jsp"></jsp:include>

<div class="body-wrapper">
    <div class="container-fluid">
        <div>
            <h1 class="page-header">书籍管理</h1>
        </div>
        <div class="panel-heading">
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        修改书籍信息
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <c:url var="formaction" value="${ctxPath}/update-book"></c:url>
                            <form:form modelAttribute="book" action="${formaction}" method="post">
                                <form:hidden path="id"/>
                                <div class="form-group" >
                                    <label for="title" class="control-label">书名: </label>
                                    <form:input id="title" path="title" class="form-control"/>
                                </div>
                                <div clas="form-group">
                                    <label for="author" class="control-label">作者: </label>
                                    <form:input id="author" path="author" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label for="press" class="control-label">出版社: </label>
                                    <form:input id="press" path="press" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label for="edition" class="control-label">版次: </label>
                                    <form:input id="edition" path="edition" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label for="price" class="control-label">价格: </label>
                                    <form:input id="price" path="price" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label for="buy_date" class="control-label">购买日期: </label>
                                    <form:input id="buy_date" path="buy_date" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label for="category" class="control-label">类别: </label>
                                    <form:input id="category"  path="category" class="form-control"/>
                                </div>
                                <div clsss="form-group">
                                    <label for="description" class="control-label">简介: </label>
                                    <form:input id="description" path="description" class="form-control"/>
                                </div>
                                <div class="panel-heading">
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary form-control">修改</button>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/common/bottom.jsp"></jsp:include>