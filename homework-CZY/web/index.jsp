<%@ page import="dao.Productdao" %>
<%@ page import="entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap-theme.css">
</head>
<body>
<div style="margin: auto;width: 600px;margin-top: 50px;">
    <form class="form-search form-horizontal" action="BookContro?action=selectName" style="float: right;" method="post">
        <input type="text"  placeholder="查询条件(名字)" name="name">
        <input type="submit" class="submit" value="搜索">
    </form>
    <table cellpadding="0" cellspacing="0" border="1" style="text-align:center;" class="table table-striped">
        <tr>
            <th>ID</th>
            <th>名称</th>
            <th>价格</th>
            <th>描述</th>
            <th>操作</th>
        </tr>

        <c:forEach  items="${Product}" var="item" >
            <tr>
                <td><c:out value="${item.id}"></c:out>
                </td>
                <td>
                    <c:out  value="${item.name}"></c:out>
                </td>
                <td><c:out value="${item.price}"></c:out>
                </td>
                <td><c:out value="${item.description}"></c:out>
                </td>
                <td><c:out value="${item.press}"></c:out>
                </td>
                <td><a href="MyServlet?action=del&Id=<c:out value="${item.id}"></c:out>">删除</a> <a
                        href="MyServlet?action=chageing&Id=<c:out value="${item.id}"></c:out>">更改</a></td>
            </tr>

        </c:forEach>

    </table>

    <a href="MyServlet?action=prepare_add" style="margin-top: 25px;">添加</a>

</div>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</body>
</html>
