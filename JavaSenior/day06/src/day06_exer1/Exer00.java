package day06_exer1;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 1.请从键盘随机输入10个整数保存到List中，并按倒序、从大
 * 到小的顺序显示出来
 * @acthor KKKKK
 * @creay 2021-04-22-{TIME}
 */
public class Exer00
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        List list = new ArrayList();
        System.out.println("请输入整数");
        for(int i = 0; i < 10; i++)
        {
            int s = scan.nextInt();
            list.add(i,s);
        }

        Collections.sort(list);

        System.out.println(list);

    }

    @Test
    public void test()
    {
        /*
        2.请把学生名与考试分数录入到集合中，并按分数显示前三名
            成绩学员的名字。
         */
        List list = new ArrayList();
        list.add(new Student("小一",60));
        list.add(new Student("小六",79));
        list.add(new Student("小十",43));
        list.add(new Student("小八",91));
        list.add(new Student("小三",86));
        list.add(new Student("小七",96));
        list.add(new Student("小四",59));

        Collections.sort(list);
        for(int i = 0; i < 3; i++)
        {
            Student s = (Student)list.get(i);
            System.out.println(s.getName());
        }
    }



}
