package day03;

import org.junit.Test;


public class StringMethodTest
{
    /**
     *
     * 1.String replace(char oldChar, char newChar)：返回一个新的字符串，它是
     * 通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
     *
     * 2.String replace(CharSequence target, CharSequence replacement)：使
     * 用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
     *
     * 3.String replaceAll(String regex, String replacement)：使用给定的
     * replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
     *
     * 4.String replaceFirst(String regex, String replacement)：使用给定的
     * replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
     *
     * 5.boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
     *
     * 6.String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
     *
     * 7.String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此
     * 字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
     */
    @Test
    public void test4()
    {
        //1.String replace(char oldChar, char newChar)：返回一个新的字符串，它是
        //通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
        String str = "测试此字符串是否以指定的后缀结束";
        String str1 = str.replace("测","试");
        System.out.println(str);
        System.out.println(str1);

        //2.String replace(CharSequence target, CharSequence replacement)：使
        //用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
        String str2 = str.replace("指定","结束");
        System.out.println(str2);

        System.out.println("****************");
        //3.String replaceAll(String regex, String replacement)：使用给定的
        //replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
        String str3 = "12hello34world5java7891mysql456";
        //把字符串中的数字替换成","，如果结尾和开头有","的话去掉
        String string = str3.replaceAll("\\d+",",").replaceAll("^,|,$","");//"\\d+":正则表达式
        System.out.println(string);

        System.out.println("****************");
        //5.boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
        String str4 = "12345";
        //判断str字符串中是否全部由数字组成，即有1-n个数字组成
        boolean matches = str4.matches("\\d+");
        System.out.println(matches);

        String tel = "0571-4534289";
        //判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);

        System.out.println("****************");
        //6.String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
        String str5 = "hello|world|java";
        String[] strs = str5.split("\\|");
        for(int i = 0; i < strs.length; i++)
        {
            System.out.println(strs[i]);
        }

        System.out.println();

        String str6 = "hello.world.java";
        String[] strs2 = str6.split("\\.");
        for(int i = 0; i < strs2.length; i++)
        {
            System.out.println(strs[i]);
        }

    }

    /**
     * 1.boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
     * 2.boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
     * 3.boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的
     * 子字符串是否以指定前缀开始
     * 4.boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列
     * 时，返回 true
     * 5.int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
     * 6.int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出
     * 现处的索引，从指定的索引开始
     * 7.int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
     * 8.int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后
     * 一次出现处的索引，从指定的索引开始反向搜索
     * 注：indexOf和lastIndexOf方法如果未找到都是返回-1
     */
    @Test
    public void test3()
    {
        //1.boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
        String str = "helloworld";
        boolean b = str.endsWith("ld");
        System.out.println(b);

        //2.boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
        boolean b1 = str.startsWith("he");
        System.out.println(b1);

        boolean b2 = str.startsWith("He");
        System.out.println(b2);

        //3.boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的
        //子字符串是否以指定前缀开始
        boolean b3 = str.startsWith("ll",2);
        System.out.println(b3);

        //4.boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列
        //时，返回 true
        String str2 = "wo";
        System.out.println(str.contains(str2));

        //5.int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
        System.out.println(str.indexOf("lo"));

        //6.int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出
        //现处的索引，从指定的索引开始
        System.out.println(str.indexOf("lo",5));

        //7.int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
        String str3 = "hellorworld";
        System.out.println(str3.lastIndexOf("or"));

        //int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后
        //一次出现处的索引，从指定的索引开始反向搜索
        System.out.println(str3.lastIndexOf("or",6));
        //什么情况下，indexOf(str)和lastIndexOf(str)返回值相同
        //情况一：存在唯一的一个str，情况二：不存在str




    }




    /**
     * 1.int length()：返回字符串的长度： return value.length
     * 2.char charAt(int index)： 返回某索引处的字符return value[index]
     * 3.boolean isEmpty()：判断是否是空字符串：return value.length == 0
     * 4.String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
     * 5.String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
     * 6.String trim()：返回字符串的副本，忽略前导空白和尾部空白
     * 7.boolean equals(Object obj)：比较字符串的内容是否相同
     * 8.boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大
     * 小写
     * 9.String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
     * 10.int compareTo(String anotherString)：比较两个字符串的大小
     * 11.String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从
     * beginIndex开始截取到最后的一个子字符串。
     * 12.String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字
     * 符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
     * @acthor KKKKK
     * @creay 2021-04-15-{TIME}
     */
    @Test
    public void test2()
    {
        String s1 = "helloworld";
        String s2 = "HelloWorld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));



        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);

        String s5 = "abc";
        String s6 = new String("abe");
        System.out.println(s5.compareTo(s6));//涉及到字符串排序

        String s7 = "北京欢迎你";
        String s8 = s7.substring(2,4);
        System.out.println(s7);
        System.out.println(s8);


    }


    @Test
    public void test()
    {
        String str = "HelloWorld";

        System.out.println(str.length());
        System.out.println(str.charAt(0));
        System.out.println(str.charAt(9));
//        System.out.println(str.charAt(10));
        System.out.println(str.isEmpty());

        String str2 = str.toLowerCase();
        System.out.println(str);
        System.out.println(str2);

        String str3 = " he llo   world   ";
        String str4 = str3.trim();
        System.out.println("------" + str3 + "------");
        System.out.println("------" + str4 + "------");


    }
}
