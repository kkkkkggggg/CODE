package day11_01;

/**
 * @acthor KKKKK
 * @creay 2021-04-29-{TIME}
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface
{
    private String name;
    int age;
    public int id;

    public Person()
    {
    }



    @MyAnnotation(value = "abc")
    private Person(String name)
    {
        this.name = name;
    }

    Person(String name,int age)
    {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation)
    {
        System.out.println("我的国籍是" + nation);
        return nation;
    }

    public String display(String interest,int age) throws NullPointerException,ClassCastException
    {
        return interest + age;
    }

    @Override
    public void info()
    {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o)
    {
        return 0;
    }

    private static void showDesc()
    {
        System.out.println("123456789");
    }
}
