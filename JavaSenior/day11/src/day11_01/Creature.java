package day11_01;

import java.io.Serializable;

/**
 * @acthor KKKKK
 * @creay 2021-04-29-{TIME}
 */
public class Creature<T> implements Serializable
{
    private char gender;
    public double weight;

    private void breath()
    {
        System.out.println("�������");
    }

    public void eat()
    {
        System.out.println("����Զ���");
    }
}
