package day11_00;

/**
 * @acthor KKKKK
 * @creay 2021-04-29-{TIME}
 */
public class Person
{
    private String name;
    public int age;

    public Person()
    {
        System.out.println("Person");
    }

    public Person(int age)
    {
        this.age = age;
    }

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    private Person(String name)
    {
        this.name = name;

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

    public void show()
    {
        System.out.println("����һ����");
    }

    private String showNation(String nation)
    {
        System.out.println("�ҵĹ�����" + nation);
        return nation;
    }
}
