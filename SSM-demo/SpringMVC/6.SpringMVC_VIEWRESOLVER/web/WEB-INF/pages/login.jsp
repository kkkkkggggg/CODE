<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/7/22
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>
        <fmt:message key="welcomeinfo"/>
    </h1>
    <form action="">
        <fmt:message key="username" />：<input/><br/>
        <fmt:message key="password"/>：<input/><br/>
        <input type="submit" value='<fmt:message key="loginBtn"/>'/><br/>
    </form>
</body>
</html>
