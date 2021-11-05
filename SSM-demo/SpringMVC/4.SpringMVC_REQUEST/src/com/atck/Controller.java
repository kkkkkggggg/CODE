package com.atck;

import com.book.Book;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.PrintWriter;

@org.springframework.stereotype.Controller
public class Controller
{
    @RequestMapping("/hello")
    public String hello()
    {

        System.out.println("hello");
        return "success";
    }

    /**
     * SpringMVC如何获取请求带来的各种信息
     *      1.默认方式获取请求参数
     *              直接给方法形参上写一个和参数名相同的变量，这个变量就来接收请求参数的值
     *                  请求有参数：变量有值，请求没有参数：变量为null
     *      2.@RequestParam：获取请求参数的注解,添加在方法的形参上，value表示要获取的参数名称
     *              @RequestParam("username") String username
     *              username = request。getParameter("username");
     *                  value:指定要获取的参数的key
     *                  required：这个参数是否是必须的
     *                  defaultValue：默认值，未指定默认值时，如果要获取的参数不存在，则username=null，指定默认值后则是默认值
     *      @RequestParam("username") /book/{username}?username=tomcat   获取参数中的key为username的值
     *      @PathVariable("username") /book/{username}  获取路径上的username值
     *      3.@RequestHeader:获取请求头中某个key的值
     *              @RequestHeader("User-Agent") String userAgent
     *              userAgent = request.getHeader("User-Agent")
     *         如果请求头中没有这个参数，会报错
     *
     *      4.CookieValue:获取某个cookie的值
     *              以前获取某个cookie的操作
     *                  Cookie[] cookies = request.getCookies();
     *                  for(Cookie c : cookies)
     *                  {
     *                      if(c.getName().equals("JSESSIONID"))
     *                      {
     *                          String cookieValue = c.getValue();
     *                      }
     *                  }
     * @param username
     * @return
     */
    @RequestMapping("/hello01")
    public String hello01(@RequestParam("username") String username, @RequestHeader("User-Agent") String userAgent,@CookieValue("JSESSIONID") String jsessionId)
    {
        System.out.println("request域中参数的值是"+username);
        System.out.println("请求头中浏览器的信息" + userAgent);
        System.out.println("cookie中的JSESSIONID是：" + jsessionId);
        System.out.println("hello01");
        return "success";
    }

    /**
     * 如果我们的请求参数是一个POJO
     * SpringMVC会自动的为这个POJO进行赋值
     * 1）、将POJO中的每一个属性，从request参数中尝试获取出来，并封装即可
     * 2）、还可以级联封装:属性的属性
     * 3）、请求的参数名和对象中的属性名一一对应就行
     *
     * 提交的数据可能有乱码
     * 请求乱码：
     *      GET请求：改server.xml,
     *              <Connector URLEncoding="UTF-8" port="8080" protocol="HTTP/1.1"
     *                connectionTimeout="20000"
     *                redirectPort="8443" />
     *      POST请求：在第一次获取请求参数之前设置
     *              request.setCharacterEncoding("UTF-8");
     *              自己写一个filter：SpringMVC有这个filter：CharacterEncodingFilter
     * 响应乱码：
     *      response.setContextType("text/html;charset=utf-8")
     * @param book
     * @return
     */
    @RequestMapping("/book")
    public String addBook(Book book)
    {
        System.out.println("我要保存的对象" + book);
        return "success";
    }

    /**
     * SpringMVC可以直接在参数上写原生API
     * HttpServletRequest
     * HttpServletResponse
     * HttpSession
     *
     * java.security.Principal
     *
     * Locale:国际化有关的区域信息对象
     *
     * InputStream
     *      ServletInputStream inputStream = request.getInputStream();
     * OutputStream
     *      ServletOutputStream outputStream = response.getOutputStream();
     *
     * Reader
     *     BufferedReader reader = request.getReader();
     * Writer
     *     PrintWriter writer = response.getWriter();
     *
     */
    @RequestMapping("/hello02")
    public String hello02(HttpSession session, HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("reqParam","我是请求域中的");
        session.setAttribute("sessionParam","我是session域中的");
        return "success";
    }
}
