<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        a {
            text-decoration: none;
            color: black;
            font-size: 18px;
        }
        h3 {
            width: 180px;
            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
            background: deepskyblue;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<%--${pageContext.request.contextPath}取得当前项目名称--%>
<%--假定你的web应用名称为hotel,这个hotel就是当前的项目名称,不过你在浏览器中输入请求路径时，例如输入http//:localhost:8080/hotel/login.jsp--%>
<%--就是从这个请求路径(URL)上截取/hotel--%>
<%--而这个“/”代表的是"http//:localhost:8080"--%>
<h3>
    <a href="${pageContext.request.contextPath}/book/allBook">进入书籍页面</a>
</h3>
</body>
</html>
