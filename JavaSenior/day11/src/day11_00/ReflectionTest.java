package day11_00;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @acthor KKKKK
 * @creay 2021-04-29-{TIME}
 */
public class ReflectionTest
{
    //����֮ǰ����Person��Ĳ���
    @Test
    public void test()
    {
        //1.����Person��Ķ���
        Person p1 = new Person("tom",12);

        //2.ͨ�����󣬵������ڲ������ԣ�����
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        //��Person����ⲿ��������ͨ��Person��Ķ���������ڲ�˽�еĽṹ
        //���磺name��showNation()�Լ�˽�еĹ�����


    }


    //����֮��
    // ����Person��Ĳ���
    @Test
    public void test1() throws Exception
    {
        Class<Person> aClass = Person.class;

        //1.ͨ�����䣬����Person��Ķ���
        Constructor<Person> cons = aClass.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("tom", 12);
        Person p = (Person)obj;
        System.out.println(p);

        //2.ͨ��������ö����ָ�������ԣ�����

        //��������
        Field age = aClass.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());

        //���÷���
        Method show = aClass.getDeclaredMethod("show");
        show.invoke(p);

        //ͨ�����䣬���Ե���˽�е����ԡ�������������
        Constructor<Person> cons1 = aClass.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = cons1.newInstance("jerry");
        System.out.println(p1);

        //����˽�е�����
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"Hanmeimei");
        System.out.println(p1);

        //����˽�еķ���
        Method showNation = aClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String str = (String) showNation.invoke(p1,"�й�");//�൱��p1.showNation("�й�")��
        System.out.println(str);
    }
    //���ʣ�ͨ��ֱ��new�ķ�ʽ����ķ�ʽ������ֱ�ӵ��ù����Ľṹ�������е������ĸ���
    //���飺ֱ��new�ķ�ʽ
    //ʲôʱ���ʹ�ã�����ķ�ʽ�� ����ķ�ʽ����̬��
    //���ʣ������������������еķ�װ���ǲ���ì�ܵģ���ο������ּ�����

    /*
    ����java.lang.Class������
    1.��ļ��ع��̣�
    ���򾭹�javac.exe�����Ժ󣬻�����һ�������ֽ����ļ�(.class��β)����������ʹ��java.exe
    mingl��ĳ���ֽ����ļ����н������У��൱�ڽ�ĳ���ֽ����ļ����ص��ڴ��У��˹��̾ͳ�Ϊ��ļ���
    �����ص��ڴ��е��࣬���Ǿͳ�Ϊ����ʱ�࣬������ʱ�࣬����ΪClass��һ��ʵ����

    2.���仰˵��Class��ʵ����Ӧ��һ������ʱ��

    3.���ص��ڴ��е�����ʱ�࣬�Ỻ��һ����ʱ�䣬�ڴ�ʱ��֮�ڣ����ǿ���ͨ����ͬ�ķ�ʽ����ȡ����ʱ��
     */

    //��ȡClass��ʵ���ķ�ʽ(ǰ���ַ�ʽ��Ҫ����)
    @Test
    public void test2() throws ClassNotFoundException
    {
        //��ʽһ����������ʱ������ԣ�.class
        Class<Person> clazz1 = Person.class;

        System.out.println(clazz1);

        //��ʽ����ͨ������ʱ��Ķ���
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //��ʽ��������Class�ľ�̬������forname(String classPath)
        Class<?> clazz3 = Class.forName("day11_00.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);

        //��ʽ�ģ�ʹ����ļ�����
        ClassLoader loader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = loader.loadClass("day11_00.Person");
        System.out.println(clazz4);

        System.out.println(clazz1 == clazz4);


    }

    //Class��������Щʵ����˵��
    @Test
    public void test4()
    {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // ֻҪԪ��������ά��һ��������ͬһ��Class
        System.out.println(c10 == c11);
        System.out.println(c4);

    }
}
