package ideadebug;

import org.junit.Test;

/**
 * @acthor KKKKK
 * @creay 2021-04-17-{TIME}
 */
public class IDEADebug
{
    @Test
    public void test()
    {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);//

        System.out.println(sb.length());//4

        System.out.println(sb);//"null"

        StringBuffer sb1 = new StringBuffer(str);//抛异常
        System.out.println(sb1);
    }
}
