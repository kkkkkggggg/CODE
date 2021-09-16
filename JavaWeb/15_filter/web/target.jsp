<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/7/5
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        System.out.println("target.jsp页面执行了");
        System.out.println("目标资源的线程" + Thread.currentThread().getName());
        System.out.println("目标资源" + request.getParameter("username"));
    %>
target.jsp页面
</body>
</html>
