package com.atck.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ImageServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //1.先判断上传的数据是否是多端数据（只有是多段的数，才是文件上传的）
        if(ServletFileUpload.isMultipartContent(req))
        {
            //创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类ServletfileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            try
            {
                //解析上传的数据，得到每一个表单项FileItem
                List<FileItem> list = servletFileUpload.parseRequest(req);
                //循环判断每一个表单项，是普通类型，还是上传的文件
                for (FileItem file : list)
                {
                    if (file.isFormField())
                    {
                        //普通表单项
                        System.out.println("表单项的name属性值：" + file.getFieldName());
                        //参数UTF-8解决乱码问题
                        System.out.println("表单项的value属性值" + file.getString("UTF-8"));
                    }else
                    {
                        //上传的文件
                        System.out.println("表单项的name属性值：" + file.getFieldName());
                        System.out.println("上传的文件名:" + file.getName());

                        file.write(new File("e:\\" + file.getName()));
                    }
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
