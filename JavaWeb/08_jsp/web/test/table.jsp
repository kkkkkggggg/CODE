<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/6/18
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            width: 650px;
        }
    </style>
</head>
<body>
    <h1 align="center">九九乘法口诀表</h1>
    <table align="center">
    <%for (int i = 1; i <= 9; i++){%>
        <tr>
            <%for (int j = 1; j <= i; j++) {%>
            <td><%=i + "*" + j + "=" + (i * j)%></td>

    <%}%>
        </tr>
        <%}%>
    </table>
</body>
</html>
