<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/6/16
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--1、声明类的属性--%>
    <%!
        private Integer id;
        private String name;
        private static Map<String,Object> map;
    %>

    <%--2、声明static静态代码块--%>

    <%!
        static
        {
            map = new HashMap<String,Object>();
            map.put("key1","value1");
            map.put("key2","value2");
            map.put("key3","value3");
            map.put("key4","value4");
        }

    %>

    <%--3、声明类方法--%>
    <%!
        public void abc()
        {

        }
    %>

    <%--4、声明内部类--%>
    <%!
        public static class A
        {
            private Integer id = 12;
            private  String abc;
        }
    %>

    <%--表达式脚本--%>
    <%--1、输出整型--%>
    <%=12%>
    <%--2、输出浮点型--%>
    <%=12.2%>
    <%--3、输出字符串--%>
    <%="我是字符串"%>
    <%--4、输出对象--%>
    <%=this%>
<%--    <%=request.getParameter("username")%>--%>


    <%--代码脚本--%>
    <%--1.if语句--%>
    <%
        int i = 12;
        if (i == 13)
        {
            System.out.println(12);
        }else
        {
            System.out.println(2);
        }
    %>
    <%--2.for循环语句--%>
    <table border="1" cellspacing="0">
    <%
        for (int j = 0; j < 5; j++)
        {
    %>
        <tr>
            <td><%=j + 1%><br></td>
        </tr>
    <%
        }
    %>
    </table>
    <%--3.翻译后java文件中——jspService方法内的代码都可以写--%>
    <%
        System.out.println(request.getParameter("username"));
    %>
</body>
</html>
