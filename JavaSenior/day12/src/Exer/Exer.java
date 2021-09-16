package Exer;

public class Exer
{




    public String trim(String str,char c)
    {



        return "";
    }

    public String trim(String str)
    {
        if (str == null)
        {
            return "请输入正确的字符串";
        }

        char[] arr = str.toCharArray();
        int begin = 0;
        int end = arr.length;
        while (arr[begin] == ' ')
        {
            begin++;
        }

        while(arr[end] == ' ')
        {
            end--;
        }


        return "";
    }

    public static void main(String[] args)
    {
        String str = "   123456   ";
        char[] arr = str.toCharArray();
        int begin = 0;
        int end = arr.length - 1;
        while (arr[begin] == ' ')
        {
            begin++;
        }
        while(arr[end] == ' ')
        {
            end--;
        }

        String str1 = "";
        for (int i = begin; i <= end; i++)
        {
            str1 += arr[i];
        }

        System.out.println(str1);

    }
}
