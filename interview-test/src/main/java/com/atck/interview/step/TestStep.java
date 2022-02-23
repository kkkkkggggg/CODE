package com.atck.interview.step;

public class TestStep
{
    /**
     * 求n步台阶，每次只能走一步或两步，一共有多少种走法
     * @param n
     * @return
     */
    public int f(int n)
    {
        if (n < 1)
        {
            throw new IllegalArgumentException(n + "不能小于一");
        }

        if(n == 2 || n ==1)
        {
            return n;
        }

        return f(n - 2) + f(n - 1);
    }

    public static void main(String[] args)
    {
        int f = new TestStep().f(50);
        System.out.println(f);
    }
}
