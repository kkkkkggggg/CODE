package day12_01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Java内置的4大核心函数式接口
 *
 * 消费型接口 Consumer<T>  void accept(T t)
 * 供给型接口 Supplier<T>  T  get()
 * 函数型接口 Function<T,R>  R apply(T t)
 * 断定型接口 Predicate<T>  boolean test(T t)
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
                System.out.println("学习太累了，去游乐园玩玩，花了" + aDouble);
            }
        });

        System.out.println("*************************");

        happyTime(400,money -> System.out.println("学习太累了，去游乐园玩玩，花了" + money));
    }

    public void happyTime(double money, Consumer<Double> con)
    {
        con.accept(money);
    }

    @Test
    public void test1()
    {
        List<String> list = Arrays.asList("北京","南京","天津","东京","西京","普京");
        List<String> filterList = filterString(list, new Predicate<String>()
        {
            @Override
            public boolean test(String s)
            {
                return s.contains("京");
            }
        });

        System.out.println(filterList);

        System.out.println("**********************************************");

        List<String> list1 = Arrays.asList("北京","南京","天津","东京","西京","普京");

        List<String> fliterList1 = filterString(list1, (s) -> s.contains("京"));

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
