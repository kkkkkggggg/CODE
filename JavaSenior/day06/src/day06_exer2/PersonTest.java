package day06_exer2;

import org.junit.Test;

import java.util.HashSet;

/**
 * @acthor KKKKK
 * @creay 2021-04-21-{TIME}
 */
public class PersonTest
{
    @Test
    public void test()
    {
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");

        set.add(p1);
        set.add(p2);
        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);//[Person{id=1002, name='BB'}, Person{id=1001, name='CC'}]
        //改了P1的name之后，哈希值与原来的p1不一样，导致找不到之前存P1的位置，删除失败

        set.add(new Person(1001,"CC"));
        System.out.println(set);//[Person{id=1002, name='BB'}, Person{id=1001, name='CC'}, Person{id=1001, name='CC'}]
        set.add(new Person(1001,"AA"));
        System.out.println(set);//[Person{id=1002, name='BB'}, Person{id=1001, name='CC'}, Person{id=1001, name='CC'}, Person{id=1001, name='AA'}]



    }
}


