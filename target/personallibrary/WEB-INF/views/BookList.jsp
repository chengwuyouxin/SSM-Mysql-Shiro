<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/common/nav.jsp" %>

<div class="body-wrapper">
    <div class="container-fluid">
        <div>
            <h1 class="page-header">现存图书列表</h1>
        </div>
        <div class="panel-heading">
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        书单
                    </div>
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                <tr>
                                    <th>书名</th>
                                    <th>作者</th>
                                    <th>出版社</th>
                                    <th>版次</th>
                                    <th>价格</th>
                                    <th>购买日期</th>
                                    <th>类别</th>
                                    <th>简介</th>
                                    <th>操作</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${books}" var="book">
                                    <tr>
                                        <td>${book.title}</td>
                                        <td>${book.author}</td>
                                        <td>${book.press}</td>
                                        <td>${book.edition}</td>
                                        <td>${book.price}</td>
                                        <td>${book.buy_date}</td>
                                        <td>${book.category}</td>
                                        <td>${book.description}</td>
                                        <td><a href="${ctxPath}/edit-book/${book.id}">修改</a></td>
                                        <td><a href="${ctxPath}/delete-book/${book.id}">删除</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <a href="${ctxPath}/input-book">添加图书</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/common/bottom.jsp" %>