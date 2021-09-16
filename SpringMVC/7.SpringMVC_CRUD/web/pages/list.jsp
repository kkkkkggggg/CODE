<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/7/22
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="script/jquery-1.7.2.js">
    </script>
  </head>
  <body>
  <%
    pageContext.setAttribute("ctp",request.getContextPath());
  %>
    <table border="1" cellspacing="0" cellpadding="5" width="700">
      <tr>
        <th align="center" colspan="7">书籍列表</th>
      </tr>
      <tr>
        <th>书名</th>
        <th>作者</th>
        <th>价格</th>
        <th>库存</th>
        <th>销量</th>
        <th>删除</th>
        <th>修改</th>
      </tr>
    <c:forEach items="${requestScope.books}" var="book">
      <tr>
        <td>${book.name}</td>
        <td>${book.author}</td>
        <td>${book.price}</td>
        <td>${book.stock}</td>
        <td>${book.sales}</td>
        <td><a href="${ctp}/book/${book.id}" class="deleteBtn">删除</a></td>
        <td><a href="${ctp}/book/${book.id}">修改</a></td>
      </tr>
    </c:forEach>
    </table>
    <br/>
    <br/>
    <a href="toAddPage">添加员工</a>

  <form id="deleteForm" action="${ctp}/book/${book.id}" method="post">
    <input hidden type="text" name="_method" value="delete"/>
  </form>
  <script type="text/javascript">
    $(function () {
      $(".deleteBtn").click(function () {
        var choice = confirm("确定要删除吗？");
        if (choice)
        {
          //1.改变action指向
          $("#deleteForm").attr("action",this.href);
          //2.提交表单
          $("#deleteForm").submit();
        }
        return false;
      });
    });
  </script>
  </body>
</html>
