package day112_00;

/**
 * ��̬���������
 *
 * @acthor KKKKK
 * @creay 2021-05-05-{TIME}
 */
interface ClothFactory
{
    void produceCloth();
}

//������
class ProxyClothFactory implements ClothFactory
{
    private ClothFactory factory;//�ñ�������Ķ������ʵ����

    public ProxyClothFactory(ClothFactory factory)
    {
        this.factory = factory;
    }

    @Override
    public void produceCloth()
    {
        System.out.println("��������һЩ׼������");

        factory.produceCloth();

        System.out.println("��������һЩ��������β����");
    }
}

//��������
class NikeClothFactory implements ClothFactory
{

    @Override
    public void produceCloth()
    {
        System.out.println("Nike��������һ���˶���");
    }
}

public class StaticProxyTest
{
    public static void main(String[] args)
    {
        //������������Ķ���
        NikeClothFactory factory = new NikeClothFactory();

        //����������Ķ���
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(factory);

        proxyClothFactory.produceCloth();
    }
}


