package day07_exer_01;

/**
 * @acthor KKKKK
 * @creay 2021-04-23-{TIME}
 */
public class User
{
    private int id;
    private int age;
    private String name;

    public User()
    {
    }

    public User(int id, int age, String name)
    {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public int getAge()
    {
        return age;
    }

    public String getName()
    {
        return name;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "User{" + "id=" + id + ", age=" + age + ", name='" + name + '\'' + '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;

        User user = (User) o;

        if(id != user.id)
            return false;
        if(age != user.age)
            return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
