package day09_01;

import org.junit.Test;

import java.io.*;

/**
 * 其他流的使用
 * 1.标准的输入输出流
 * 2.打印流
 * 3.数据流
 *
 * @acthor KKKKK
 * @creay 2021-04-26-{TIME}
 */
public class OtherStreamTest
{
    /*
    1.标准的输入、输出流
    System.in:标准的输入流，默认从键盘输入
    System.out:标准的输出流，默认从控制台输出
    1.2
    System类的setIn(InputStream is) / setOut(PrintStream ps)方式重新指定输入和输出的默认设备进行改变

    1.3练习
    从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续
    进行输入操作，直至当输入“e”或者“exit”时，退出程序

    方法一：使用Scanner实现
    方法二：使用System.in实现，System.in ----> 转换流 ---->BufferedReader的readLine()
     */

    @Test
    public void test()
    {
        BufferedReader br = null;
        FileWriter fw = null;
        try
        {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            fw = new FileWriter("Test.txt");

            String str;
            while((str = br.readLine()) != null)
            {
                System.out.println("请输入字符串");

                if("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str))
                {
                    System.out.println("程序结束");
                    break;
                }

                fw.write(str);
            }

        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                if(br != null)
                    br.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                if(fw != null)
                    fw.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {

        //        BufferedReader br = null;
        //
        //        try
        //        {
        //            InputStreamReader isr = new InputStreamReader(System.in);
        //            br = new BufferedReader(isr);
        //
        //            while(true)
        //            {
        //                System.out.println("请输入字符串");
        //                String str = br.readLine();
        //                if("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str))
        //                {
        //                    System.out.println("程序结束");
        //                    break;
        //                }
        //
        //                String upperCase = str.toUpperCase();
        //                System.out.println(upperCase);
        //            }
        //
        //        }catch(IOException e)
        //        {
        //            e.printStackTrace();
        //        }finally
        //        {
        //            try
        //            {
        //                if(br != null)
        //                    br.close();
        //            }catch(IOException e)
        //            {
        //                e.printStackTrace();
        //            }
        //        }
        //    }
        BufferedReader br = null;
        FileWriter fw = null;
        try
        {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            fw = new FileWriter("Test.txt");

            System.out.println("请输入数据");
            String str;
            while((str = br.readLine()) != null)
            {
                if("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str))
                {
                    System.out.println("程序结束");
                    break;
                }

                fw.write(str + "\n");
            }

        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                if(br != null)
                    br.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                if(fw != null)
                    fw.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /*
    2.打印流：PrintStreamm 和 PrintWriter

    2.1 提供了一系列重载的print()和println()
    2.2 练习
     */

    @Test
    public void test1()
    {
        PrintStream ps = null;
        try
        {
            FileOutputStream fos = new FileOutputStream(new File("D:\\IO\\text.txt"));
            // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if(ps != null)
            {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }
            for(int i = 0; i <= 255; i++)
            { // 输出ASCII字符
                System.out.print((char) i);
                if(i % 50 == 0)
                { // 每50个数据一行
                    System.out.println(); // 换行
                }
            }
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }finally
        {
            if(ps != null)
            {
                ps.close();
            }
        }
    }

    /*
    3.数据流
    3.1 DataInputStream 和 DataOutputStream
    3.2 作用：用于读取或写出基本数据类型的变量或字符串

    练习：将内存中的字符串、基本数据类型的变量写出到文件中

    注意：处理异常的话，仍然使用try-catch-finally
     */
    @Test
    public void test2() throws IOException
    {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
        dos.writeUTF("ABC");
        dos.flush();
        dos.writeInt(23);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();

        dos.close();
    }

    /*
    将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中
    注意：读取不同类型的数据的顺序要与当初写入文件时的顺序一致
     */
    @Test
    public void test3() throws IOException
    {
        //1.
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));

        //2.
        String name = dis.readUTF();
        int age = dis.readInt();
        boolean isMale = dis.readBoolean();

        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("isMale = " + isMale);

        //3.
        dis.close();
    }

}
