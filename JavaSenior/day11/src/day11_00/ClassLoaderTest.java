package day11_00;

import org.junit.Test;
import sun.security.jca.GetInstance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * @acthor KKKKK
 * @creay 2021-04-29-{TIME}
 */
public class ClassLoaderTest
{
    @Test
    public void test()
    {
        //�����Զ�����ʹ��ϵͳ����������м���
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //����ϵͳ���������getParent()����ȡ��չ�������
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);

        //ͨ��������չ���������getParent():�޷���ȡ�����������
        //�������������Ҫ�������java�ĺ�����⣬�޷������Զ�����
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
    }

    /*
    Properties:������ȡ�����ļ�
     */
    @Test
    public void test1() throws IOException
    {
        Properties pros = new Properties();
        //��ʱ���ļ�Ĭ���ڵ�ǰ��module��
        //��ȡ�����ļ��ķ�ʽһ
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        pros.load(fis);

        //��ȡ�����ļ��ķ�ʽ����ʹ��ClassLoader
        //�����ļ�Ĭ��ʶ��·��Ϊ��ǰmodule��src��
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);


        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println("name = " + name + " password = " + password);

    }
    @Test
    public void test2() throws NoSuchMethodException
    {
        Class<Person> clazz = Person.class;

        Constructor<Person> constructor = clazz.getDeclaredConstructor();

        constructor.setAccessible(true);


    }

    @Test
    public void test3()
    {
        System.out.println(Person.class.getClassLoader());

    }
}
