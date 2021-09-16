<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/7/26
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--国际化--%>
    <h1><fmt:message key="welcomeinfo"/></h1>
    <form action="">
        <fmt:message key="username"/> :<input type="text" name="username"/><br/>
        <fmt:message key="password"/> :<input type="text" name="password"/><br/>
        <input type="submit" value="<fmt:message key="loginBtn"/>"/>
    </form>
<%--如果点击链接切换国际化--%>
<a href="toLoginPage?locale=zh_CN">中文</a><br/>
<a href="toLoginPage?locale=en_US">English</a><br/>
</body>
</html>
