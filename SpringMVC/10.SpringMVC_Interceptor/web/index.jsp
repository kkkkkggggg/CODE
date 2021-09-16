<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/7/26
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <%
      pageContext.setAttribute("ctp",request.getContextPath());
    %>
  </head>
  <body>
  <a href="${ctp}/test01">test01</a>
  </body>
</html>
