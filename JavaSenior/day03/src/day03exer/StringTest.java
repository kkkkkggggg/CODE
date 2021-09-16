package day03exer;

/**
 * @acthor KKKKK
 * @creay 2021-04-15-{TIME}
 */
public class StringTest
{
    String str = new String("good");
    char[] ch = {'t','e','s','t'};

    public void change(String str,char[] ch)
    {
        str = "test ok";
        ch[0] = 'b';



    }

    public static void main(String[] args)
    {
        StringTest ex = new StringTest();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str + " and ");//good and best
        System.out.println(ex.ch);//
    }
}
