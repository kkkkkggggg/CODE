<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/7/20
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>成功</h1>
<%--    请求域中：<%=request.getAttribute("reqParam")%><br/>--%>
<%--    session域中：<%=session.getAttribute("sessionParam")%><br/>--%>

    请求域中：${requestScope.reqParam}<br/>
    session域中：${sessionScope.sessionParam}<br/>
</body>
</html>
