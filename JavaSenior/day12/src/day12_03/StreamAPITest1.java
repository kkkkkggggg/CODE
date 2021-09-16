package day12_03;

import day12_02.Employee;
import day12_02.EmployeeData;
import org.hamcrest.Condition;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToDoubleBiFunction;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 *
 *
 * @acthor KKKKK
 * @creay 2021-05-07-{TIME}
 */
public class StreamAPITest1
{
    //1.筛选与切片
    @Test
    public void test()
    {
        List<Employee> list = EmployeeData.getEmployees();
        //filter(Predicate p) 接收Lambda，从流中排除某些元素
        Stream<Employee> stream = list.stream();

        //练习，查询员工表中薪资大于7000的员工信息
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        //limit(long maxSize) 截断流，使其元素不超过给定数量
        System.out.println();
        //        stream.limit(3).forEach(System.out::println);执行过终止操作后，流关闭，不可再使用
        list.stream().limit(3).forEach(System.out::println);

        System.out.println();
        //distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        list.stream().distinct().forEach(System.out::println);

        System.out.println();
        //skip(long n)跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        list.stream().distinct().skip(4).forEach(System.out::println);


    }


    //2.映射
    @Test
    public void test1()
    {
        //map(Function f) 接收一个函数作为参数，该函数会被应用到每个元 素上，并将其映射成一个新的元素。
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        Stream<Integer> stream = list.stream();

        stream.map(i -> i * 2).forEach(System.out::println);


        //练习一：获取员工姓名长度大于三的员工姓名
         List<Employee> list1 = EmployeeData.getEmployees();

         Stream<Employee> stream1 = list1.stream();
         stream1.map(Employee::getName).filter(s -> s.length() > 3).forEach(System.out::println);
        //flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另 一个流，然后把所有流连接成一个流
        //练习二
        //方式一：使用map
        ArrayList<String> list2 = new ArrayList();
        list2.add("abc");
        list2.add("def");
        list2.add("ghi");

        Stream<Stream<Character>> streamStream = list2.stream().map(StreamAPITest1::fromStringToStream);

        streamStream.forEach(s -> {s.forEach(System.out::println);});

        //方式二：使用flatMap
        Stream<Character> characterStream = list2.stream().flatMap(StreamAPITest1::fromStringToStream);
        characterStream.forEach(System.out::println);
        //mapToDouble(ToDoubleFunction f) 接收一个函数作为参数，该函数会被应用到每个元 素上，产生一个新的 DoubleStream。


        //mapToInt(ToIntFunction f) 接收一个函数作为参数，该函数会被应用到每个元 素上，产生一个新的 IntStream。


        //mapToLong(ToLongFunction f) 接收一个函数作为参数，该函数会被应用到每个元 素上，产生一个新的 LongStream。






    }

    //将字符串中的多个字符构成的集合构成Stream实例作为返回值返回
    public static Stream<Character> fromStringToStream(String str)
    {
        ArrayList<Character> list = new ArrayList<>();

        for(Character c : str.toCharArray())
        {
            list.add(c);
        }

        return list.stream();
    }

    @Test
    public void test2()
    {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        ArrayList list1 = new ArrayList();
        list.add(4);
        list.add(5);
        list.add(6);

        //list.add(list1);
        list.addAll(list1);
        System.out.println(list);
    }


    //3.排序
    @Test
    public void test3()
    {
        //sorted() -- 自然排序
        List<Integer> list = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
        list.stream().sorted().forEach(System.out::println);


        //抛异常，原因：Employee类没有实现Comparable接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com) -- 定制排序
        List<Employee> employees = EmployeeData.getEmployees();

        employees.stream().sorted((e1,e2) -> Integer.compare(e1.getAge(),e2.getAge())).forEach(System.out::println);

    }




}
