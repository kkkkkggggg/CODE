<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/6/17
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%

        out.write("out输出一<br/>");
        out.write("out输出二<br/>");

        out.flush();

        response.getWriter().write("response输出1<br/>");
        response.getWriter().write("response输出2<br/>");


    %>
</body>
</html>
