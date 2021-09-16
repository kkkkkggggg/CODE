<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/6/19
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","request");
        session.setAttribute("key","session");
        application.setAttribute("key","application");

    %>

    ${applicationScope.key}
</body>
</html>
