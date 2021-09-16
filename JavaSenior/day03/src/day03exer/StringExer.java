package day03exer;

import jdk.nashorn.internal.ir.IfNode;
import org.junit.Test;
import sun.font.FontRunIterator;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 *
 * 获取两个字符串中最大相同子串。比如 str1 = "abcwerthelloyuiodef"
 * str2 = "cvhellobnm"
 * @acthor KKKKK
 * @creay 2021-04-15-{TIME}
 */
public class StringExer
{
    public static void main(String[] args)
    {
        String str = "abcwerthelloyuiodef";
        String str1 = "cvhellobnm";
    }

    public String partReverse(String string,int start,int end)//将一个字符串的指定部分进行反转
    {
        if(string != null && start > 0 && end <= string.length())
        {
            StringBuffer subStr = new StringBuffer(string.substring(start - 1, end + 1));
            StringBuffer str = new StringBuffer(string);
            subStr.reverse();
            str.replace(start - 1, end + 1, String.valueOf(subStr));
            return new String(str);
        }

        return null;

    }

    public int count(String mainStr,String subStr)//获取subStr在mainStr中出现的次数,当主字符串长度小于子字符串长度或某个字符串为空时返回-1
    {
        if(mainStr.length() <= subStr.length() || mainStr == null || subStr == null)
        {
            return -1;
        }
        int len = subStr.length();
        int count = 0;
        int head = 0;

        if(mainStr.contains(subStr))
        {
            for(;;)
            {
                if(mainStr.indexOf(subStr,head) >= 0)//head = mainStr.indexOf(subStr,head) >= 0;
                {
                    count++;
                    head = mainStr.indexOf(subStr,head) + len;//head += len;
                }else
                {
                   break;
                }
            }
            return count;
        }else
        {
            return 0;
        }
    }


    //我写的版本
    public void sameMaxSubString(String str,String str1)//输出两个字符串的最大相同子串
    {
        String mainStr;
        String subStr;
        if(str.length() > str1.length())
        {
            mainStr = str1;
            subStr = str;
        }else
        {
            mainStr = str;
            subStr = str1;
        }


        int total = 0;
        for(int i = 1; i <= mainStr.length(); i++)
        {
            total += i;
        }


        String[] arr = new String[total];
        int index = 0;
        for(int i = 0; i < mainStr.length(); i++)//获取较小字符串str1的全部子串
        {
            for(int j = i + 1; j <= mainStr.length(); j++)
            {
                arr[index] = mainStr.substring(i,j);
                index++;
            }
        }


        //        String max = new String("");
        int max = 0;
        String[][] subString = new String[total][2];
        int count = 0;
        for(int i = 0; i < arr.length; i++)
        {
            //            if(str.contains(arr[i]) && arr[i].length() > max.length())
            //            {
            //                max = arr[i];
            //            }
            if(subStr.contains(arr[i]))
            {
                subString[count][0] = arr[i];
                subString[count][1] = String.valueOf(arr[i].length());
                count++;
                if(arr[i].length() > max)
                {
                    max = arr[i].length();
                }
            }
        }



        for(int i = 0; i < count; i++)
        {
            int x = Integer.parseInt(subString[i][1]);
            if(x == max)
            {
                System.out.println(subString[i][0]);
            }
        }

    }


    //老师写的版本,只有一个最大相同子串时适用
    public String getMaxSameString(String str1,String str2)
    {
        if(str1 != null && str2 != null)
        {
            String maxStr = (str1.length() >= str2.length())? str1 : str2;
            String minStr = (str1.length() < str2.length())? str1 : str2;
            int length = minStr.length();
            for(int i = 0; i < length; i++)
            {
                for(int x = 0,y = length - i ; y <= length ; x++,y++)
                {
                    String subStr = minStr.substring(x,y);
                    if(maxStr.contains(subStr))
                    {
                        return subStr;
                    }
                }
            }
        }
        return null;
    }


    //完善的版本，最大相同子串不只有一个时也适用
    public String[] getMaxSameString1(String str1,String str2)
    {
        if(str1 != null && str2 != null)
        {
            StringBuffer sbuffer = new StringBuffer();
            String maxString = (str1.length() > str2.length()) ? str1 : str2;
            String minString = (str1.length() > str2.length()) ? str2 : str1;

            int len = minString.length();
            for(int i = 0; i < len; i++)
            {
                for(int x = 0,y = len - i;y <= len;x++,y++)
                {
                    String subString = minString.substring(x,y);
                    if(maxString.contains(subString))
                    {
                        sbuffer.append(subString + ",");
                    }
                }
//                System.out.println(sbuffer);
                if(sbuffer.length() != 0)
                {
                    break;
                }
            }

            String[] split = sbuffer.toString().replaceAll(",$","").split("\\,");
            return split;
        }
        return null;
    }


    @Test
    public void test()
    {
        String str = partReverse("abcdefg",3,5);
        System.out.println(str);

        int count = count("abkkcadkabkebfkabkskab","ab");
        System.out.println(count);
    }

    @Test
    public void test1()
    {
        String str = new String("abcdefg");
        int s = str.indexOf("cd",1);
        System.out.println(s);
    }

    @Test
    public void test2()
    {
        sameMaxSubString("cvhellobnm","abcwerthelloyuiodef");
    }

    @Test
    public void test3()
    {
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";
        String max = getMaxSameString(str1,str2);
        System.out.println(max);
    }

    @Test
    public void test4()
    {
        String str1 = "abnmoncwerthelloyuiodef";
        String str2 = "cvhellobnmon";
        String[] maxSameString = getMaxSameString1(str1,str2);
        System.out.println(Arrays.toString(maxSameString));
    }
}
