package day11_02;

import day11_01.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * ��ȡ��ǰ����ʱ������Խṹ
 *
 * @acthor KKKKK
 * @creay 2021-04-29-{TIME}
 */
public class FieldTest
{
    @Test
    public void test() throws IllegalAccessException, InstantiationException
    {
        Class<Person> aClass = Person.class;

        //��ȡ���Խṹ
        //getFields():��ȡ��ǰ����ʱ�༰�丸��������Ϊpublic����Ȩ�޵�����
        Field[] fields = aClass.getFields();
        for(Field f : fields)
        {
            System.out.println(f);
        }

        System.out.println("************************");

        //getDeclaredFields():��ȡ��ǰ����ʱ�����������������ԣ������������е�����
        Field[] declaredFields = aClass.getDeclaredFields();
        for(Field field : declaredFields)
        {
            System.out.println(field);
        }
    }

    //��ȡȨ�����η�  ��������  ������
    @Test
    public void test1()
    {
        Class<Person> aClass = Person.class;
        Field[] declaredFields = aClass.getDeclaredFields();

        for(Field f : declaredFields)
        {
            //1.Ȩ�����η�
            System.out.print(Modifier.toString(f.getModifiers()) + "\t");

            //2.��������
            System.out.print(f.getType() + "\t");

            //3.������
            System.out.println(f.getName());


            System.out.println("*******************************");

        }
    }
}
