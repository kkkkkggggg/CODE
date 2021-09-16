package com.atck.web;

import com.atck.pojo.Cart;
import com.atck.pojo.Order;
import com.atck.pojo.OrderItem;
import com.atck.pojo.User;
import com.atck.service.OrderService;
import com.atck.service.impl.OrderServiceImpl;
import com.atck.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet
{
    private OrderService orderService = new OrderServiceImpl();
    /**
     * 生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //先获取cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //获取userId
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null)
        {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

        // System.out.println("OrderServlet程序在["+ Thread.currentThread().getName() +"]线程中");

        Integer userId = loginUser.getId();
        //调用orderService.createOrder生成订单
        String orderId = orderService.createOrder(cart, userId);



        // req.setAttribute("orderId",orderId);
        // //请求转发到http://localhost:8080/book/pages/cart/checkout.jsp
        // req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }

    /**
     * 查看所有订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<Order> orders = null;

        orders = orderService.showAllOrders();

        req.getSession().setAttribute("allOrders",orders);
        resp.sendRedirect(req.getContextPath() + "/pages/manager/order_manager.jsp");
    }

    /**
     * 发货
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        String orderId = req.getParameter("orderId");

        orderService.sendOrder(orderId);

        resp.sendRedirect(req.getContextPath() + "/orderServlet?action=showAllOrders");

    }

    /**
     * 查看订单详情
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // System.out.println("showOrderDetail");
        String orderId = req.getParameter("orderId");
        List<OrderItem> orderItems = null;

        orderItems = orderService.showOrderDetail(orderId);

        req.getSession().setAttribute("orderItems",orderItems);

        resp.sendRedirect(req.getContextPath() + "/pages/order/order_detail.jsp");
    }

    /**
     * 查看我的订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showMyOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // System.out.println("showMyOrders");
        //获取用户id，根据用户id查询订单
        User user = (User) req.getSession().getAttribute("user");
        List<Order> orders = null;

        orders = orderService.showMyOrders(user.getId());


        //将查询到的订单信息保存到session域中
        req.getSession().setAttribute("orders",orders);

        //重定向到订单显示页面
        resp.sendRedirect(req.getContextPath() + "/pages/order/order.jsp");
    }

    /**
     * 签收订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void receiveOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String orderId = req.getParameter("orderId");

        orderService.receiveOrder(orderId);



        resp.sendRedirect(req.getContextPath() + "/orderServlet?action=showMyOrders");
    }
}
