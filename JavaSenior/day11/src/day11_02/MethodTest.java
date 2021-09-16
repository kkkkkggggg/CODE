package day11_02;

import day11_01.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的方法结构
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

        //getMethods():获取当前运行时类及其所有父类中声明为public的方法
        Method[] methods = aClass.getMethods();
        for(Method m : methods)
        {
            System.out.println(m);
        }

        System.out.println("******************************************");

        //getDeclaredMethods():获取当前运行时类中声明的所有方法(不包含父类中的方法)
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for(Method method : declaredMethods)
        {
            System.out.println(method);
        }
    }

    /*
    权限修饰符   返回值类型  方法名(参数类型一  形参名一，.......) throws XxxException{}
     */
    @Test
    public void test1()
    {
        //1.获取方法声明的注解
        Class<Person> clazz = Person.class;

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m : declaredMethods)
        {
            //1.获取方法声明的注解
            Annotation[] declaredAnnotations = m.getDeclaredAnnotations();
            System.out.println(m.toString());
            for(Annotation a : declaredAnnotations)
            {

                System.out.println(a.toString());
            }

            //2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + " ");

            //3.返回值类型
            System.out.print(m.getReturnType().getName() + " ");

            //4.方法名
            System.out.print(m.getName());

            System.out.print("(");
            //5.形参列表
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
