package com.atck.interview.step;

public class TestStep2
{
    public static void main(String[] args)
    {
        int loop = new TestStep2().loop(5);
        System.out.println(loop);
    }

    public int loop(int n)
    {
        if (n < 1)
        {
            throw new IllegalArgumentException(n + "不能小于1");
        }

        if (n == 1 || n == 2)
        {
            return n;
        }

        int one = 2;
        int two = 1;
        int sum = 0;
        for (int i = 3; i <= n; i++)
        {
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;
    }
}
