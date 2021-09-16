package com.atck.web;

import com.atck.pojo.Book;
import com.atck.pojo.Page;
import com.atck.service.BookService;
import com.atck.service.impl.BookServiceImpl;
import com.atck.utils.JDBCUtils;
import com.atck.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet
{
    private BookService bookService = new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doPost(req,resp);
    }
    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        //1.获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 4);
        //2.调用BookService.page(pageNo,pageSize):page对象
        Page<Book> page = bookService.page(pageNo,pageSize);


        page.setUrl("clientBookServlet?action=getPage");

        //3.保存到Request域中
        req.setAttribute("page",page);
        //4.请求转发到pages/manager/book_manager.jsp页面

        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    /**
     * 处理筛选页面的分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getFilterPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        //1.获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 4);
        int min = WebUtils.parseInt(req.getParameter("min"),0);
        int max = WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);
        //2.调用BookService.page(pageNo,pageSize):page对象
        Page<Book> page = bookService.filterPage(min,max,pageNo,pageSize);


        StringBuilder sb = new StringBuilder("clientBookServlet?action=getFilterPage");
        //如果有最小价格，追加到分页条的地址参数中
        if (req.getParameter("min") != null)
        {
            sb.append("&min=").append(req.getParameter("min"));
        }
        //如果有最大价格，追加到分页条的地址参数中
        if (req.getParameter("max") != null)
        {
            sb.append("&max=").append(req.getParameter("max"));
        }

        page.setUrl("clientBookServlet?action=getFilterPage&min=" + min + "&max=" + max);


        //3.保存到Request域中
        req.setAttribute("page",page);
        //4.请求转发到pages/manager/book_manager.jsp页面

        req.getRequestDispatcher("/pages/client/filterpage.jsp").forward(req,resp);
    }

}
