<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/6/19
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--request.getScheme()可以获取请求的协议--%>
    <%=request.getScheme()%><br>

    1.协议：${pageContext.request.scheme}<br>
    2.服务器IP：${pageContext.request.serverName}<br>
    3.服务器端口：${pageContext.request.serverPort}<br>
    4.获取工程路径：${pageContext.request.contextPath}<br>
    5.获取请求方法：${pageContext.request.method}<br>
    6.获取客户端ip地址：${pageContext.request.remoteHost}<br>
    7.获取会话的id编号：${pageContext.session.id}<br>
</body>
</html>
