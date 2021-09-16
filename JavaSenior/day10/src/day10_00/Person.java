package day10_00;

import java.io.Serializable;

/**
 * Person类需要满足如下要求方可序列化
 * 1.需要实现接口：Serializable
 * 2.需要当前类提供一个全局常量：serialVersionUID
 * 3.除了当前Person类需要实现Seriallizable接口之外，还必须保证其内部所有属性也必须是可序列化的
 * (默认情况下，基本数据类型可序列化)
 *
 *
 * 补充：ObjectOutputStream和ObjectInputStream不能序列化static和transient修
 * 饰的成员变量
 *
 * @acthor KKKKK
 * @creay 2021-04-27-{TIME}
 */
public class Person implements Serializable
{
    public static final long serialVersionUID = 46513216653L;

    private String name;
    private int age;

    public Person()
    {
    }

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
