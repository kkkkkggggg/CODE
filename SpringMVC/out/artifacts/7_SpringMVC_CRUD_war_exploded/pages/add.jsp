<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/7/23
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>
<body>
    <table border="1" width="700" cellspacing="0" cellpadding="5">
        <tr>
            <th colspan="7" align="center">添加员工</th>
        </tr>
    </table>

    <form action="${ctp}/book" method="post">
        书名:<input type="text" name="name"/><br/>
        作者:<input type="text" name="name"/><br/>
        价格:<input type="text" name="name"/><br/>
        销量:<input type="text" name="name"/><br/>
        库存:<input type="text" name="name"/><br/>
        <input type="submit" value="添加">
    </form>

    <!--
    表单标签：
    通过SpringMVC的表单标签可以实现将模型数据中的属性和HTML表单元素相绑定，以实现表单数据更便捷编辑和表单值的回显
    -->
    <%--<form:form action="${ctp }/emp" modelAttribute="employee" method="POST">
        <!-- path就是原来html-input的name项：需要写
        path：
        1）、当做原生的name项
        2）、自动回显隐含模型中某个对象对应的这个属性的值
        -->
        lastName:<form:input path="lastName"/><br/>
        email:<form:input path="email"/><br/>
        gender:<br/>
        男：<form:radiobutton path="gender" value="1"/><br/>
        女：<form:radiobutton path="gender" value="0"/><br/>
        dept:
        <!--
        items=""：指定要遍历的集合 ；自动遍历；遍历出的每一个元素是一个department对象
        itemLabel="属性名"：指定遍历出的这个对象的哪个属性是作为option标签体的值
        itemValue="属性名"：指定刚才遍历出来的这个对象的哪个属性是作为要提交 的value值
        -->
        <form:select path="department.id"
                     items="${depts }"
                     itemLabel="departmentName"
                     itemValue="id"></form:select><br/>
        <input type="submit" value="保存"/>
    </form:form>--%>
</body>
</html>
