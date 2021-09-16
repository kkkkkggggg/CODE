package com.atck.servlet;



import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Download extends HttpServlet
{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //1.获取要下载的文件名
        String downloadFileName = "5857a2c72eb88.jpg";

        //2.读取要下载的文件内容(通过ServletContext对象可以读取)
        ServletContext servletContext = getServletContext();

        //获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);


        //4.在回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);

        //5.还要告诉客户端收到的数据是用于下载使用（还是使用响应头）
        //Content-Disposition响应头，表示收到的数据怎么处理
        //attachment表示附件，表示下载使用，filename=表示指定下载的文件名
        if (req.getHeader("User-Agent").contains("Firefox"))
        {
            //如果是火狐浏览器使用Base64编码
            resp.setHeader("Content-Disposition","attachment;filename==?UTF-8?B?" + new BASE64Encoder().encode("中国.jpg".getBytes("UTF-8")) + "?=");


        }else
        {
            //不是火狐浏览器，使用url编码
            // resp.setHeader("Content-Disposition","attachment;filename=" + downloadFileName);
            resp.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode("中国.jpg","UTF-8"));
        }



        /*
        /斜杠被服务器解析表示地址为http://ip:port/工程名/ 映射到代码的web目录
        * */
        InputStream inputStream = servletContext.getResourceAsStream("/file/" + downloadFileName);

        //3.把要下载的文件回传给客户端
        //获取响应的输出流
        OutputStream outputStream = resp.getOutputStream();
        //读取输入流中全部的数据，复制给输出流去输出
        IOUtils.copy(inputStream,outputStream);



    }
}
