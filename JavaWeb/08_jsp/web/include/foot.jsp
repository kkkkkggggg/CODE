<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/6/17
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    页脚信息<br>
    修改<br>
    <%
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
    %>
    <%=request.getParameter("username")%>

</body>
</html>
