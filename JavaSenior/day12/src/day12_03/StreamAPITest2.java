package day12_03;

import day12_02.Employee;
import day12_02.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream的终止操作
 *
 *
 * @acthor KKKKK
 * @creay 2021-05-08-{TIME}
 */
public class StreamAPITest2
{
    //1-匹配与查找
    @Test
    public void test()
    {
        //allMatch(Predicate p) 检查是否匹配所有元素。练习：是否所有员工的年龄都大于18
        List<Employee> employees = EmployeeData.getEmployees();
        boolean b = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);

        //anyMatch(Predicate p) 检查是否至少匹配一个元素。练习：是否存在员工的工资大于10000
        boolean b1 = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(b1);

        //noneMatch(Predicate p) 检查是否没有匹配所有元素。练习：是否存在员工姓雷
//        boolean b2 = employees.stream().noneMatch(e -> e.getName().charAt(0) == '雷');
        boolean b2 = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));

        System.out.println(b2);
        //findFirst() 返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        //findAny() 返回当前流中的任意元素
//        Optional<Employee> any = employees.stream().findAny();
        Optional<Employee> any = employees.parallelStream().findAny();

        System.out.println(any);

        //count() 返回流中元素总数
        long count = employees.stream().count();
        System.out.println(count);

        //max(Comparator c) 返回流中最大值
        Optional<Employee> max = employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max.get().getSalary());

        //min(Comparator c) 返回流中最小值
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min.get().getName());


        //forEach(Consumer c)内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反，Stream API 使用内部迭代——它帮你把迭代做了)
    }

    //2-归约
    @Test
    public void test1()
    {
        //reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 T,练习一：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
        //reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>,练习二：计算公司所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> reduce1 = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce1);

    }

    //3-收集
    @Test
    public void test2()
    {
        //collect(Collector c)将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
        //练习一：查找工资大于6000的员工，结果返回一个List或set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());

//        Iterator<Employee> iterator = collect.iterator();
//
//        while(iterator.hasNext())
//        {
//            System.out.println(iterator.next());
//        }
        collect.forEach(System.out::println);

    }
}
