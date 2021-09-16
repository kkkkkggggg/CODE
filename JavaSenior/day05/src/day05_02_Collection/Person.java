package day05_02_Collection;

import com.sun.org.apache.xpath.internal.operations.String;

/**
 * @acthor KKKKK
 * @creay 2021-04-20-{TIME}
 */
public class Person
{
    private String name;
    private int age;

    public Person()
    {
    }

    public Person(int age)
    {
        this.age = age;
    }

    public Person(String name)
    {
        this.name = name;
    }

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public Person(java.lang.String jerry, int age)
    {
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
    public java.lang.String toString()
    {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    @Override
    public boolean equals(Object o)
    {
        System.out.println("**************");
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;

        Person person = (Person) o;

        if(age != person.age)
            return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }
//
//    @Override
//    public int hashCode()
//    {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + age;
//        return result;
//    }
}