package day12_01;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 *
 * 1.举例：(o1,o2)  ->  Integer.compare(o1,o2);
 *
 * 2.格式：
 *      -> ：Lambda操作符  或 箭头操作符
 *      ->左边 ； Lambda形参列表（其实就是接口中抽象方法的形参列表）
 *      ->右边 : Lambda体 （其实就是重写的抽象方法的方法体）
 *
 * 3.Lambda表达式的使用：（分六种情况介绍）
 *
 *
 * 4.Lambda表达式的本质：作为接口的实例
 *
 *          总结：
 *              -> 左边：若指明了接口的泛型，可以省略掉形参列表中的数据类型声明，只写形参
 *              名，如果只有一个形参，可以省略小括号，多个形参或没有形参不能省略
 *              -> 右边:若只有一条输出语句，可以省略大括号，如果这条语句是一个返回语句，也
 *              可以将return关键字省略，多行语句不能省略大括号
 * 5.如果一个接口中只声明了一个抽象方法，则此接口称为函数式接口。我们可以在接口上使用@FunctionalInterface注解，这样可以检查它是否是一个函数式接口
 *
 * 6.以前用匿名实现类表示的现在都可以用Lambda表达式来写
 *
 * @acthor KKKKK
 * @creay 2021-05-05-{TIME}
 */
public class LambdaTest1
{
    //语法格式一：无参，无返回值
    @Test
    public void test()
    {
        Runnable r1 = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("我爱北京天安门");
            }
        };

        r1.run();

        System.out.println("**********************************");

        Runnable r2 = () -> System.out.println("我爱北京故宫");


        r2.run();
    }

    //语法格式二：Lambda 需要一个参数，但是没有返回值
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

    //语法格式三：数据类型可以省略，因为可由编译器推断得出，称为类型推断
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


        //省略了数据类型 String
        Consumer<String> con1 = (s) -> System.out.println(s);

        con1.accept("OPQRSTUVWXYZ");
    }

    //语法格式四：Lambda若只需要一个参数时，参数的小括号可以省略
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


        //省略了数据类型 String 和 形参列表外的一对括号：()
        Consumer<String> con1 = s -> System.out.println(s);

        con1.accept("OPQRSTUVWXYZ");
    }

    //语法格式五：Lambda 需要两个以上的参数，多条执行语句，并且可以有返回值
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

    //方法格式六：当Lambda体只有一条执行语句时，return 与 大括号若有，都可以省略

    @Test
    public void test5()
    {
        Comparator<String> com1 = (o1, o2) -> o1.compareTo(o2);
        int i1 = com1.compare("A", "D");
        System.out.println(i1);
    }
}
