package day12_01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Java���õ�4����ĺ���ʽ�ӿ�
 *
 * �����ͽӿ� Consumer<T>  void accept(T t)
 * �����ͽӿ� Supplier<T>  T  get()
 * �����ͽӿ� Function<T,R>  R apply(T t)
 * �϶��ͽӿ� Predicate<T>  boolean test(T t)
 *
 * @acthor KKKKK
 * @creay 2021-05-06-{TIME}
 */
public class LambdaTest2
{
    @Test
    public void test()
    {
        happyTime(500, new Consumer<Double>()
        {
            @Override
            public void accept(Double aDouble)
            {
                System.out.println("ѧϰ̫���ˣ�ȥ����԰���棬����" + aDouble);
            }
        });

        System.out.println("*************************");

        happyTime(400,money -> System.out.println("ѧϰ̫���ˣ�ȥ����԰���棬����" + money));
    }

    public void happyTime(double money, Consumer<Double> con)
    {
        con.accept(money);
    }

    @Test
    public void test1()
    {
        List<String> list = Arrays.asList("����","�Ͼ�","���","����","����","�վ�");
        List<String> filterList = filterString(list, new Predicate<String>()
        {
            @Override
            public boolean test(String s)
            {
                return s.contains("��");
            }
        });

        System.out.println(filterList);

        System.out.println("**********************************************");

        List<String> list1 = Arrays.asList("����","�Ͼ�","���","����","����","�վ�");

        List<String> fliterList1 = filterString(list1, (s) -> s.contains("��"));

        System.out.println(fliterList1);

    }

    public List<String> filterString(List<String> list, Predicate<String> pre)
    {
        ArrayList<String> filterList = new ArrayList<>();

        for(String s : list)
        {
            if(pre.test(s))
            {
                filterList.add(s);
            }
        }

        return filterList;
    }
}
