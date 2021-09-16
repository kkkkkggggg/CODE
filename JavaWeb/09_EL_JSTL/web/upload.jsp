<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/6/19
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
1、要有一个 form 标签，method=post 请求
2、form 标签的 encType 属性值必须为 multipart/form-data 值
3、在 form 标签中使用 input type=file 添加上传的文件
4、编写服务器代码（Servlet 程序）接收，处理上传的数据。
encType=multipart/form-data 表示提交的数据，以多段（每一个表单项一个数据段）的形式进行拼
接，然后以二进制流的形式发送给服务器
--%>
    <form action="http://localhost:8080/09_EL_JSTL/imageServlet" method="post" enctype="multipart/form-data">
        用户名：<input type="text" name="username"/><br>
        头像：<input type="file" name="photo"><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
