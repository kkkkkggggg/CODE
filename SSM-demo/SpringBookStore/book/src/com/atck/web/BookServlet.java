package com.atck.web;

import com.atck.pojo.Book;
import com.atck.pojo.Page;
import com.atck.service.BookService;
import com.atck.service.impl.BookServiceImpl;
import com.atck.utils.JDBCUtils;
import com.atck.utils.WebUtils;
import com.atck.web.BaseServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class BookServlet extends BaseServlet
{

    private BookService bookService = WebUtils.getBean(BookService.class);

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
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2.调用BookService.page(pageNo,pageSize):page对象
        Page<Book> page = bookService.page(pageNo,pageSize);


        page.setUrl("manager/bookServlet?action=getPage");

        //3.保存到Request域中
        req.setAttribute("page",page);
        //4.请求转发到pages/manager/book_manager.jsp页面

        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {


        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());


        bookService.addBook(book);


        // req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);



        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=getPage&pageNo=" + req.getParameter("pageNo"));
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int id = WebUtils.parseInt(req.getParameter("id"),0);


        bookService.deleteBookById(id);



        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=getPage&pageNo=" + req.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        // System.out.println(book);

        bookService.updateBook(book);

        String pageNo = req.getParameter("pageNo");

        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=getPage&pageNo=" + pageNo);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //1.通过bookServlet查询全部图书
        List<Book> books = null;

        books = bookService.queryBooks();

        //2.把全部图书保存到request域中
        req.setAttribute("books",books);
        //3.请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = null;

        book = bookService.queryBookById(id);

        req.setAttribute("book",book);
        String pageNo = req.getParameter("pageNo");
        req.setAttribute("pageNo",pageNo);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }




}
