<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
	<%--静态包含base标签、css样式、jquery文件--%>
	<%@include file="/pages/common/head.jsp"%>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">订单管理系统</span>
			<%--静态绑定后台管理相同页面内容--%>
			<%@include file="/pages/common/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>用户ID</td>
				<td>订单号</td>
				<td>日期</td>
				<td>金额</td>
				<td>订单状态</td>
				<td>详情</td>
				<td>发货</td>
			</tr>
			<c:forEach items="${sessionScope.allOrders}" var="order">
				<tr>
					<td>${order.userId}</td>
					<td>${order.orderId}</td>
					<td>${order.createTime}</td>
					<td>${order.price}</td>
					<td><a href="orderServlet?action=showOrderDetail&orderId=${order.orderId}">查看详情</a></td>
					<c:choose>
						<c:when test="${order.status == 0}">
							<td>未发货</td>
							<td><a href="orderServlet?action=sendOrder&orderId=${order.orderId}">点击发货</a></td>
						</c:when>
						<c:when test="${order.status == 1}">
							<td>已发货</td>
							<td>订单已发货</td>
						</c:when>
						<c:when test="${order.status == 2}">
							<td>已签收</td>
							<td>订单已签收</td>
						</c:when>
					</c:choose>
				</tr>
			</c:forEach>
		</table>
	</div>

	<%--静态包含页面底部标签--%>
	<%@include file="/pages/common/bottom.jsp"%>
</body>
</html>