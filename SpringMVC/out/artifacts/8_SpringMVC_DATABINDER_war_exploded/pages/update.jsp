<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/7/23
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("cpt",request.getContextPath());
%>
    <h1>修改图书</h1>
    <%--modelAttribute：这个表单的所有内容显示绑定的是请求域中的book的值--%>
    <form:form action="${cpt}/book/${book.id}" modelAttribute="book" method="post">
        <input name="_method" value="put" hidden>
<%--        <input type="text" name="id" value="${book.id}" hidden>--%>
        书名:<form:input type="text" path="name"/><br/>
        作者:<form:input type="text" path="author"/><br/>
        价格:<form:input type="text" path="price"/><br/>
        销量:<form:input type="text" path="sales"/><br/>
        库存:<form:input type="text" path="stock"/><br/>
        <input type="submit" value="修改">
    </form:form>

</body>
</html>
