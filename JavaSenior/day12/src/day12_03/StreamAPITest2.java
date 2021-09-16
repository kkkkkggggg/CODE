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
 * ����Stream����ֹ����
 *
 *
 * @acthor KKKKK
 * @creay 2021-05-08-{TIME}
 */
public class StreamAPITest2
{
    //1-ƥ�������
    @Test
    public void test()
    {
        //allMatch(Predicate p) ����Ƿ�ƥ������Ԫ�ء���ϰ���Ƿ�����Ա�������䶼����18
        List<Employee> employees = EmployeeData.getEmployees();
        boolean b = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);

        //anyMatch(Predicate p) ����Ƿ�����ƥ��һ��Ԫ�ء���ϰ���Ƿ����Ա���Ĺ��ʴ���10000
        boolean b1 = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(b1);

        //noneMatch(Predicate p) ����Ƿ�û��ƥ������Ԫ�ء���ϰ���Ƿ����Ա������
//        boolean b2 = employees.stream().noneMatch(e -> e.getName().charAt(0) == '��');
        boolean b2 = employees.stream().noneMatch(e -> e.getName().startsWith("��"));

        System.out.println(b2);
        //findFirst() ���ص�һ��Ԫ��
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        //findAny() ���ص�ǰ���е�����Ԫ��
//        Optional<Employee> any = employees.stream().findAny();
        Optional<Employee> any = employees.parallelStream().findAny();

        System.out.println(any);

        //count() ��������Ԫ������
        long count = employees.stream().count();
        System.out.println(count);

        //max(Comparator c) �����������ֵ
        Optional<Employee> max = employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max.get().getSalary());

        //min(Comparator c) ����������Сֵ
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min.get().getName());


        //forEach(Consumer c)�ڲ�����(ʹ�� Collection �ӿ���Ҫ�û�ȥ����������Ϊ�ⲿ�������෴��Stream API ʹ���ڲ���������������ѵ�������)
    }

    //2-��Լ
    @Test
    public void test1()
    {
        //reduce(T iden, BinaryOperator b) ���Խ�����Ԫ�ط�������������õ�һ��ֵ������ T,��ϰһ������1-10����Ȼ���ĺ�
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
        //reduce(BinaryOperator b) ���Խ�����Ԫ�ط�������������õ�һ��ֵ������ Optional<T>,��ϰ�������㹫˾����Ա�����ʵ��ܺ�
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> reduce1 = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce1);

    }

    //3-�ռ�
    @Test
    public void test2()
    {
        //collect(Collector c)����ת��Ϊ������ʽ������һ�� Collector�ӿڵ�ʵ�֣����ڸ�Stream��Ԫ�������ܵķ���
        //��ϰһ�����ҹ��ʴ���6000��Ա�����������һ��List��set
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
