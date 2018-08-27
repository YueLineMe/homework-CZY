
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/bootstrap.css">
</head>
<body>
<form action="MyServlet?action=del" method="post">
    <table class="table table-striped" id="tab">
        <tr>
            <th><input type="checkbox" onclick="alls(this)"></th>
            <th>id</th>
            <th>书名</th>
            <th>价格</th>
            <th>作者</th>
            <th>出版社</th>
            <th>其他</th>
        </tr>
    </table>
    <div style="margin-top: 2em;">
        <input type="submit" value="删除" class="btn btn-success">
        <a href="/book/add">增加新的书籍</a>
        <br/>
        <br/>
    </div>

</form>

<script src="../js/jquery-1.11.3.js"></script>
<script>
    $(function () {
        $.ajax({
            url: "Myservlet?action=SelectAll",
            type:"post",
            success:function (data) {
                var tr=$("<tr/>");
                tr.append("<td><input name='id' value=" + data.Id + " type='checkbox'></td>");
                tr.append("<td>"+data.Id+"</td>");
                tr.append("<td>"+data.name+"</td>");
                tr.append("<td>"+data.description+"</td>");
                tr.append("<td>"+data.price+"</td>");
                tr.append("<td><a href=\"Myservlet?action=del&Id="+data.Id+"\">删除</a> " +
                    "      <a href=\"BookContro?action=update&Id="+data.Id+"\">更改</a></td>");
            }
        });
    })
</script>
</body>
</html>
