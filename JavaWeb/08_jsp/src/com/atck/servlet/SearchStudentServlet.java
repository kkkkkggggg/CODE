package com.atck.servlet;

import com.atck.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchStudentServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    //    获取请求的参数
    //     发sql语句查询学生信息
    //    使用for循环生成查询到的数据做模拟
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            int t = i + 1;
            list.add(new Student(t,"name" + t,18 + t,"phone" + t));
        }
    //    保存查询到的结果（学生信息）到request域中
        req.setAttribute("studentList",list);
    //    请求转发到showStudent.jsp页面
        req.getRequestDispatcher("/test/showstudent.jsp").forward(req,resp);
    }
}
