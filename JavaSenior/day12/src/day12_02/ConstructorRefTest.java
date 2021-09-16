package day12_02;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *       和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致
 *       抽象方法的返回值类型与构造器所在的类一致
 * 二、数组引用
 *       大家可以将数组看成一个特殊的类
 *
 * Created by shkstart
 */
public class ConstructorRefTest {
	//构造器引用
    //Supplier中的T get()
    @Test
    public void test1(){
        Supplier<Employee> sup = () -> new Employee();
        System.out.println(sup.get());

        System.out.println("*******************************");

        Supplier<Employee> sup1 = Employee :: new;
        System.out.println(sup.get());

    }

	//Function中的R apply(T t)
    @Test
    public void test2(){
        Function<Integer,Employee> fun = id -> new Employee(id);
        Employee employee = fun.apply(1001);

        System.out.println(employee);

        System.out.println("*************************************");

        Function<Integer,Employee> fun1 = Employee::new;
        Employee employee1 = fun1.apply(1001);

        System.out.println(employee1);
	}

	//BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        BiFunction<Integer,String,Employee> bi = (id,name) -> new Employee(id,name);
        System.out.println(bi.apply(1001,"tom"));

        System.out.println("***************************************");

        BiFunction<Integer,String,Employee> bi1 = Employee::new;
        System.out.println(bi1.apply(1001,"tom"));
	}

	//数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        Function<Integer,String[]> func = length -> new String[length];



        System.out.println(Arrays.toString(func.apply(5)));

        System.out.println("****************************************");

        Function<Integer,String[]> func1 = String[] :: new;



    }
}
