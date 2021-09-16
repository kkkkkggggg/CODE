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
        System.out.println("����������������");
    }
}

class ToyFactory implements Factory
{

    @Override
    public void produceProduct()
    {
        System.out.println("��߹������� ���");
    }
}

class ShoseFactory implements Factory
{

    @Override
    public void produceProduct()
    {
        System.out.println("Ь�ӹ�������Ь��");
    }
}

class HatFactory implements Factory
{

    @Override
    public void produceProduct()
    {
        System.out.println("ñ�ӹ�������ñ��");
    }
}

class FoodFactory implements Factory
{

    @Override
    public void produceProduct()
    {
        System.out.println("ʳƷ��������ʳƷ");
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
        System.out.println(clazz.getName() + "������ǰ��׼��");
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
