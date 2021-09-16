package day11_02;


import day11_01.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @acthor KKKKK
 * @creay 2021-04-30-{TIME}
 */
public class OtherTest
{
    /*
    获取构造器结构
     */
    @Test
    public void test()
    {
        Class<Person> personClass = Person.class;

        //getConstructors()：获取当前运行时类中声明为public的构造器
        Constructor<?>[] constructors = personClass.getConstructors();

        for(Constructor c : constructors)
        {
            System.out.println(c);
        }

        System.out.println("*************************************");

        //getDeclaredConstructors():获取当前运行时类中声明的所有构造器
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for(Constructor d : declaredConstructors)
        {
            System.out.println(d);
        }

    }

    /*
    获取运行时类的父类
     */
    @Test
    public void test2()
    {
        Class<Person> personClass = Person.class;

        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);
    }

    /*
   获取运行时类带泛型的父类
    */
    @Test
    public void test3()
    {
        Class<Person> personClass = Person.class;

        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }


    /*
  获取运行时类带泛型的父类的泛型
   */
    @Test
    public void test4()
    {
        Class<Person> personClass = Person.class;

        Type genericSuperclass = personClass.getGenericSuperclass();

        ParameterizedType type = (ParameterizedType)genericSuperclass;

        //获取泛型参数
        Type[] actualTypeArguments = type.getActualTypeArguments();

        for(Type t : actualTypeArguments)
        {
            System.out.println(t.getTypeName());
        }

        System.out.println(genericSuperclass);
    }

    /*
    获取运行时类实现的接口
     */
    @Test
    public void test5()
    {
        Class<Person> personClass = Person.class;

        Class<?>[] interfaces = personClass.getInterfaces();

        for(Class c : interfaces)
        {
            System.out.println(c.getName());
        }

        System.out.println("*****************");

        //获取运行时类的父类所实现的接口
        Class<? super Person> superclass = personClass.getSuperclass();

        Class<?>[] interfaces1 = superclass.getInterfaces();

        for(Class c1 : interfaces1)
        {
            System.out.println(c1.getName());
        }
    }

    /*
    获取运行时类所在的包
     */
    @Test
    public void test6()
    {
        Class<Person> personClass = Person.class;

        System.out.println(personClass.getPackage());


        //获取运行时类的注解
        Annotation[] annotations = personClass.getAnnotations();

        for(Annotation a : annotations)
        {

            System.out.println(a);
        }




    }

}
