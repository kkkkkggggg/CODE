<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/7/19
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="hello01">hello01请求</a>
  <br/>
  RequestMappingTest
  <br/>
  <a href="haha/hello01">RequestMapping注解使用在类上的测试</a><br>

  测试RequestMapping的其他属性 <br>

  <a href="haha/hello02">hello02请求-测试methods</a><br>

  <form action="haha/hello02" method="post">
    <input type="submit" />
  </form>
  <br>
  <br>

  <a href="haha/hello03">hello03请求-测试params</a><br/>

  <a href="haha/hello04">hello04请求-测试headers</a><br/>
  
  <hr/>
  <h1>RequestMapping-Ant风格的URL</h1>
  <a href="antTest01">精确请求地址-antTest01</a><br/>

  <a href="user">测试PathVariable</a>

  </body>
</html>
