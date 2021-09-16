<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/7/26
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        pageContext.setAttribute("ctp",request.getContextPath());
    %>
</head>
<body>
    <%--
        1)、文件上传；
                1、文件上传表单准备：enctype="multipart/form-data"
                2、导入fileupload：
                    commons-fileupload-1.2.1.jar
                    commons-io-2.0.jar
                3、javaweb
                object = new FileItemDiskFactory();
                ServletFileUpload upload = new ServletFileUpload(upload);

                List<FileItem> items = upload.parseRequest(upload);
                for(FileItem item : items)
                {
                    if(item.isFiled())
                    {
                        //普通项
                    }else
                    {
                        //文件项
                        IOUtils.copy();//文件保存
                    }
                }
                3、只要在SpringMVC配置文件中，编写一个配置，配置文件上传解析器（MultipartResolver）
                4、文件上传请求处理
                    在处理器方法上写一个
                        @RequestParam("headering") MultipartFile file，封装当前文件信息，可以直接保存
    --%>
    ${msg}
    <form action="${ctp}/upload" method="post" enctype="multipart/form-data">
        用户头像:<input type="file" name="headering"/><br/>
        用户头像:<input type="file" name="headering"/><br/>
        用户头像:<input type="file" name="headering"/><br/>
        用户头像:<input type="file" name="headering"/><br/>
        用户名:<input type="text" name="username"/><br/>
        <input type="submit" value="上传"/>
    </form>
</body>
</html>
