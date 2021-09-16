package day09_00;

import org.junit.Test;

import java.io.*;

/**
 *
 * 处理流之一，缓冲流的使用
 * 1.缓冲流
 *  BufferedInputStream
 *  BufferedOutputStream
 *  BufferedReader
 *  BufferedWriter
 *
 * 2.作用：提升流的读取、写入的速度
 *   提高读写速度的原因,内部提供了一个缓冲区
 *
 * 3.处理流，就是“套接在已有的流之上”
 * @acthor KKKKK
 * @creay 2021-04-26-{TIME}
 */
public class BufferedTest
{

    //在不使用缓冲流的情况下，用字节流处理文件的复制
    @Test
    public void teat()
    {
        long start = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bfis = null;
        BufferedOutputStream bfos = null;
        try
        {
            File src = new File("C:\\Users\\user\\Desktop\\01.mkv");

            File dest = new File("C:\\Users\\user\\Desktop\\00.mkv");

            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);

            bfis = new BufferedInputStream(fis);
            bfos = new BufferedOutputStream(fos);


            byte[] buf = new byte[1024];
            int len;
            while((len = bfis.read(buf)) != -1)
            {
                bfos.write(buf,0,len);

//                bfos.flush();//刷新缓冲区
            }

        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {//使用缓冲流时，先关闭外层的流，再关闭内层的流
            //关闭外层的处理流
            try
            {
                if(bfos != null)
                    bfos.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                if(bfis != null)
                    bfis.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }

            //关闭内层的节点流
            //在关闭外层处理流的同时，内层的节点流也会关闭，所以内层流的关闭操作可以省略
//            try
//            {
//                if(fos != null)
//                bfos.close();
//            }catch(IOException e)
//            {
//                e.printStackTrace();
//            }
//            try
//            {
//                if(fis != null)
//                bfis.close();
//            }catch(IOException e)
//            {
//                e.printStackTrace();
//            }

        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);//5723ms,不使用缓冲流
                                        //1536ms,使用缓冲流
    }

    public void testBufferedReaderBufferedWriter()
    {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try
        {
            br = new BufferedReader(new FileReader(new File("hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello1.txt")));

            //方式一：使用char[]数组
//            char[] buf = new char[5];
//            int len;
//            while((len = br.read(buf)) != -1)
//            {
//                bw.write(buf,0,len);
//            }

            //方式二:使用String
            String data;
            while((data = br.readLine()) != null)
            {
                //方法一：
//                bw.write(data + "\n");//data中不包含换行符

                //方法二：
                bw.write(data + "\n");//data中不包含换行符
                bw.newLine();
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                if(bw != null)
                bw.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                if(br != null)
                br.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }



    }
}
