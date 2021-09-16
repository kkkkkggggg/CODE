package day11_02;

import day11_01.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * ��ȡ����ʱ��ķ����ṹ
 *
 * @acthor KKKKK
 * @creay 2021-04-29-{TIME}
 */
public class MethodTest
{
    @Test
    public void test()
    {
        Class<Person> aClass = Person.class;

        //getMethods():��ȡ��ǰ����ʱ�༰�����и���������Ϊpublic�ķ���
        Method[] methods = aClass.getMethods();
        for(Method m : methods)
        {
            System.out.println(m);
        }

        System.out.println("******************************************");

        //getDeclaredMethods():��ȡ��ǰ����ʱ�������������з���(�����������еķ���)
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for(Method method : declaredMethods)
        {
            System.out.println(method);
        }
    }

    /*
    Ȩ�����η�   ����ֵ����  ������(��������һ  �β���һ��.......) throws XxxException{}
     */
    @Test
    public void test1()
    {
        //1.��ȡ����������ע��
        Class<Person> clazz = Person.class;

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m : declaredMethods)
        {
            //1.��ȡ����������ע��
            Annotation[] declaredAnnotations = m.getDeclaredAnnotations();
            System.out.println(m.toString());
            for(Annotation a : declaredAnnotations)
            {

                System.out.println(a.toString());
            }

            //2.Ȩ�����η�
            System.out.print(Modifier.toString(m.getModifiers()) + " ");

            //3.����ֵ����
            System.out.print(m.getReturnType().getName() + " ");

            //4.������
            System.out.print(m.getName());

            System.out.print("(");
            //5.�β��б�
            Class<?>[] parameterTypes = m.getParameterTypes();
            if(!(parameterTypes == null && parameterTypes.length == 0))
            {

                for(int i = 0;i < parameterTypes.length;i++)
                {
                    if(i == parameterTypes.length - 1)
                    {
                        System.out.print(parameterTypes[i].getName());
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + ",");
                }
            }

            System.out.print(") ");

            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if(exceptionTypes.length > 0)
            {
                System.out.print("throws ");
                for(int i = 0; i < exceptionTypes.length; i++)
                {
                    if(i == exceptionTypes.length - 1)
                    {
                        System.out.println(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }

            }else
            {
                System.out.println();
            }

            System.out.println("**************************************");
        }


    }
}
