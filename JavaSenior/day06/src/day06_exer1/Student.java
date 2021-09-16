package day06_exer1;

import java.util.Set;

/**
 * @acthor KKKKK
 * @creay 2021-04-22-{TIME}
 */
public class Student implements Comparable
{
    private String name;
    private int score;

    public Student()
    {
    }

    public Student(String name, int score)
    {
        this.name = name;
        this.score = score;
    }

    public String getName()
    {
        return name;
    }

    public int getScore()
    {
        return score;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    @Override
    public String toString()
    {
        return "姓名:" + name + " 分数:" + score;
    }

    @Override
    public int compareTo(Object o)
    {
        if(o instanceof Student)
        {
            Student s = (Student)o;
            return -Integer.compare(this.score,s.score);
        }
        throw new RuntimeException("输入的数据不符合要求");
    }
}
