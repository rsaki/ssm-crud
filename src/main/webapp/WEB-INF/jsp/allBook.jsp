<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>书籍列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--引入Bootstrap-->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    <%--引入jQuery--%>
    <script src="../../statics/js/jquery-3.5.1.min.js"></script>
    <script>
        function check1(){
            if (confirm("确认要删除吗？")){
                return true;
            }else {
                return false;
            }
        }

/*       前端验证没卵用
            function check2() {
            var query_key = document.getElementById('query_key');
            if (query_key.value.length < 2) {
                $("#error").text("关键字长度不能小于2个字符!")
                query_key.value = "";
                query_key.focus();
                return false;
            }
        }*/
    </script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表--显示所有书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增书籍</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">显示全部书籍</a>
        </div>
        <div class="col-md-4 column"></div>
        <div class="col-md-4 column" style="width: 300px">
            <form class="form-inline" action="${pageContext.request.contextPath}/book/queryBook" method="post"
                  style="float: right">
            <span style="color:red;font-weight: bold" id="error">${error}</span>
                <input type="text" id="query_key" name="queryBookName" class="form-control" placeholder="输入查询书名" required>
                <input type="submit" value="查询"  class="btn btn-primary">
            </form>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名字</th>
                    <th>书籍数量</th>
                    <th>书籍详情</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${list}">
                    <tr>
                        <td>${book.bookId}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookCounts}</td>
                        <td>${book.detail}</td>
                        <td>
                        <a href="${pageContext.request.contextPath}/book/toUpdateBook/${book.getBookId()}">更改</a>&nbsp;|
                        <a href="${pageContext.request.contextPath}/book/deleteBook?id=${book.getBookId()}" onclick="javascript:return check1()">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>

