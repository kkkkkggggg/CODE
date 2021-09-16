<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="com.atck.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/6/19
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
    iv. <c:forEach />
    作用：遍历输出使用。
    --%>

    <%--
        1.遍历1到10输出
            begin属性设置开始的索引
            end属性设置结束的索引
            var属性表示遍历的变量(也是当前正在遍历到的数据)
            for（int i = 1;i < 10;i++）
    --%>
<table border="1">

    <c:forEach begin="1" end="10" var="i">
        <tr>
            <td>第${i}行</td>
        </tr>
    </c:forEach>

</table>


    <%--2. 遍历 Object 数组
        for(Object : arr)
        items表示遍历的数据源（便利的集合）
        var表示当前遍历到的数据
    --%>
    <%
        String[] str = new String[]{"a","b","c","d"};
        request.setAttribute("str",str);
    %>
    <c:forEach items="${requestScope.str}" var="item">
        ${item}<br>
    </c:forEach>

    <%
        Map<String,Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        request.setAttribute("map",map);
    %>

    <c:forEach items="${requestScope.map}" var="entry">
        <h1>${entry.key} = ${entry.value}</h1>
    </c:forEach>

    <%--
    4. 遍历 List 集合---list 中存放 Student 类，有属性：编号，用户名，密码，年龄，
    电话信息
    --%>
    <%
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,"s1","s1",1,"s1"));
        list.add(new Student(2,"s2","s2",1,"s2"));
        list.add(new Student(3,"s3","s3",1,"s3"));
        list.add(new Student(4,"s4","s4",4,"s4"));
        request.setAttribute("list",list);
    %>
    <table border="1">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>密码</td>
            <td>年龄</td>
            <td>电话</td>
        </tr>
        <%--
        items表示遍历的集合
        var表示遍历到的数据
        begin 表示遍历开始的索引值
        end表示遍历结束的索引值
        step表示遍历的步长值
        varstatus表示当前遍历到的数据的状态
        --%>
    <c:forEach begin="2" end="3" varStatus="status" items="${requestScope.list}" var="stu">
            <tr>
                <td>${stu.id}</td>
                <td>${stu.username}</td>
                <td>${stu.password}</td>
                <td>${stu.age}</td>
                <td>${stu.phone}</td>
                <td>${status.begin}</td>

            </tr>
    </c:forEach>
    </table>
</body>
</html>
