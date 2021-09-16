<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/6/19
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--i.<c.set/>
        作用：set标签可以往域中保存数据
        域对象.setAttribute(key,value);
        scope属性设置保存到哪个域
            page属性表示pageContext域
            request表示request域
            session表示session域
            application表示application域
        key是多少
        value是多少
        --%>

    保存之前：${pageScope.abc}<br>
    <c:set scope="page" var="abc" value="abcValue"/>
    保存之后：${pageScope.abc}<br>

    <%--ii. <c:if />
        if 标签用来做 if 判断。--%>
    <c:if test="${12==12}">
        <h1>12等于12</h1>
    </c:if>

    <%--
    iii. <c:choose> <c:when> <c:otherwise>标签
    作用：多路判断。跟 switch ... case .... default 非常接近

    choose标签开始选择判断
    when标签表示每一种判断情况
        test表示当前这种判断的值
    otherwise标签表示剩下的情况

    <c:choose> <c:when> <c:otherwise> 标签使用时需要注意的点
        1.标签里不能使用html注释,要使用jsp注释
        2.when标签的父标签一定要是choose标签
    --%>
    <%
        request.setAttribute("height",178);
    %>

    <c:choose>

        <c:when test="${height > 190}">
            <h2>小巨人</h2>
        </c:when>

        <c:when test="${height > 180}">
            <h2>很高</h2>
        </c:when>

        <c:when test="${height > 170}">
            <h2>还可以</h2>
        </c:when>

        <c:otherwise>
            <h2>剩下小于170的情况</h2>
        </c:otherwise>
    </c:choose>


</body>
</html>
