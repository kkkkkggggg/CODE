package day12_exer_00;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @acthor KKKKK
 * @creay 2021-05-05-{TIME}
 */
interface Factory
{
    void produceProduct();
}

class CarFactory implements Factory
{

    @Override
    public void produceProduct()
    {
        System.out.println("汽车工厂生产汽车");
    }
}

class ProxyFactory
{
    public static Object getNewProxy(Object obj)
    {
        MyInvocationHandler1 handler1 = new MyInvocationHandler1();
        handler1.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler1);
    }
}


class MyInvocationHandler1 implements InvocationHandler
{
    private Object obj;

    public void bind(Object obj)
    {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        Object returnValue = method.invoke(obj,args);

        return returnValue;
    }
}

public class ProxyTest
{
    public static void main(String[] args)
    {
        CarFactory carFactory = new CarFactory();

        Factory newProxy = (Factory) ProxyFactory.getNewProxy(carFactory);

        newProxy.produceProduct();


    }
}
