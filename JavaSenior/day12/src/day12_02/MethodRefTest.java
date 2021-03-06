package day12_02;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 * 1.使用情境一：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用
 *
 * 2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例，所以，方法引用也是函数式接口的实例
 *
 * 3.使用格式 ：类(或对象) :: 方法名
 *
 * 4.具体分为如下三种情况：
 * 		情况一：对象 :: 非静态方法
 * 		情况二：类  ::  静态方法
 *
 * 		情况三：类  ::  非静态方法
 *
 * 5.方法引用使用的要求：要求接口中的抽象方法的形参列表、返回值类型和我们引用的方法的参数列表、返回值类型是一样的(针对于情况一和情况二)
 * Created by shkstart.
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {
		Consumer<String> con = str -> System.out.println(str);

		con.accept("beijing");

		System.out.println("****************************************");

		PrintStream ps = System.out;

		Consumer<String> con1 = ps :: println;

		con1.accept("beijing");
		
	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {
		Employee employee = new Employee(1001,"tom",23,5600);
		Supplier<String> sup = () -> employee.getName();

		System.out.println(sup.get());

		System.out.println("*******************************************");

		Supplier<String> sup1 = employee :: getName;

		System.out.println(sup1.get());
	}

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {
		Comparator<Integer> com = Integer :: compare;

		int compare = com.compare(5, 6);

		System.out.println(compare);


	}
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	@Test
	public void test4() {
		Function<Double,Long> fun = d -> Math.round(d);
		System.out.println(fun.apply(12.3));
		System.out.println("***************************************");

		Function<Double,Long> fun1 = Math :: round;
		System.out.println(fun1.apply(12.6));
	}

	// 情况三：类 :: 实例方法 
	// Comparator中的int comapre(T t1,T t2)
	// String中的int t1.compareTo(t2)
	@Test
	public void test5() {
		Comparator<String> com = (s1,s2) -> s1.compareTo(s2);

		System.out.println(com.compare("ABC","ABD"));

		System.out.println("*******************************");

		Comparator<String> com1 = String :: compareTo;

		System.out.println(com1.compare("ABC", "ABM"));
	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {
		BiPredicate<String,String> pre = (s1,s2) -> s1.equals(s2);

		System.out.println(pre.test("abc", "abc"));

		System.out.println("*****************************************");

		BiPredicate<String,String> pre1 = String :: equals;

		System.out.println(pre1.test("abc", "abc"));
	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {

		Employee employee = new Employee(1001, "tom", 23, 6000);

		Function<Employee,String> func = e -> e.getName();

		System.out.println(func.apply(employee));

		System.out.println("**********************************************");

		Function<Employee,String> func1 = Employee :: getName;

		System.out.println(func1.apply(employee));
	}

}
