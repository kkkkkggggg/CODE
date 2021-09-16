package day12_01;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda���ʽ��ʹ��
 *
 * 1.������(o1,o2)  ->  Integer.compare(o1,o2);
 *
 * 2.��ʽ��
 *      -> ��Lambda������  �� ��ͷ������
 *      ->��� �� Lambda�β��б���ʵ���ǽӿ��г��󷽷����β��б�
 *      ->�ұ� : Lambda�� ����ʵ������д�ĳ��󷽷��ķ����壩
 *
 * 3.Lambda���ʽ��ʹ�ã���������������ܣ�
 *
 *
 * 4.Lambda���ʽ�ı��ʣ���Ϊ�ӿڵ�ʵ��
 *
 *          �ܽ᣺
 *              -> ��ߣ���ָ���˽ӿڵķ��ͣ�����ʡ�Ե��β��б��е���������������ֻд�β�
 *              �������ֻ��һ���βΣ�����ʡ��С���ţ�����βλ�û���ββ���ʡ��
 *              -> �ұ�:��ֻ��һ�������䣬����ʡ�Դ����ţ�������������һ��������䣬Ҳ
 *              ���Խ�return�ؼ���ʡ�ԣ�������䲻��ʡ�Դ�����
 * 5.���һ���ӿ���ֻ������һ�����󷽷�����˽ӿڳ�Ϊ����ʽ�ӿڡ����ǿ����ڽӿ���ʹ��@FunctionalInterfaceע�⣬�������Լ�����Ƿ���һ������ʽ�ӿ�
 *
 * 6.��ǰ������ʵ�����ʾ�����ڶ�������Lambda���ʽ��д
 *
 * @acthor KKKKK
 * @creay 2021-05-05-{TIME}
 */
public class LambdaTest1
{
    //�﷨��ʽһ���޲Σ��޷���ֵ
    @Test
    public void test()
    {
        Runnable r1 = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("�Ұ������찲��");
            }
        };

        r1.run();

        System.out.println("**********************************");

        Runnable r2 = () -> System.out.println("�Ұ������ʹ�");


        r2.run();
    }

    //�﷨��ʽ����Lambda ��Ҫһ������������û�з���ֵ
    @Test
    public void test1()
    {
        Consumer<String> con = new Consumer<String>()
        {
            @Override
            public void accept(String s)
            {
                System.out.println(s);
            }
        };

        con.accept("ABCDEFGHIJKLMN");

        System.out.println("*****************************************");

        Consumer<String> con1 = (String s) -> System.out.println(s);

        con1.accept("OPQRSTUVWXYZ");
    }

    //�﷨��ʽ�����������Ϳ���ʡ�ԣ���Ϊ���ɱ������ƶϵó�����Ϊ�����ƶ�
    @Test
    public void test2()
    {
        Consumer<String> con = new Consumer<String>()
        {
            @Override
            public void accept(String s)
            {
                System.out.println(s);
            }
        };

        con.accept("ABCDEFGHIJKLMN");

        System.out.println("*****************************************");


        //ʡ������������ String
        Consumer<String> con1 = (s) -> System.out.println(s);

        con1.accept("OPQRSTUVWXYZ");
    }

    //�﷨��ʽ�ģ�Lambda��ֻ��Ҫһ������ʱ��������С���ſ���ʡ��
    @Test
    public void test3()
    {
        Consumer<String> con = new Consumer<String>()
        {
            @Override
            public void accept(String s)
            {
                System.out.println(s);
            }
        };

        con.accept("ABCDEFGHIJKLMN");

        System.out.println("*****************************************");


        //ʡ������������ String �� �β��б����һ�����ţ�()
        Consumer<String> con1 = s -> System.out.println(s);

        con1.accept("OPQRSTUVWXYZ");
    }

    //�﷨��ʽ�壺Lambda ��Ҫ�������ϵĲ���������ִ����䣬���ҿ����з���ֵ
    @Test
    public void test4()
    {
        Comparator<String> com = new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };

        int i = com.compare("A", "D");

        System.out.println(i);

        System.out.println("*************************************");

        Comparator<String> com1 = (o1, o2) ->
        {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        int i1 = com1.compare("A", "D");
        System.out.println(i1);
    }

    //������ʽ������Lambda��ֻ��һ��ִ�����ʱ��return �� ���������У�������ʡ��

    @Test
    public void test5()
    {
        Comparator<String> com1 = (o1, o2) -> o1.compareTo(o2);
        int i1 = com1.compare("A", "D");
        System.out.println(i1);
    }
}
