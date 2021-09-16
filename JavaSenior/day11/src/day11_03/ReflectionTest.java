package day11_03;

import day11_01.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 调用运行时类的指定结构：属性、方法、构造器
 *
 * @acthor KKKKK
 * @creay 2021-04-30-{TIME}
 */
public class ReflectionTest
{
    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException, InstantiationException
    {
        Class<Person> clazz = Person.class;

        //创建运行时类的对象
        Person person = clazz.newInstance();
        //获取指定的属性:要求运行时类中属性声明为public的
        //通常不采用此方法
        Field id = clazz.getField("id");

        /*
        设置当前属性的值

        set():参数一：指明设置哪个对象的属性，参数二：将此属性值设置为多少
         */
        id.set(person,1001);

        /*
        获取当前属性的值
        get():参数一：获取哪个对象的当前属性值
         */

        int i = (int) id.get(person);
        System.out.println(i);

    }

    /*
    如何操作运行时类的指定属性，需要掌握
     */
    @Test
    public void test1() throws IllegalAccessException, InstantiationException, NoSuchFieldException
    {
        Class<Person> clazz = Person.class;

        //创建运行时类的对象
        Person person = clazz.newInstance();

        //获取运行时类的指定属性
        Field age = clazz.getDeclaredField("age");

        //设置运行时类指定属性的值
        //如果该属性不是声明为public的，则需要将该属性设置为可访问的
        age.setAccessible(true);
        age.set(person,23);

        //获取运行时类指定属性的值
        int i = (int) age.get(person);
        System.out.println(i);

    }

    /*
    如何调用运行时类的指定方法，需要掌握
     */
    @Test
    public void test2() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
    {
        Class<Person> clazz = Person.class;

        Person person = clazz.newInstance();

        /*
        1.获取指定的某个方法
        getDeclaredMethod()：参数一：指明获取的方法名称 参数二：指明获取的方法的形参列表
         */
        Method display = clazz.getDeclaredMethod("display", String.class, int.class);
        display.setAccessible(true);
        /*
        invoke():参数一：方法的调用者  参数二：给方法的形参赋值的实参
        invoke()的返回值即为对应类中调用的方法的返回值
         */
        System.out.println((String) display.invoke(person, "喝可乐", 10));

        System.out.println("****************如何调用静态方法***********************");

        Method showDesc = clazz.getDeclaredMethod("showDesc");

        showDesc.setAccessible(true);

        //如果调用的运行时类中的方法没有返回值，则invoke()返回null
//        Object returnVal = showDesc.invoke(Person.class);
        Object returnVal = showDesc.invoke(null);

        showDesc.invoke(person);
    }

    /*
    如何调用运行时类的指定构造器，需要掌握
     */
    @Test
    public void test3() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException
    {
        Class<Person> clazz = Person.class;

        Constructor<Person> cons = clazz.getDeclaredConstructor(String.class);

        cons.setAccessible(true);

        Person person = cons.newInstance("kkk");

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println(name.get(person));


    }
}
