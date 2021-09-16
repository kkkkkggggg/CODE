package com.atck.web;

import com.atck.pojo.Book;
import com.atck.pojo.Cart;
import com.atck.pojo.CartItem;
import com.atck.service.BookService;
import com.atck.service.impl.BookServiceImpl;
import com.atck.utils.JDBCUtils;
import com.atck.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet
{
    private BookService bookService = new BookServiceImpl();

    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // System.out.println("cartServlet");
        // System.out.println("商品编号=" + req.getParameter("id"));
        resp.setContentType("text/html;charset=UTF-8");
        //获取请求的参数，商品编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //调用bookService。queryBookById(id) : Book得到图书的信息
        Book book = bookService.queryBookById(id);


        // //更新库存信息
        // book.setStock(book.getStock() - 1);
        // book.setSales(book.getSales() + 1);
        // bookService.updateBook(book);

        //把图书信息转换为CartItem商品项
        CartItem item = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //调用Cart.addItem(CartItem)添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null)
        {
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(item);

        //最后一个添加的商品名称
        req.getSession().setAttribute("lastName",book.getName());

        Map<String,Object> map = new HashMap<>();
        map.put("bookName",book.getName());
        map.put("bookCount",cart.getTotalCount());

        Gson gson = new Gson();


        resp.getWriter().write(gson.toJson(map));

        // req.getSession().setAttribute("bookName",book.getName());


        //重定向回商品列表页面

        // resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 删除商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null)
        {
            // CartItem cartItem = cart.getItems().get(id);
            //
            // //更新库存信息
            // updateStockAndSalesById(id,cartItem);

            cart.deleteItem(id);

        }
        resp.sendRedirect(req.getHeader("Referer"));

    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null)
        {
            // //更新库存信息
            // for (Map.Entry<Integer,CartItem> entry : cart.getItems().entrySet())
            // {
            //     CartItem cartItem = entry.getValue();
            //
            //     //更新库存信息
            //     updateStockAndSalesById(cartItem.getId(),cartItem);
            // }

            cart.clear();
        }
        resp.sendRedirect(req.getHeader("Referer"));

    }

    /**
     * 更新商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int count = WebUtils.parseInt(req.getParameter("count"), 0);
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null)
        {
            // //更新库存信息
            // CartItem cartItem = cart.getItems().get(id);
            // Book book = bookService.queryBookById(id);
            // if (count > cartItem.getCount())
            // {
            //     book.setStock(book.getStock() - (count - cartItem.getCount()));
            //     book.setSales(book.getSales() + (count - cartItem.getCount()));
            //     bookService.updateBook(book);
            // }else if(count < cartItem.getCount())
            // {
            //     book.setStock(book.getStock() + (cartItem.getCount() - count));
            //     book.setSales(book.getSales() - (cartItem.getCount() - count));
            //     bookService.updateBook(book);
            // }


            cart.updateCount(id,count);
        }

        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void showCartItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

    }

}
