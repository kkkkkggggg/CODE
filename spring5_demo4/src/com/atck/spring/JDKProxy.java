package com.atck.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy
{
    public static void main(String[] args)
    {
        //创建接口实现类的代理对象
        Class[] interfaces = {UserDAO.class};
        UserDAOImpl userDAO = new UserDAOImpl();
        UserDAO dao = (UserDAO) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDAOProxy(userDAO));
        int add = dao.add(1, 2);
        System.out.println(dao.update("asdb"));
        System.out.println(add);
    }
}


//创建代理对象代码
class UserDAOProxy implements InvocationHandler
{
    private Object obj;
    //创建的是谁的代理类对象
    public UserDAOProxy(Object obj)
    {
        this.obj = obj;
    }

    //增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        //方法之前
        System.out.println("方法执行之前。。。。。。" + method.getName() + ":传递的参数。。。" + Arrays.toString(args));

        //被增强的方法执行
        Object res = method.invoke(obj, args);

        //方法之后
        System.out.println("方法执行之后。。。。" + obj);

        return res;
    }
}