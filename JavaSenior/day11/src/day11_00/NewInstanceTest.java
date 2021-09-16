package day11_00;

import org.junit.Test;

import java.util.Random;

/**
 * ͨ�����䴴����Ӧ������ʱ��Ķ���
 *
 * @acthor KKKKK
 * @creay 2021-04-29-{TIME}
 */
public class NewInstanceTest
{
    @Test
    public void test() throws IllegalAccessException, InstantiationException
    {
        Class<Person> clazz = Person.class;

        //newInstance():���ô˷�����������Ӧ������ʱ��Ķ���
        //Ҫ��˷��������Ĵ�������ʱ��Ķ���Ҫ��
        //1.����ʱ�����Ҫ�ṩ�ղεĹ�����
        //2.�ղεĹ������ķ���Ȩ�޲���С��ȱʡ��ͨ��������Ϊpublic


        //ͨ����JavaBean��Ҫ���ṩһ��public�Ŀղι�����
        //1.����ͨ�����䣬��������ʱ��Ķ���
        //2.��������̳д���ʱ��Ĭ�ϵ���super()ʱ����֤�����д˹�����

        Person p1 = clazz.newInstance();

        System.out.println(p1);


    }

    //��ᷴ��Ķ�̬��
    @Test
    public void test1()
    {
        int num = new Random().nextInt(3);//0,1,2
        String classPath = "";
        switch(num)
        {
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "day11_00.Person";
                break;
        }

        try
        {
            Object instance = getInstance(classPath);
            System.out.println(instance);
        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }catch(InstantiationException e)
        {
            e.printStackTrace();
        }
    }



    /*
    ����һ��ָ����Ķ���
    classPath:ָ�����ȫ����
     */
    public Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException
    {
        Class<?> aClass = Class.forName(classPath);
        return aClass.newInstance();
    }
}
