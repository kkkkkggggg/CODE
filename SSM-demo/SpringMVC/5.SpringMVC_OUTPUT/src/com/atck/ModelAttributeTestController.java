package com.atck;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 测试ModelAttribute注解
 * 使用场景;书城的图书修改为例
 * 1）、页面端
 *          显示要修改的图书的信息，图书的所有字段都在
 * 2）、servlet收到请求，调用dao查询要修改的图书的信息，发送到修改页面，进行显示，用户在页面的表单中修改了图书信息后，点击修改按钮，servlet收到
 * 请求，将修改后的图书信息进行封装，再调用dao中的updateBook方法修改图书信息
 *
 * 3）、实际场景，并不是全字段修改，只会修改部分字段，以修改用户信息为例，用户的id是不可修改的，用户名和密码等是可以修改的
 *          1)、不修改的字段，不要在页面进行展示但不提供修改途径
 *          2）、为了简单，Controller直接在参数位置来写Book对象，SpringMVC为自动对POJO进行封装，没有值的属性，自动赋值为null
 *          3）、如果接下来调用一个全字段更新的dao操作，会将其他的字段可能变为null
 * 4）、如何保证全字段更新的情况下，只修改页面携带的数据
 *          1）、修改DAO，代价太大
 *          2）、Book对象是如何封装的
 *              1）、SpringMVC创建一个Book对象
 *                      1）、让SpringMVC别创建对象，直接从数据库中取出一个id=100的Book对象
 *                      2）、Book{id=100, name='null', author='设计的哈克', price=465.0, stock=79, sales=1213}
 *              2）、将请求中的所有与book对应的属性一一设置过来
 *                      3）、使用刚才从数据库中取出的Book对象，给它里面设置值（强求参数带了哪些值就覆盖之前的值）
 *                      4）、带了的字段就改为携带的值，没带的字段就保持之前的值
 *              3）、调用全字段更新就有问题
 *                      5）、将之前从数据库中查到的对象，在封装了页面携带的要修改的字段之后，进行保存
 *
 */
@Controller
public class ModelAttributeTestController
{

    private Object o1;
    private Object o2;
    private Object b1;
    private Object b2;
    @RequestMapping("/updateBook")
    public String updateBook(@ModelAttribute("book") Book book, Map<String,Object> map,@RequestParam("author") String author,HttpServletRequest request)
    {
        o2 = map;
        b2 = book;
        Object book1 = map.get("book");
        System.out.println("--------------------Controller-----------------------");
        System.out.println("book == book1?" + (b1 == b2) + "-->" + (b2 == book1));
        // System.out.println("传入的model：" + model.getClass());
        System.out.println("页面要提交过来的图书信息：" + book);
        System.out.println("o1 == o2?" + (o1 == o2));
        return "success";
    }

    /**
     *
     * 可以告诉SpringMVC不要new这个Book了，我刚才从数据库中查询到了book，并将它保存了起来
     *
     * 1)、SpringMVC要封装请求参数的Book对象不应该是自己new出来的
     *          而应该是【从数据库中】拿到的准备好的对象
     * 2）、再来使用这个对象封装请求参数
     *
     * ModelAttribute：使用在参数或者方法上
     *          方法位置：这个方法就会提前于目标方法先运行
     *                  1)、我们可以在这里提前查出数据库中图书的信息
     *                  2）、将这个图书信息保存起来（方便下一个方法还能使用）
     * 参数的map：BindingAwareModelMap
     */
    @ModelAttribute
    public void hahaMyModelAttribute(Map<String,Object> map)
    {

        Book book = new Book(100,"西游记","吴承恩",98.8,464,210);
        System.out.println("-------------------ModelAttribute--------------------");
        System.out.println("数据库中查到的图书信息是" + book);
        map.put("book",book);
        b1 = book;
        o1 = map;
        System.out.println("modelAttribute方法.......查询了图书信息并帮你保存了起来...他用的map类型：" + map.getClass());
    }
}
