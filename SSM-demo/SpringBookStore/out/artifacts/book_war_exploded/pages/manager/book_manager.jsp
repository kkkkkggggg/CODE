<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%--静态包含base标签、css样式、jquery文件--%>
	<%@include file="/pages/common/head.jsp"%>

	<script type="text/javascript">
		//给删除的a标签绑定单击事件，用于删除的确认提示操作
		$(function () {
			$("a.deleteClass").click(function () {
				//在事件的function函数中，有一个this对象，这个this对象，是当前正在响应时间的dom对象
				/**
				 * confirm是确认提示款函数
				 * 参数是它提示的内容
				 * 他有两个按钮，一个确认，一个是取消
				 * 返回true表示点击了确认，返回false表示点击了取消
				 * return false 阻止元素的默认行为==不提交请求
				 */
				return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】？");

			});
		});


	</script>
</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
		<%--静态绑定后台管理相同页面内容--%>
		<%@include file="/pages/common/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>		
			<c:forEach items="${requestScope.page.items}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
<%--					<td><a href="pages/manager/book_edit.jsp?action=update&id=${book.id}&name=${book.name}&price=${book.price}&author=${book.price}--%>
<%--								&sales=${book.sales}&stock=${book.stock}">修改</a></td>--%>
					<td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>

					<td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.items.size() > 1 ? requestScope.page.pageTotal : requestScope.page.pageTotal - 1}">删除</a></td>
				</tr>
			</c:forEach>
			

			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotalCount % requestScope.page.pageSize == 0 ? requestScope.page.pageTotal + 1 : requestScope.page.pageTotal}">添加图书</a></td>
			</tr>

		</table>

		<%@include file="/pages/common/page_nav.jsp"%>

	</div>

	<%--静态包含页面底部标签--%>
	<%@include file="/pages/common/bottom.jsp"%>
</body>
</html>