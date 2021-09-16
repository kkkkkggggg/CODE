<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/7/21
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>成功</h1>
    pageContext域中：${pageScope.msg}<br/>
    session域中：${sessionScope.msg}<br/>
    request域中：${requestScope.msg}<br/>
    application域中：${applicationScope.msg}<br/>
    <%
        System.out.println("------------------success-----------------");
        System.out.println("目标方法运行了");
    %>
</body>
</html>
