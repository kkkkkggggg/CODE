package day11_02;

import day11_01.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
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

        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = aClass.getFields();
        for(Field f : fields)
        {
            System.out.println(f);
        }

        System.out.println("************************");

        //getDeclaredFields():获取当前运行时类中声明的所有属性，不包含父类中的属性
        Field[] declaredFields = aClass.getDeclaredFields();
        for(Field field : declaredFields)
        {
            System.out.println(field);
        }
    }

    //获取权限修饰符  数据类型  变量名
    @Test
    public void test1()
    {
        Class<Person> aClass = Person.class;
        Field[] declaredFields = aClass.getDeclaredFields();

        for(Field f : declaredFields)
        {
            //1.权限修饰符
            System.out.print(Modifier.toString(f.getModifiers()) + "\t");

            //2.数据类型
            System.out.print(f.getType() + "\t");

            //3.变量名
            System.out.println(f.getName());


            System.out.println("*******************************");

        }
    }
}
