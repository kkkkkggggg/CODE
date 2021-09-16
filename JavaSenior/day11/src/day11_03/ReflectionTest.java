package day11_03;

import day11_01.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ��������ʱ���ָ���ṹ�����ԡ�������������
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

        //��������ʱ��Ķ���
        Person person = clazz.newInstance();
        //��ȡָ��������:Ҫ������ʱ������������Ϊpublic��
        //ͨ�������ô˷���
        Field id = clazz.getField("id");

        /*
        ���õ�ǰ���Ե�ֵ

        set():����һ��ָ�������ĸ���������ԣ�����������������ֵ����Ϊ����
         */
        id.set(person,1001);

        /*
        ��ȡ��ǰ���Ե�ֵ
        get():����һ����ȡ�ĸ�����ĵ�ǰ����ֵ
         */

        int i = (int) id.get(person);
        System.out.println(i);

    }

    /*
    ��β�������ʱ���ָ�����ԣ���Ҫ����
     */
    @Test
    public void test1() throws IllegalAccessException, InstantiationException, NoSuchFieldException
    {
        Class<Person> clazz = Person.class;

        //��������ʱ��Ķ���
        Person person = clazz.newInstance();

        //��ȡ����ʱ���ָ������
        Field age = clazz.getDeclaredField("age");

        //��������ʱ��ָ�����Ե�ֵ
        //��������Բ�������Ϊpublic�ģ�����Ҫ������������Ϊ�ɷ��ʵ�
        age.setAccessible(true);
        age.set(person,23);

        //��ȡ����ʱ��ָ�����Ե�ֵ
        int i = (int) age.get(person);
        System.out.println(i);

    }

    /*
    ��ε�������ʱ���ָ����������Ҫ����
     */
    @Test
    public void test2() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
    {
        Class<Person> clazz = Person.class;

        Person person = clazz.newInstance();

        /*
        1.��ȡָ����ĳ������
        getDeclaredMethod()������һ��ָ����ȡ�ķ������� ��������ָ����ȡ�ķ������β��б�
         */
        Method display = clazz.getDeclaredMethod("display", String.class, int.class);
        display.setAccessible(true);
        /*
        invoke():����һ�������ĵ�����  �����������������βθ�ֵ��ʵ��
        invoke()�ķ���ֵ��Ϊ��Ӧ���е��õķ����ķ���ֵ
         */
        System.out.println((String) display.invoke(person, "�ȿ���", 10));

        System.out.println("****************��ε��þ�̬����***********************");

        Method showDesc = clazz.getDeclaredMethod("showDesc");

        showDesc.setAccessible(true);

        //������õ�����ʱ���еķ���û�з���ֵ����invoke()����null
//        Object returnVal = showDesc.invoke(Person.class);
        Object returnVal = showDesc.invoke(null);

        showDesc.invoke(person);
    }

    /*
    ��ε�������ʱ���ָ������������Ҫ����
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
