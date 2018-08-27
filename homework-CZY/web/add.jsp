<%@ page import="entity.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrap-theme.css">

</head>
<body>
<div style="margin: auto;width: 600px;margin-top: 50px;">
    <form action="Myservlet?action=add" class="form-horizontal" method="post">
        <div><input type="text" name="Id" placeholder="ID"></div>
        <div><input type="text" name="name" placeholder="名称"></div>
        <div><input type="text" name="price" placeholder="价格"></div>
        <div><input type="text" name="description" placeholder="描述"></div>
        <div><input type="submit" class="submit"></div>
</form>
    <button class="btn" onclick="javascript:history.back(-1);">返回</button>
</div>
<script src="js/jquery-1.11.3.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>
