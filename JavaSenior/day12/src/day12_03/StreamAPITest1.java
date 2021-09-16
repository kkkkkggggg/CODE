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
 * ����Stream���м����
 *
 *
 * @acthor KKKKK
 * @creay 2021-05-07-{TIME}
 */
public class StreamAPITest1
{
    //1.ɸѡ����Ƭ
    @Test
    public void test()
    {
        List<Employee> list = EmployeeData.getEmployees();
        //filter(Predicate p) ����Lambda���������ų�ĳЩԪ��
        Stream<Employee> stream = list.stream();

        //��ϰ����ѯԱ������н�ʴ���7000��Ա����Ϣ
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        //limit(long maxSize) �ض�����ʹ��Ԫ�ز�������������
        System.out.println();
        //        stream.limit(3).forEach(System.out::println);ִ�й���ֹ���������رգ�������ʹ��
        list.stream().limit(3).forEach(System.out::println);

        System.out.println();
        //distinct() ɸѡ��ͨ����������Ԫ�ص� hashCode() �� equals() ȥ���ظ�Ԫ��
        list.stream().distinct().forEach(System.out::println);

        System.out.println();
        //skip(long n)����Ԫ�أ�����һ���ӵ���ǰ n ��Ԫ�ص�����������Ԫ�ز��� n �����򷵻�һ���������� limit(n) ����
        list.stream().distinct().skip(4).forEach(System.out::println);


    }


    //2.ӳ��
    @Test
    public void test1()
    {
        //map(Function f) ����һ��������Ϊ�������ú����ᱻӦ�õ�ÿ��Ԫ ���ϣ�������ӳ���һ���µ�Ԫ�ء�
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


        //��ϰһ����ȡԱ���������ȴ�������Ա������
         List<Employee> list1 = EmployeeData.getEmployees();

         Stream<Employee> stream1 = list1.stream();
         stream1.map(Employee::getName).filter(s -> s.length() > 3).forEach(System.out::println);
        //flatMap(Function f) ����һ��������Ϊ�����������е�ÿ��ֵ�������� һ������Ȼ������������ӳ�һ����
        //��ϰ��
        //��ʽһ��ʹ��map
        ArrayList<String> list2 = new ArrayList();
        list2.add("abc");
        list2.add("def");
        list2.add("ghi");

        Stream<Stream<Character>> streamStream = list2.stream().map(StreamAPITest1::fromStringToStream);

        streamStream.forEach(s -> {s.forEach(System.out::println);});

        //��ʽ����ʹ��flatMap
        Stream<Character> characterStream = list2.stream().flatMap(StreamAPITest1::fromStringToStream);
        characterStream.forEach(System.out::println);
        //mapToDouble(ToDoubleFunction f) ����һ��������Ϊ�������ú����ᱻӦ�õ�ÿ��Ԫ ���ϣ�����һ���µ� DoubleStream��


        //mapToInt(ToIntFunction f) ����һ��������Ϊ�������ú����ᱻӦ�õ�ÿ��Ԫ ���ϣ�����һ���µ� IntStream��


        //mapToLong(ToLongFunction f) ����һ��������Ϊ�������ú����ᱻӦ�õ�ÿ��Ԫ ���ϣ�����һ���µ� LongStream��






    }

    //���ַ����еĶ���ַ����ɵļ��Ϲ���Streamʵ����Ϊ����ֵ����
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


    //3.����
    @Test
    public void test3()
    {
        //sorted() -- ��Ȼ����
        List<Integer> list = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
        list.stream().sorted().forEach(System.out::println);


        //���쳣��ԭ��Employee��û��ʵ��Comparable�ӿ�
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com) -- ��������
        List<Employee> employees = EmployeeData.getEmployees();

        employees.stream().sorted((e1,e2) -> Integer.compare(e1.getAge(),e2.getAge())).forEach(System.out::println);

    }




}
