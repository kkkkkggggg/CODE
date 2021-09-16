package day06_MapTest;

/**
 * @acthor KKKKK
 * @creay 2021-04-21-{TIME}
 */
public class User implements Comparable
{
    private String name;
    private int age;

    public User()
    {
    }

    public User(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public User(String name)
    {
        this.name = name;
    }

    public User(int age)
    {
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
        return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    @Override
    public boolean equals(Object o)
    {
        System.out.println("User equals()");
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;

        User user = (User) o;

        if(age != user.age)
            return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode()
    {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    //按照姓名从小到大排列,年龄从小到大排列
    @Override
    public int compareTo(Object o)
    {
        if(o instanceof User)
        {
            User user = (User)o;
            if(this.name.compareTo(user.name) == 0)
            {
               return Integer.compare(this.age,user.age);
            }
            return this.name.compareTo(user.name);
        }else
        {
            throw new RuntimeException("输入的类型不匹配");
        }

    }
}