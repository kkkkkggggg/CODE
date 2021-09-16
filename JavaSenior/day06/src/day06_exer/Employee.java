package day06_exer;

/**
 * @acthor KKKKK
 * @creay 2021-04-21-{TIME}
 */
public class Employee implements Comparable
{
    private String name;
    private int age;
    private MyDate birthDay;

    public Employee()
    {
    }

    public Employee(String name, int age, MyDate birthDay)
    {
        this.name = name;
        this.age = age;
        this.birthDay = birthDay;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public MyDate getBirthDay()
    {
        return birthDay;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setBirthDay(MyDate birthDay)
    {
        this.birthDay = birthDay;
    }

    @Override
    public String toString()
    {
        return "Employee{" + "姓名:" + name + '\'' + ", 年龄:" + age + ", 生日:" + birthDay + '}';
    }

    @Override
    public int compareTo(Object o)
    {
        if(o instanceof Employee)
        {
            Employee e = (Employee)o;

            return this.name.compareTo(e.name);
        }

        throw new RuntimeException("输入的数据不符合要求");
    }
}
