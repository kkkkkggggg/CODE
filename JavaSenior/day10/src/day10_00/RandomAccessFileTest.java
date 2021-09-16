package day10_00;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，着在执行过程中自动创建，如果写出到的文件存在
 * ，则会对原文件内容进行覆盖（默认情况下，从头覆盖）
 *
 * 4.可以通过相关的操作，实现RandomAccessFile“插入”数据的效果
 * @acthor KKKKK
 * @creay 2021-04-27-{TIME}
 */
public class RandomAccessFileTest
{
    @Test
    public void test()
    {
        RandomAccessFile raf = null;
        RandomAccessFile raf1 = null;
        try
        {
            raf = new RandomAccessFile(new File("image.jpg"),"r");
            raf1 = new RandomAccessFile(new File("image1.jpg"),"rw");

            byte[] buffer = new byte[1024];
            int len;
            while((len = raf.read(buffer)) != -1)
            {
                raf1.write(buffer,0,len);
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                if(raf != null)
                raf.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                if(raf1 != null)
                raf1.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1()
    {
        RandomAccessFile ras = null;
        try
        {
            ras = new RandomAccessFile(new File("hello.txt"),"rw");
            ras.seek(3);//将指针调到角标为三的位置
            ras.writeBytes("11111111");

            ras.seek(ras.length());//将指针调到文件末尾，实现从文件末尾开始的的添加操作
            ras.writeBytes("222222");

            System.out.println(ras.length());
        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                if(ras != null)
                ras.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    //使用RandomAccessFile实现数据插入效果
    @Test
    public void test2()
    {
        RandomAccessFile raf = null;
        try
        {
            raf = new RandomAccessFile(new File("hello.txt"),"rw");

            int length = (int) raf.length();

            StringBuilder builder = new StringBuilder(length);

            raf.seek(3);//将指针调到角标为三的位置
            //保存指针3后面的所有数据到StringBuilder中
            byte[] buffer =  new byte[length];
            int len;
            while((len = raf.read(buffer)) != -1)
            {
                builder.append(new String(buffer,0,len));
            }

            //调回指针，写入xyz
            raf.seek(3);
            raf.writeBytes("xyz");

            //将StringBuilder中的数据写入文件中
            raf.writeBytes(builder.toString());

            //这是没有考虑到多行数据的写法
//            raf.seek(3);//将指针调到要插入数据的位置上
//            raf.read(buffer,0,length);//从当前指针位置开始将所有数据读到buffer中
//
//            raf.seek(3);//将指针调到要插入数据的位置上
//            raf.writeBytes("abc");//从当前指针位置开始覆盖，覆盖完成后指针在覆盖的最后一个字符处
//
//            raf.write(buffer,0,length - 3);//从当前指针位置开始写入buffer中存储的数据

        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
        {
            try
            {
                if(raf != null)
                raf.close();
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    //思考：将StringBuilder替换为ByteArrayOutputStream

    @Test
    public void test4() throws IOException
    {
        RandomAccessFile raf = new RandomAccessFile("hello.txt","rw");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int length = (int) raf.length();
        byte[] buf = new byte[5];

        raf.seek(3);
        int len;
        while((len = raf.read(buf)) != -1)
        {
            baos.write(buf,0,len);
        }

        raf.seek(3);
        raf.writeBytes("xyz");

        raf.write(baos.toByteArray());

        raf.close();
        baos.close();
    }

}
