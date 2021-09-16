<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/7/20
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--  发起图书的增删改查请求，使用REST风格的URL地址
      请求URL  请求方式     含义
      /book/1 GET       :查询一号图书
      /book/1 DELETE    :删除一号图书
      /book/1 PUT       :更新一号图书
      /book   POST      :添加一号图书

从页面发起PUT、DELETE形式的请求？Spring提供了Rest风格的支持
1）、SpringMVC中有一个Filter：他可以把普通的请求转化为规定形式的请求
  <filter>
        <filter-name>hiddenHttpMethodFilter</filter-name>
        <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>hiddenHttpMethodFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
2）、如何发起其他形式请求
    按照以下要求：1、创建一个post类型的表单，表单中携带一个_method的参数，3、这个_method的值就是DELETE、PUT
--%>


<form action="book" method="post">
  <input type="submit" value="添加1号图书"/>
</form><br/>

<%--发送DELETE请求--%>
<form action="book/1" method="post">
  <input name="_method" value="delete" hidden>
  <input type="submit" value="删除1号图书"/>
</form><br/>

<%--发送PUT请求--%>
<form action="book/1" method="post">
  <input name="_method" value="put" hidden>
  <input type="submit" value="更新1号图书"/>
</form><br/>

<form action="book/1" method="get">
  <input type="submit" value="查询1号图书"/>
</form><br/>
  </body>
</html>
