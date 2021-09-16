<%@ page import="java.util.List" %>
<%@ page import="com.atck.pojo.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/6/18
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table
        {
            border: 1px black solid;
            width: 600px;
            border-collapse: collapse;
        }

        tr,td
        {
            border: 1px black solid;
        }
    </style>
</head>
<body>
    <%
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            int t = i + 1;
            list.add(new Student(t,"name" + t,18 + t,"phone" + t));
        }
    %>

    <table>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>电话</td>
            <td>操作</td>
        </tr>
        <%for(Student student : list){%>
        <tr>
            <td><%=student.getId()%></td>
            <td><%=student.getName()%></td>
            <td><%=student.getAge()%></td>
            <td><%=student.getPhone()%></td>
            <td>删除/修改</td>
        </tr>
        <%}%>
    </table>
</body>
</html>
