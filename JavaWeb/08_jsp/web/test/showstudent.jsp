<%@ page import="java.util.List" %>
<%@ page import="com.atck.pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/6/18
  Time: 15:35
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
            border-collapse: collapse;
            width: 500px;
        }

        tr,td
        {
            border: 1px black solid;

        }
    </style>
</head>
<body>
    <%List<Student> studentList = (List<Student>) request.getAttribute("studentList");%>
    <table>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>电话</td>
        </tr>
        <%for (Student student : studentList){%>
        <tr>
            <td><%=student.getId()%></td>
            <td><%=student.getName()%></td>
            <td><%=student.getAge()%></td>
            <td><%=student.getPhone()%></td>
        </tr>
        <%}%>
    </table>
</body>
</html>
