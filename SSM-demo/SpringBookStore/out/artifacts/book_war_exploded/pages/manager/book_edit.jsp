<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
	<%--静态包含base标签、css样式、jquery文件--%>
	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
			<%--静态绑定后台管理相同页面内容--%>
			<%@include file="/pages/common/manager_menu.jsp"%>
		</div>
		
		<div id="main">
			<%--<form action="manager/bookServlet?pageNo=${empty requestScope.book ? param.pageNo : requestScope.pageNo}" method="post">--%>
			<form action="manager/bookServlet?pageNo=${param.pageNo}" method="post">

				<input type="hidden" name="action" value="${empty requestScope.book ? "add" : "update"}"/>
				<input type="hidden" name="id" value="${requestScope.book.id}"/>
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>

						<td><input name="name" type="text" value="${empty requestScope.book.name ? "时间简史":requestScope.book.name}"/></td>
						<td><input name="price" type="text" value="${empty requestScope.book.price ? "30.00":requestScope.book.price}"/></td>
						<td><input name="author" type="text" value="${empty requestScope.book.author ? "霍金":requestScope.book.author}"/></td>
						<td><input name="sales" type="text" value="${empty requestScope.book.sales ? "200":requestScope.book.sales}"/></td>
						<td><input name="stock" type="text" value="${empty requestScope.book.stock ? "300":requestScope.book.stock}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>

		<%--静态包含页面底部标签--%>
		<%@include file="/pages/common/bottom.jsp"%>
</body>
</html>