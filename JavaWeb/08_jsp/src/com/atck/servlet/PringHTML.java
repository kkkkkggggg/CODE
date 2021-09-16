package com.atck.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.*;

import java.io.IOException;
import java.io.PrintWriter;

public class PringHTML extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        //通过响应的回传流回传html页面数据
        //
        // <!DOCTYPE html>
        // <html lang="en">
        // <head>
        //     <meta charset="UTF-8">
        //     <title>Title</title>
        // </head>
        // <body>
        //     这是html页面数据
        // </body>
        // </html>
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<!DOCTYPE html>\r\n");
        writer.write("<html lang=\"en\">\r\n");
        writer.write("<head>\r\n");
        writer.write("<meta charset=\"UTF-8\">\r\n");
        writer.write("<title>Title</title>\r\n");
        writer.write("</head>\r\n");
        writer.write("<body>\r\n");
        writer.write("这是html页面数据\r\n");
        writer.write("</body>\r\n");
        writer.write("</html>\r\n");
        // writer.write("这是后打开手机电话卡就是的黑科技");
    }
}
