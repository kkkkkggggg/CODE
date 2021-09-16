<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/6/26
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/13_cookie_session/">
</head>
<body>
    <form action="cookieServlet">
        <input type="hidden" name="action" value="login" >
        <input type="text" name="username" value="${requestScope.username}">
        <input type="text" name="password" value="">
        <input type="submit" value="登录">
    </form>
</body>
</html>
