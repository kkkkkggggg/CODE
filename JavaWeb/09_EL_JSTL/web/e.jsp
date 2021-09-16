<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/6/19
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //1.值为null的时候，为空
        request.setAttribute("isnull",1);
        //2.值为空串的时候，为空
        request.setAttribute("emptyStr","");
        //3.值是Object类型数组，长度为零的时候
        request.setAttribute("emptyArr",new Object[]{});
        //4.list集合，元素个数为零
        List list = new ArrayList<>();
        request.setAttribute("emptyList",list);
        //5.map集合，元素个数为零
        Map map = new HashMap<>();
        request.setAttribute("emptyMap",map);
    %>

    ${empty isnull}<br>
    ${empty emptyStr}<br>
    ${empty emptyArr}<br>
    ${empty emptyList}<br>
    ${empty emptyMap}<br>


</body>
</html>
