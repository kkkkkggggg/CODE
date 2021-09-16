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
    ��ȡ�������ṹ
     */
    @Test
    public void test()
    {
        Class<Person> personClass = Person.class;

        //getConstructors()����ȡ��ǰ����ʱ��������Ϊpublic�Ĺ�����
        Constructor<?>[] constructors = personClass.getConstructors();

        for(Constructor c : constructors)
        {
            System.out.println(c);
        }

        System.out.println("*************************************");

        //getDeclaredConstructors():��ȡ��ǰ����ʱ�������������й�����
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for(Constructor d : declaredConstructors)
        {
            System.out.println(d);
        }

    }

    /*
    ��ȡ����ʱ��ĸ���
     */
    @Test
    public void test2()
    {
        Class<Person> personClass = Person.class;

        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);
    }

    /*
   ��ȡ����ʱ������͵ĸ���
    */
    @Test
    public void test3()
    {
        Class<Person> personClass = Person.class;

        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }


    /*
  ��ȡ����ʱ������͵ĸ���ķ���
   */
    @Test
    public void test4()
    {
        Class<Person> personClass = Person.class;

        Type genericSuperclass = personClass.getGenericSuperclass();

        ParameterizedType type = (ParameterizedType)genericSuperclass;

        //��ȡ���Ͳ���
        Type[] actualTypeArguments = type.getActualTypeArguments();

        for(Type t : actualTypeArguments)
        {
            System.out.println(t.getTypeName());
        }

        System.out.println(genericSuperclass);
    }

    /*
    ��ȡ����ʱ��ʵ�ֵĽӿ�
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

        //��ȡ����ʱ��ĸ�����ʵ�ֵĽӿ�
        Class<? super Person> superclass = personClass.getSuperclass();

        Class<?>[] interfaces1 = superclass.getInterfaces();

        for(Class c1 : interfaces1)
        {
            System.out.println(c1.getName());
        }
    }

    /*
    ��ȡ����ʱ�����ڵİ�
     */
    @Test
    public void test6()
    {
        Class<Person> personClass = Person.class;

        System.out.println(personClass.getPackage());


        //��ȡ����ʱ���ע��
        Annotation[] annotations = personClass.getAnnotations();

        for(Annotation a : annotations)
        {

            System.out.println(a);
        }




    }

}
