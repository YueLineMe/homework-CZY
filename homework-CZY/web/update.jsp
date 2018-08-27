<%@ page import="entity.Product" %>
<%@ page import="dao.Productdao" %>

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
    <div><input type="text" name="name" placeholder="name" value="<c:out value="${products.name}"></c:out>"></div>
    <div><input type="number" step="0.01" name="price" placeholder="price"
                value="<c:out value="${products.price}"></c:out>"></div>
    <div><input type="text" name="description" placeholder="author" value="<c:out value="${products.description}"></c:out>"></div>
    <div><input type="hidden" name="Id" value="<c:out value="${products.id}"></c:out>"></div>
    <div><input type="submit" value="提交更新" id="btnupdate"></div>
    <button class="btn" onclick="javascript:history.back(-1);">返回</button>


    <span data-toggle="modal" data-target="#myModal" id="dialog"></span>
    <button class="btn btn-info" type="button" id="y-modalBtnAdd" style="display: none;"><label>添加</label></button>
    <!-- 模态弹出窗内容 -->
    <div class="modal" id="y-myModalAdd" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">×</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title">提示</h4>
                </div>
                <div class="modal-body">
                    <p id="msg">Loading……</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>
    <!--js代码-->
    <script src="js/jquery-1.11.3.js"></script>


</div>
<script src="js/bootstrap.js"></script>
<script>
    $(function () {
        $("#btnupdate").click(function () {
            $.ajax({
                url: "MyServlet?action=update",
                type: "post",
                data: {
                    Id: $("input[name='Id']").val(),
                    name: $("input[name='name']").val(),
                    price: $("input[name='price']").val(),
                    description: $("input[name='description']").val()
                },
                success: function (data) {
                    $("#msg").text(data.msg);
                    console.log(data.book);
                    var $m_btn = $('#y-modalBtnAdd'); //y-modalBtnAdd是button的id
                    var $modal = $('#y-myModalAdd'); //y-myModalAdd是弹出的遮罩层的id，通过这两个id进行绑定
                    $m_btn.on('click', function () {
                        $modal.modal({backdrop: 'static'});
                    });
                    $m_btn.click();

                    $("input[name='Id']").val(data.Product.Id);
                    $("input[name='name']").val(data.Product.name);
                    $("input[name='price']").val(data.Product.price);
                    $("input[name='description']").val(data.Product.description);
                }
            })

        });
    })
</script>
</body>
</html>
