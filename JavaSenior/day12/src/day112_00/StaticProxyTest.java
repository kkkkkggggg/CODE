package day112_00;

/**
 * 静态代理类举例
 *
 * @acthor KKKKK
 * @creay 2021-05-05-{TIME}
 */
interface ClothFactory
{
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory
{
    private ClothFactory factory;//用被代理类的对象进行实例化

    public ProxyClothFactory(ClothFactory factory)
    {
        this.factory = factory;
    }

    @Override
    public void produceCloth()
    {
        System.out.println("代理工厂做一些准备工作");

        factory.produceCloth();

        System.out.println("代理工厂做一些后续的收尾工作");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory
{

    @Override
    public void produceCloth()
    {
        System.out.println("Nike工厂生产一批运动服");
    }
}

public class StaticProxyTest
{
    public static void main(String[] args)
    {
        //创建被代理类的对象
        NikeClothFactory factory = new NikeClothFactory();

        //创建代理类的对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(factory);

        proxyClothFactory.produceCloth();
    }
}


