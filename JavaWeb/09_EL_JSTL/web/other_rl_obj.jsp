<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/6/19
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    请输出参数username：${param.username}<br>
    请输出参数password：${param.password}<br>
    ${paramValues.username[0]}<br>

    <hr>
    输出请求头User-Agent的值:${header['User-Agent']}<br>
    输出请求头User-Agent的值:${headerValues['User-agent'][0]}

    <hr>
    ${cookie}<br>
    获取cookie的名称：${cookie.JSESSIONID.name}<br>
    获取cookie的值：${cookie.JSESSIONID.value}<br>
    获取cookie的名称：${cookie['Idea-aab6dae7'].name}<br>
    获取cookie的值：${cookie['Idea-aab6dae7'].value}<br>

    <hr>
    输出&lt;Context-param&gt;username的值:${initParam.username}<br>
    输出&lt;Context-param&gt;url的值:${initParam.url}

</body>
</html>
