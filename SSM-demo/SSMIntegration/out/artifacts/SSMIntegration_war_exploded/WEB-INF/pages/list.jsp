<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/8/2
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table cellpadding="5" cellspacing="0" border="1">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>course</th>
            <th>address</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="teacher">
            <tr>
                <td>${teacher.id}</td>
                <td>${teacher.name}</td>
                <td>${teacher.course}</td>
                <td>${teacher.address}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4">
                <a href="getall">首页</a>
                <a href="getall?pageNo=${pageInfo.prePage}">上一页</a>
                <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                    <c:if test="${num == pageInfo.pageNum}">
                        【${num}】
                    </c:if>
                    <c:if test="${num != pageInfo.pageNum}">
                        <a href="getall?pageNo=${num}">${num}</a>
                    </c:if>
                </c:forEach>
                <a href="getall?pageNo=${pageInfo.nextPage}">下一页</a>
                <a href="getall?pageNo=${pageInfo.pages}">末页</a>
            </td>
        </tr>
    </table>
</body>
</html>
