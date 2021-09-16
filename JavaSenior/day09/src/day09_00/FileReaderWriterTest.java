package day09_00;

import com.sun.imageio.plugins.common.InputStreamAdapter;
import jdk.internal.util.xml.impl.Input;
import org.junit.Test;
import org.omg.CORBA.portable.InputStream;

import java.io.*;

/**
 * 一、流的分类
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 *
 * 二、流的体系结构
 * 抽象基类           节点流(或文件流)                                  缓冲流(处理流的一种)
 * InputStream       FileInputStream(read(byte[] buffer))             BufferedInputStream( read(byte[] buffer) )
 * OutputStream      FileOutputStream(write(byte[] buffer,0,len))     BufferedOutputStream( write(byte[] buffer,0,len) )
 * Reader            FileReader(read(char[] cbuf))                    BufferedReader(read( char[] cbuf) / readline() )
 * Writer            FileWriter(write(char[] cubf,0,len))             BufferedWriter( write(char[] cubf,0,len) )
 *
 *
 *
 *
 *  * @acthor KKKKK
 * @creay 2021-04-24-{TIME}
 */
public class FileReaderWriterTest
{
    //关于FileReader的使用
    //将day09下的hello.txt文件内容读入程序中，并输出到控制台
    //说明点：
    //1.read():返回读入的一个字符，如果达到文件末尾，返回-1
    //2.异常的处理：为了保证流资源可以执行关闭操作，需要使用try-catch-finally处理
    //3.读入的文件一定要存在，否则会报FileNotFoundException
    @Test
    public void testFileReader()
    {

        FileReader fr = null;
        try
        {
            //1.实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");

            //2.提供具体的流
            fr = new FileReader(file);
            //3.数据的读入
            //read():返回读入的一个字符，如果达到文件末尾，返回-1

            //        for(;;)               //这种方法会导致在for循环后的语句报错报错，Unreachable statement
            //        {
            //            int i = 0;
            //            if((i = fr.read()) < 0)
            //            {
            //                return;
            //            }
            //            System.out.println((char)i);
            //        }

            //方式一
            //        int data = fr.read();
            //        while(data != -1)
            //        {
            //            System.out.print((char)data);
            //            data = fr.read();
            //        }

            //方式二:语法上针对方式一的修改
            int data;
            while((data = fr.read()) != -1)
            {
                System.out.print((char)data);
            }

        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
            //4.流的关闭操作
//            try
//            {
//                if(fr != null)
//                fr.close();
//            }catch(IOException e)
//            {
//                e.printStackTrace();
//            }
            //或
            if(fr != null)
            {
                try
                {
                    fr.close();
                }catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    //对read()操作升级：使用read重载的方法
    @Test
    public void testFileReader1()
    {

        FileReader fr = null;
        //1.File类实例化
        try
        {
            File file = new File("hello.txt");
            //2.FileReader流的实例化
            fr = new FileReader(file);
            //3.读入的操作
            //read(char[] cbuf):返回每次读入到数组中的字符的个数，如果达到文件末尾，返回-1
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1)
            {
                //方式一
//                for(int i = 0; i < len; i++)//for(int i = 0; i < cbuf.length; i++)//错误写法
//                {
//                    System.out.println(cbuf[i]);
//                }

                //方式二
                //错误的写法，对应着方式一的错误写法
//                String str = new String(cbuf);
//                System.out.println(str);

                String str = new String(cbuf,0,len);
                System.out.print(str);

            }


        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {

            try
            {
                if(fr != null)
                //4.资源的关闭
                fr.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test() throws IOException
    {
        File file = new File("hello.txt");

        FileReader fr = new FileReader(file);

        char[] arr = new char[5];
        System.out.println(fr.read(arr));
        System.out.println(fr.read(arr));
        System.out.println(fr.read(arr));
        System.out.println(fr.read(arr));
    }


    /*
    从内存中写出数据到硬盘的文件里

    说明：
    1.输出操作，对应的File可以是不存在的
            File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建文件
            File对应的硬盘中的文件如果存在：
                    如果流使用的构造器是：FileWriter(file,false)/FileWriter(file):对原有的文件进行覆盖
                    如果流使用的构造器是:FileWriter(file,true):在原有文件的基础上进行修改

     */
    @Test
    public void testFileWriter() throws IOException
    {
        //1.提供File类的对象，指明写出到的文件
        File file = new File("hello1.txt");

        //2.提供FileWriter类的对象，用于数据的写出

        FileWriter fw = new FileWriter(file);
//        FileWriter fw = new FileWriter(file,false); //false表示不在原有的文件基础上添加
//        FileWriter fw = new FileWriter(file,true);  //true表示可以在原有文件基础上添加

        //3.写出的操作
        fw.write("helloworld\n");
        fw.write("123456789");

        fw.append('c');

        //流资源的关闭
        fw.close();
    }

    @Test
    public void testFileReaderFileWriter()
    {
        FileReader fr = null;
        FileWriter fw = null;
        try
        {
            //1.创建File类的对象，指明读入和写出的文件
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");

            //不能使用字符流来处理图片等字节文件
//            File srcFile = new File("image.jpg");
//            File destFile = new File("image1.jpg");
            //2.创建输入和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;//记录每次读入到cbuf数组中的字符的个数
            while((len = fr.read(cbuf)) != -1)
            {
                    //每次写出len个字符
                fw.write(cbuf,0,len);
                System.out.println(len);
            }


        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
            //4.关闭流的资源

            //方式一
//            try
//            {
//                if(fw != null)
//                    fw.close();
//            }catch(IOException e)
//            {
//                e.printStackTrace();
//            }finally
//            {
//                try
//                {
//                    if(fr != null)
//                        fr.close();
//                }catch(IOException e)
//                {
//                    e.printStackTrace();
//                }
//            }

            //方式二
            try
            {
                if(fw != null)
                    fw.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                if(fr != null)
                fr.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testInputOutStream()
    {
        FileInputStream input = null;
        FileOutputStream output = null;
        try
        {
            File src = new File("image.jpg");
            File dest = new File("image1.jpg");


            input = new FileInputStream(src);


            output = new FileOutputStream(dest);

            byte[] arr = new byte[5];
            int len;
            while((len = input.read(arr)) != -1)
            {
                output.write(arr,0,len);
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                if(input != null)
                input.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                if(output != null)
                output.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }



    }
    @Test
    public void tset() throws IOException
    {
        File file = new File("hello.txt");
        FileReader fr = new FileReader(file);

        char[] buf = new char[5];
        int len;
        while((len = fr.read(buf)) != -1)
        {
            String str = new String(buf,0,len);
            System.out.print(str);
        }
    }

    @Test
    public void test1() throws IOException
    {
        File file = new File("image.jpg");

        FileInputStream fr = new FileInputStream(file);
        FileOutputStream fw = new FileOutputStream("image2.jpg");

        byte[] buf = new byte[1204];
        int len;

        while((len = fr.read(buf)) != -1)
        {
            fw.write(buf,0,len);
        }

        fr.close();
        fw.close();
    }


}
