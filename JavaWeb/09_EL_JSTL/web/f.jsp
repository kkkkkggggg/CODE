<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/6/19
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Map<String,Object> map = new HashMap<>();
        map.put("a.a.a","aaaValue");
        map.put("bbb","bbbValue");
        map.put("ccc","cccValue");

        request.setAttribute("map",map);
    %>

    ${map['a.a.a']}
</body>
</html>
