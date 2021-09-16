package day112_00;

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

class ToyFactory implements Factory
{

    @Override
    public void produceProduct()
    {
        System.out.println("玩具工厂生产 玩具");
    }
}

class ShoseFactory implements Factory
{

    @Override
    public void produceProduct()
    {
        System.out.println("鞋子工厂生产鞋子");
    }
}

class HatFactory implements Factory
{

    @Override
    public void produceProduct()
    {
        System.out.println("帽子工厂生产帽子");
    }
}

class FoodFactory implements Factory
{

    @Override
    public void produceProduct()
    {
        System.out.println("食品工厂生产食品");
    }
}


class ProxyFactory implements Factory
{
    private Class<Factory> clazz;

    public ProxyFactory(Factory factory)
    {
        this.clazz = (Class<Factory>) factory.getClass();
    }

    private void prepare()
    {
        System.out.println(clazz.getName() + "做生产前的准备");
    }

    @Override
    public void produceProduct()
    {
        prepare();
        try
        {
            clazz.newInstance().produceProduct();
        }catch(InstantiationException e)
        {
            e.printStackTrace();
        }catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
}

public class ProxyTest
{
    public static void main(String[] args)
    {
        int num = (int) (Math.random() * 4);
        Factory factory;
        switch(num)
        {
            case 0:
                factory = new CarFactory();
                break;
            case 1:
                factory = new ToyFactory();
                break;
            case 2:
                factory = new ShoseFactory();
                break;
            case 3:
                factory = new HatFactory();
                break;
            default:
                factory = new FoodFactory();
        }

        ProxyFactory proxyFactory = new ProxyFactory(factory);

        proxyFactory.produceProduct();
    }
}
